package com.yeoli.yeolpost.model.dto;

import java.time.LocalDateTime;

public record PostCreateCommand(LocalDateTime createdAt, String userName, String title,
                                String content) {
  
}
