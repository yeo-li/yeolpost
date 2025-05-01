package com.yeoli.yeolpost.post.dto;

import jakarta.validation.constraints.NotBlank;

public record PostSearchRequest(@NotBlank String title) {

}
