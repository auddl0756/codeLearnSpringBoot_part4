package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;

@ToString(exclude = {"movie","member"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private Long id;

    @JoinColumn(name="movie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @JoinColumn(name="member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private int grade;

    private String text;

}
