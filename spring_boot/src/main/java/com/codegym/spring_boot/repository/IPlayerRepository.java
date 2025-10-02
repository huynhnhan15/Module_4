package com.codegym.spring_boot.repository;


import com.codegym.spring_boot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByNameContaining(String name);

    @Query(value = "SELECT * FROM student where name like :searchName ;",nativeQuery = true)
    List<Player> findByName1(@Param("searchName") String name);
}