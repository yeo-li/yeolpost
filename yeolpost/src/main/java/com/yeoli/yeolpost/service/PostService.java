package com.yeoli.yeolpost.service;

import com.yeoli.yeolpost.model.dto.PostGetByTitleResponse;
import com.yeoli.yeolpost.model.dto.PostSaveRequest;
import com.yeoli.yeolpost.model.dto.PostSummaryDto;
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
  public void savePost(PostSaveRequest request) {
    User user = userRepository.findByUserName(request.getUserName())
        .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다." + request.getUserName()));

    Post post = new Post(
        request.getCreatedAt(),
        request.getTitle(),
        request.getContent(),
        user
    );

    postRepository.save(post);
  }

  public List<PostSummaryDto> getAllPosts() {
    return postRepository.findAllPostSummaries();
  }

  public List<PostGetByTitleResponse> getPostsByTitle(String title) {
    return postRepository.findByTitle(title);
  }

  // BCNF 퀴즈 나옴
}
