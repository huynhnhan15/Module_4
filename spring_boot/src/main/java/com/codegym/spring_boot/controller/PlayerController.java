package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.dto.PlayerDto;
import com.codegym.spring_boot.entity.Player;
import com.codegym.spring_boot.service.IPlayerService;
import com.codegym.spring_boot.validation.PlayerValidate;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/players")
@SessionAttributes({"lastViewedPlayer", "searchHistory", "visitCount"})
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public String showList(Model model,
                           @CookieValue(value = "visitCount", defaultValue = "0") String visitCount,
                           HttpServletResponse response) {

        int count = Integer.parseInt(visitCount) + 1;
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(count));
        visitCookie.setMaxAge(60 * 60 * 24);
        visitCookie.setPath("/");
        response.addCookie(visitCookie);

        model.addAttribute("visitCount", count);
        model.addAttribute("playerList", playerService.findAll());

        if (!model.containsAttribute("lastViewedPlayer")) {
            model.addAttribute("lastViewedPlayer", null);
        }
        if (!model.containsAttribute("searchHistory")) {
            model.addAttribute("searchHistory", new ArrayList<String>());
        }

        return "player/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("playerDto", new PlayerDto());
        return "player/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("playerDto") PlayerDto playerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        new PlayerValidate().validate(playerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "player/add";
        }

        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.add(player);

        redirectAttributes.addFlashAttribute("mess", "Thêm mới cầu thủ thành công!");
        return "redirect:/players";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Player player = playerService.findById(id);
        if (player == null) {
            return "redirect:/players";
        }

        model.addAttribute("player", player);


        PlayerDto lastViewed = new PlayerDto();
        BeanUtils.copyProperties(player, lastViewed);
        model.addAttribute("lastViewedPlayer", lastViewed);

        return "player/detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchName") String searchName, Model model) {
        List<Player> playerList = playerService.searchByName(searchName);
        model.addAttribute("playerList", playerList);

        @SuppressWarnings("unchecked")
        List<String> searchHistory = (List<String>) model.getAttribute("searchHistory");
        if (searchHistory == null) {
            searchHistory = new ArrayList<>();
        }

        if (!searchName.trim().isEmpty() && !searchHistory.contains(searchName)) {
            searchHistory.add(0, searchName);
            if (searchHistory.size() > 5) {
                searchHistory.remove(5);
            }
        }

        model.addAttribute("searchHistory", searchHistory);
        return "player/list";
    }

    @GetMapping("/clearSession")
    public String clearSession(SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("mess", "Đã xóa Session thành công!");
        return "redirect:/players";
    }
}
