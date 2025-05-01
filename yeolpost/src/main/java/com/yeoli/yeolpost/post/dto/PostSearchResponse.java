package com.yeoli.yeolpost.post.dto;

import com.yeoli.yeolpost.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record PostSearchResponse(@NotNull LocalDateTime createdAt, @NotBlank String title,
                                 @NotBlank String content, @NotNull User user) {

  public PostSearchResponse(LocalDateTime createdAt, String title, String content, User user) {
    this.createdAt = createdAt;
    this.title = title;
    this.content = content;
    this.user = user;
  }
}
