package com.yeoli.yeolpost.model.dto;

import jakarta.validation.constraints.NotBlank;

public record PostSearchRequest(@NotBlank String title) {

}
