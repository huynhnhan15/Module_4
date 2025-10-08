package com.codegym.spring_boot.validation;

import com.codegym.spring_boot.dto.PlayerDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.Validate;

public class PlayerValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlayerDto playerDto = (PlayerDto) target;

        if (playerDto.getName() == null || playerDto.getName().trim().isEmpty()) {
            errors.rejectValue("name", "notEmpty", "Tên không được để trống");
        } else if (!playerDto.getName().matches("^[A-Z]\\w*")) {
            errors.rejectValue("name", "name.pattern", "Tên phải bắt đầu bằng chữ hoa");
        }

        if (playerDto.getBirthday() == null || playerDto.getBirthday().trim().isEmpty()) {
            errors.rejectValue("birthday", "notEmpty", "Ngày sinh không được để trống");
        }

        if (playerDto.getExperience() < 0) {
            errors.rejectValue("experience", "min", "Kinh nghiệm phải ≥ 0");
        }

        if (playerDto.getPosition() == null || playerDto.getPosition().trim().isEmpty()) {
            errors.rejectValue("position", "notEmpty", "Vị trí không được để trống");
        }

        if (playerDto.getAvatar() == null || playerDto.getAvatar().trim().isEmpty()) {
            errors.rejectValue("avatar", "notEmpty", "Avatar không được để trống");
        }

        if (playerDto.getDoiTuyenId() == null) {
            errors.rejectValue("doiTuyenId", "notNull", "Phải chọn đội tuyển");
        }
    }
}
