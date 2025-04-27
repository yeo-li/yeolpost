package com.yeoli.yeolpost.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Entity
@Getter
@NoArgsConstructor
public class User {

  @Id
  @UUID
  private Long user_id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;
}
