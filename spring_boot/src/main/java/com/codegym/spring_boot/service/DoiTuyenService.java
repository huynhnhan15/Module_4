package com.codegym.spring_boot.service;

import com.codegym.spring_boot.entity.DoiTuyen;
import com.codegym.spring_boot.repository.IDoiTuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoiTuyenService implements IDoiTuyenService {

    @Autowired
    private IDoiTuyenRepository doiTuyenRepository;
    @Override
    public List<DoiTuyen> findAll() {
        return List.of();
    }
}
