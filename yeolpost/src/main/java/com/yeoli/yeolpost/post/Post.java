package com.yeoli.yeolpost.post;

import com.yeoli.yeolpost.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post {

  @Id // PK 라는 뜻
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId;

  @Column(nullable = false, length = 255)
  private String title;

  @Lob
  private String content;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public Post(LocalDateTime createdAt, String title, String content, User user) {
    this.createdAt = createdAt;
    this.title = title;
    this.content = content;
    this.user = user;
  }

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
