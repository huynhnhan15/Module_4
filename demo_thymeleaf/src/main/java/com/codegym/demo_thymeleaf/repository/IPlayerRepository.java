package com.codegym.demo_thymeleaf.repository;

import com.codegym.demo_thymeleaf.entity.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);

}