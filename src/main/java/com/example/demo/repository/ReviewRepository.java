package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.entity.Movie;
import com.example.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
//    특정 영화의 모든 리뷰와 회원의 닉네임 구하기
    List<Review> findByMovie(Movie movie);

    // 특정 영화의 모든 리뷰와 회원의 닉네임 구하기
    @Query(
            "select mem.nickname,mov,r "+
                    "from Movie  mov left outer join Review  r on r.movie=mov " +
                    "left outer join Member  mem on r.member=mem " +
                    "where mov.id =:movie_id "
    )
    List<Object[]> getMovieWithReviewsAndNicknames(Long movie_id);

//    // 회원을 이용해서 리뷰 삭제하기.. 비효율적
//    void deleteByMember(Member member);

    @Modifying
    @Query("delete from Review r where r.member = :argMember")
    void deleteByMember(Member argMember);
}
