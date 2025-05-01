package com.yeoli.yeolpost.post.dto;

import java.time.LocalDateTime;

public record PostCreateCommand(LocalDateTime createdAt, String userName, String title,
                                String content) {

}
