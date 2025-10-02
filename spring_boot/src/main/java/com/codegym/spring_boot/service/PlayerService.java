package com.codegym.spring_boot.service;


import com.codegym.spring_boot.entity.Player;
import com.codegym.spring_boot.repository.IPlayerRepository;
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

return playerRepository.findById(id).get();
    }

    @Override
    public boolean add(Player player) {

    return playerRepository.save(player) == null;
    }

    @Override
    public List<Player> searchByName(String name) {
        return playerRepository.findAllByNameContaining(name);
    }

}