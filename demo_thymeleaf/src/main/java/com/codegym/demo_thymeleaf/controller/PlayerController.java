package com.codegym.demo_thymeleaf.controller;

import com.codegym.demo_thymeleaf.entity.Player;
import com.codegym.demo_thymeleaf.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView mav = new ModelAndView("/player/list");
        mav.addObject("playerList", playerService.findAll());
        return mav;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("player", new Player());
        return "/player/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Player player,
                       RedirectAttributes redirectAttributes) {
        playerService.add(player);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/players";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id", defaultValue = "10") int id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        return "/player/detail";
    }

    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable int id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        return "/player/detail";
    }

}