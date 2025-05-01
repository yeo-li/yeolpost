package com.yeoli.yeolpost.post.dto;

public record PostUpdateRequest(String title, String content) {

  public void validate() {

  }
}
