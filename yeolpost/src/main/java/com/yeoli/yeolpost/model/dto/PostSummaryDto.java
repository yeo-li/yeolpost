package com.yeoli.yeolpost.model.dto;

import lombok.Getter;

@Getter
public class PostSummaryDto {

  private Long postId;
  private String title;

  public PostSummaryDto(Long postId, String title) {
    this.postId = postId;
    this.title = title;
  }
}
