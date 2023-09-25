package com.mjc.school.repository.domain;

import lombok.*;

import javax.annotation.processing.Generated;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @NonNull
    private Long id;
    @NonNull
    @Size(min = 5, max = 30)
    private String title;
    @NonNull
    @Size(min = 5, max = 255)
    private String content;
    @NonNull
    private LocalDateTime createDate;
    @NonNull
    private LocalDateTime lastUpdateDate;
    @NonNull
    private Long authorId;
}
