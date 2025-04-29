package com.yeoli.yeolpost.repository;

import com.yeoli.yeolpost.model.dto.PostSearchResponse;
import com.yeoli.yeolpost.model.dto.PostSummaryResponse;
import com.yeoli.yeolpost.model.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("SELECT new com.yeoli.yeolpost.model.dto.PostSummaryResponse(p.postId, p.title) FROM Post p")
  List<PostSummaryResponse> findAllPostSummaries();

  @Query("SELECT new com.yeoli.yeolpost.model.dto.PostSearchResponse(p.createdAt, p.title, p.content, p.user) FROM Post p WHERE p.title LIKE CONCAT('%', :title, '%')")
  List<PostSearchResponse> findByTitle(@Param("title") String title);
}
