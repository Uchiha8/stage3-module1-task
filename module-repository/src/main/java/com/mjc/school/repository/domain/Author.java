package com.mjc.school.repository.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
