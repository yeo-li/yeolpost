package com.yeoli.yeolpost.service;

import com.yeoli.yeolpost.model.dto.PostCreateCommand;
import com.yeoli.yeolpost.model.dto.PostListResponse;
import com.yeoli.yeolpost.model.dto.PostSearchRequest;
import com.yeoli.yeolpost.model.dto.PostSearchResponse;
import com.yeoli.yeolpost.model.dto.PostSummaryListResponse;
import com.yeoli.yeolpost.model.dto.PostSummaryResponse;
import com.yeoli.yeolpost.model.entity.Post;
import com.yeoli.yeolpost.model.entity.User;
import com.yeoli.yeolpost.repository.PostRepository;
import com.yeoli.yeolpost.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @Transactional
  public void savePost(PostCreateCommand command) {
    User user = userRepository.findByUserName(command.userName())
        .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다." + command.userName()));

    Post post = new Post(
        command.createdAt(),
        command.title(),
        command.content(),
        user
    );

    postRepository.save(post);
  }

  public PostSummaryListResponse getAllPosts() {
    List<PostSummaryResponse> postsSummary = postRepository.findAllPostSummaries();
    return new PostSummaryListResponse(postsSummary);
  }

  public PostListResponse getPostsByTitle(PostSearchRequest request) {
    List<PostSearchResponse> posts = postRepository.findByTitle(request.title());
    return new PostListResponse(posts);
  }

  // BCNF 퀴즈 나옴
}
