package com.mjc.school.repository.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
