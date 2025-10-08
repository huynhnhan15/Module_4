package com.codegym.spring_boot.service;

import com.codegym.spring_boot.entity.DoiTuyen;

import java.util.List;

public interface IDoiTuyenService {
    List<DoiTuyen> findAll();
}
