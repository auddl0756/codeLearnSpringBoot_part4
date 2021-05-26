package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@ToString(exclude = "movie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class MovieImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_image_id")
    private Long id;

    private String uuid;

    private String imgName;

    private String path;

    //조인칼럼도 해줘야. 안 써주면 가리키는 pk명을 만드는 규칙에 따라 만들어서 외래키 매핑 실패할 수 있음
    //조인 칼럼 안써주면  movie의 id를 movie_id로 정했기 때문에 "movie_movie_id" 이런 식으로 만들어서 매핑하려고 함.
    @JoinColumn(name="movie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
