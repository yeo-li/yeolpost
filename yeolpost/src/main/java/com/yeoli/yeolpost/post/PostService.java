package com.yeoli.yeolpost.post;

import com.yeoli.yeolpost.post.dto.PostCreateCommand;
import com.yeoli.yeolpost.post.dto.PostListResponse;
import com.yeoli.yeolpost.post.dto.PostSearchRequest;
import com.yeoli.yeolpost.post.dto.PostSearchResponse;
import com.yeoli.yeolpost.post.dto.PostSummaryListResponse;
import com.yeoli.yeolpost.post.dto.PostSummaryResponse;
import com.yeoli.yeolpost.user.User;
import com.yeoli.yeolpost.user.UserRepository;
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
