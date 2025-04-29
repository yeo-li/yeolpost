package com.yeoli.yeolpost.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record PostCreateRequest(@NotNull LocalDateTime createdAt, @NotBlank String userName,
                                @NotBlank String title, @NotBlank String content) {

  public PostCreateRequest(LocalDateTime createdAt, String userName, String title, String content) {
    this.createdAt = createdAt;
    this.userName = userName;
    this.title = title;
    this.content = content;
  }

  public PostCreateCommand toCommand() {
    return new PostCreateCommand(createdAt, userName, title, content);
  }
}
