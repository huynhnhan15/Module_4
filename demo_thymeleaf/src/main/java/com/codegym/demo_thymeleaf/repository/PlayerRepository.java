package com.codegym.demo_thymeleaf.repository;
import com.codegym.demo_thymeleaf.entity.Player;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class    PlayerRepository implements IPlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Player> findAll() {
    List<Player> playerList = new ArrayList<>();
    TypedQuery<Player> query = entityManager.createQuery("from Player ", Player.class);
    playerList = query.getResultList();
    return playerList;
    }
    @Override
    public Player findById(int id) {
        Player player = entityManager.find(Player.class, id);
        return player;
    }
    @Override
    public boolean add(Player player) {
        try{
            entityManager.persist(player);

        }catch(Exception e){
            return false;
        }
        return true;
    }
}