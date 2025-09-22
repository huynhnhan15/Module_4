package com.codegym.bai_tap.service;


import com.codegym.bai_tap.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);

}