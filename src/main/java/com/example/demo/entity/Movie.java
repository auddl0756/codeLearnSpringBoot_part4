package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Movie extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Long id;

    private String title;
}
