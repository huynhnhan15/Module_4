package com.codegym.spring_boot.service;


import com.codegym.spring_boot.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);
    List<Player> searchByName(String name);
}