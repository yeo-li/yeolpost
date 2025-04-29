package com.yeoli.yeolpost.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostSaveRequest {

  @NotNull
  private LocalDateTime createdAt;

  @NotBlank
  private String userName;

  @NotBlank
  private String title;

  @NotBlank
  private String content;

  public PostSaveRequest(LocalDateTime createdAt, String userName, String title, String content) {
    this.createdAt = createdAt;
    this.userName = userName;
    this.title = title;
    this.content = content;
  }
}
