package com.codegym.bai_tap.repository;


import com.codegym.bai_tap.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository implements IPlayerRepository {
    private static final List<Player> playerList = new ArrayList<>();

    static {
        playerList.add(new Player(10, "Nguyễn Văn A", "1995-06-20", 8, "Tiền đạo",
                "https://sieupet.com/sites/default/files/cho-husky-6.jpg"));
        playerList.add(new Player(7, "Lê Văn B", "1998-08-15", 5, "Tiền vệ",
                "https://sieupet.com/sites/default/files/cho-shiba.jpg"));
        playerList.add(new Player(1, "Trần Văn C", "2000-01-01", 3, "Thủ môn",
                "https://sieupet.com/sites/default/files/cho-alaska-1.jpg"));
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