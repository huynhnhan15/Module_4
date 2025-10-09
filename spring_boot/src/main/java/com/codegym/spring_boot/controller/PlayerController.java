package com.codegym.spring_boot.controller;

import com.codegym.spring_boot.dto.PlayerDto;
import com.codegym.spring_boot.entity.DoiTuyen;
import com.codegym.spring_boot.entity.Player;
import com.codegym.spring_boot.service.IPlayerService;
import com.codegym.spring_boot.validation.PlayerValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new PlayerValidate());
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("playerList", playerService.findAll());
        return "/player/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("playerDto", new PlayerDto());
        // load danh sách đội tuyển nếu có
        return "/player/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("playerDto") PlayerDto playerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        new PlayerValidate().validate(playerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/player/add";
        }

        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.add(player);

        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/players";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        return "/player/detail";
    }
}
