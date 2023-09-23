package com.mjc.school.repository;

import lombok.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private LocalDateTime createDate;
    @NonNull
    private LocalDateTime lastUpdateDate;
    @NonNull
    private Long authorId;

}
