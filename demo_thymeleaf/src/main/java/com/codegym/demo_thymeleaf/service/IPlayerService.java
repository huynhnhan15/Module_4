package com.codegym.demo_thymeleaf.service;


import com.codegym.demo_thymeleaf.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);

}