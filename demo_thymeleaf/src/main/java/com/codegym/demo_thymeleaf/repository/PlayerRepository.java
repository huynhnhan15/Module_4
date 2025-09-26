package com.codegym.demo_thymeleaf.repository;
import com.codegym.demo_thymeleaf.entity.Player;
import javax.persistence.TypedQuery;
import com.codegym.demo_thymeleaf.utils.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class    PlayerRepository implements IPlayerRepository {
    @Override
    public List<Player> findAll() {
        List<Player> players = new ArrayList<>();
    Session session = ConnectionUtil.sessionFactory.openSession();
    TypedQuery<Player> query = session.createQuery("from Player", Player.class);
    List<Player> playerList = query.getResultList();
    session.close();
    return playerList;
    }
    @Override
    public Player findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Player player = session.get(Player.class, id);
        session.close();
        return player;
    }
    @Override
    public boolean add(Player player) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();

            session.save(player);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();

            return false;
        }
        return true;
    }
}