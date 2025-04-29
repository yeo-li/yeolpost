package com.yeoli.yeolpost.repository;

import com.yeoli.yeolpost.model.dto.PostGetByTitleResponse;
import com.yeoli.yeolpost.model.dto.PostSummaryDto;
import com.yeoli.yeolpost.model.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("SELECT new com.yeoli.yeolpost.model.dto.PostSummaryDto(p.postId, p.title) FROM Post p")
  List<PostSummaryDto> findAllPostSummaries();

  @Query("SELECT new com.yeoli.yeolpost.model.dto.PostGetByTitleResponse(p.createdAt, p.title, p.content, p.user) FROM Post p WHERE p.title LIKE CONCAT('%', :title, '%')")
  List<PostGetByTitleResponse> findByTitle(@Param("title") String title);
}
