package com.yeoli.yeolpost.model.entity;

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
  private Long post_id;

  @Column(nullable = false, length = 255)
  private String title;

  @Lob
  private String content;

  @Column(nullable = false)
  private LocalDateTime created_at = LocalDateTime.now();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
