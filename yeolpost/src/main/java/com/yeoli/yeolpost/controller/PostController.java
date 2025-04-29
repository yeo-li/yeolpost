package com.yeoli.yeolpost.controller;

import com.yeoli.yeolpost.model.dto.CommonResponse;
import com.yeoli.yeolpost.model.dto.PostCreateRequest;
import com.yeoli.yeolpost.model.dto.PostListResponse;
import com.yeoli.yeolpost.model.dto.PostSearchRequest;
import com.yeoli.yeolpost.model.dto.PostSummaryListResponse;
import com.yeoli.yeolpost.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @PostMapping(value = "api/posts")
  public CommonResponse<Void> createPost(@RequestBody @Valid PostCreateRequest request) {
    postService.savePost(request.toCommand());
    return new CommonResponse<>(200, "게시글 작성 성공", null);
  }

  @GetMapping(value = "/api/posts")
  public CommonResponse<PostSummaryListResponse> getAllPosts() {
    return new CommonResponse<>(200, "게시글 조회 성공", postService.getAllPosts());
  }

  @GetMapping(value = "/api/posts", params = "title")
  public CommonResponse<PostListResponse> getPosts(
      @RequestParam("title") @Valid PostSearchRequest request) {
    return new CommonResponse<>(200, "게시글 검색 성공", postService.getPostsByTitle(request));
  }
}
