package com.codegym.bai_tap.repository;

import com.codegym.bai_tap.entity.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);

}