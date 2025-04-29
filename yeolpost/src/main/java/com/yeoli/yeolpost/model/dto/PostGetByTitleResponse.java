package com.yeoli.yeolpost.model.dto;

import com.yeoli.yeolpost.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostGetByTitleResponse {

  @NotNull
  private final LocalDateTime createdAt;
  @NotBlank
  private final String title;
  @NotBlank
  private final String content;
  @NotNull
  private final User user;

  public PostGetByTitleResponse(LocalDateTime createdAt, String title, String content, User user) {
    this.createdAt = createdAt;
    this.title = title;
    this.content = content;
    this.user = user;
  }
}
