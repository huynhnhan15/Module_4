package com.codegym.spring_boot.repository;

import com.codegym.spring_boot.entity.DoiTuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.yaml.snakeyaml.tokens.Token.ID.Value;

public interface IDoiTuyenRepository extends JpaRepository<DoiTuyen,Integer> {

    @Query(value = "select c.name, count(s.id) as quality from player s join doi_tuyen c on s.class_id=c.id group by c.id ;"
            ,nativeQuery = true)
    List<DoiTuyen> findByClass();
}
