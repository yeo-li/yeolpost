package com.yeoli.yeolpost.post.dto;

public record CommonResponse<T>(int status, String message, T data) {

  public CommonResponse(int status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }
}
