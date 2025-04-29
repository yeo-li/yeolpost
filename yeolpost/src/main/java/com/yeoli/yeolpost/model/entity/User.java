package com.yeoli.yeolpost.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

  @Id
  private String userId;

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false)
  private String password;

  @PrePersist
  public void generateUUID() {
    if (this.userId == null) {
      this.userId = UUID.randomUUID().toString();
    }
  }

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
    generateUUID();
  }
}
