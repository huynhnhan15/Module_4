package com.codegym.demo_thymeleaf.service;


import com.codegym.demo_thymeleaf.entity.Player;
import com.codegym.demo_thymeleaf.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(int id) {

        return playerRepository.findById(id);
    }

    @Override
    public boolean add(Player player) {

        return playerRepository.add(player);
    }
}