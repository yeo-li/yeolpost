package com.yeoli.yeolpost.post.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record PostListResponse(@NotNull List<PostSearchResponse> posts) {

  public PostListResponse(List<PostSearchResponse> posts) {
    this.posts = posts;
  }

}
