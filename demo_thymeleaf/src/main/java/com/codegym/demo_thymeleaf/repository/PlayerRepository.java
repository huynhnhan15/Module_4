package com.codegym.demo_thymeleaf.repository;


import com.codegym.demo_thymeleaf.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class    PlayerRepository implements IPlayerRepository {
    private static final List<Player> playerList = new ArrayList<>();

    static {
        playerList.add(new Player(10, "Nguyễn Văn A", "1995-06-20", 8, "Tiền đạo",
                "https://tse3.mm.bing.net/th/id/OIP.wxESHlKFb-MdSq_yUnzv8QHaKP?pid=Api&P=0&h=180"));
        playerList.add(new Player(7, "Lê Văn B", "1998-08-15", 5, "Tiền vệ",
                "https://tse4.mm.bing.net/th/id/OIP.x2fmI_sY76w6453LjPK0pwHaNK?pid=Api&P=0&h=180"));
        playerList.add(new Player(1, "Trần Văn C", "2000-01-01", 3, "Thủ môn",
                "https://tse3.mm.bing.net/th/id/OIP.8PQELmhmkKMtjgTFmt7pDAHaEK?pid=Api&P=0&h=180"));
    }

    @Override
    public List<Player> findAll() {
        return playerList;
    }

    @Override
    public Player findById(int id) {
        return playerList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean add(Player player) {
        return playerList.add(player);
    }
}