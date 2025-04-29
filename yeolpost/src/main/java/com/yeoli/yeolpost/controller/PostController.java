package com.yeoli.yeolpost.controller;

import com.yeoli.yeolpost.model.dto.PostGetByTitleResponse;
import com.yeoli.yeolpost.model.dto.PostSaveRequest;
import com.yeoli.yeolpost.model.dto.PostSummaryDto;
import com.yeoli.yeolpost.service.PostService;
import jakarta.validation.Valid;
import java.util.List;
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
  public void createPost(@RequestBody @Valid PostSaveRequest request) {
    postService.savePost(request);
  }

  @GetMapping(value = "/api/posts")
  public List<PostSummaryDto> getAllPosts() {
    return postService.getAllPosts();
  }

  @GetMapping(value = "/api/posts", params = "title")
  public List<PostGetByTitleResponse> getPosts(@RequestParam("title") String title) {
    return postService.getPostsByTitle(title);
  }
}
