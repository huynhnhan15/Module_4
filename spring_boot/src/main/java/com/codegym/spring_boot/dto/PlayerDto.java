package com.codegym.spring_boot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {
    private int id;
    private String name;
    private String birthday;
    private int experience;
    private String position;
    private String avatar;
    private Integer doiTuyenId;
}
