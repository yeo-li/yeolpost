package com.yeoli.yeolpost.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.yeoli.yeolpost.post.Post;
import com.yeoli.yeolpost.post.PostRepository;
import com.yeoli.yeolpost.user.User;
import com.yeoli.yeolpost.user.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class PostRepositoryTest {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private UserRepository userRepository;

  @Test
  void 게시글을_저장하고_조회한다() {
    // given
    User user = new User("user1", "password");
    userRepository.save(user);

    Post post = new Post(LocalDateTime.now(), "hello post", "반갑습니다 여러분 테스트 글이에용~", user);
    postRepository.save(post);

    // when
    Post foundPost = postRepository.findById(post.getPostId())
        .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

    // then
    assertThat(foundPost.getTitle()).isEqualTo("hello post");
    assertThat(foundPost.getContent()).isEqualTo("반갑습니다 여러분 테스트 글이에용~");
    assertThat(foundPost.getUser().getUserName()).isEqualTo("user1");
  }

}