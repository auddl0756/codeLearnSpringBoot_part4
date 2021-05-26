package com.example.demo.repository;

import com.example.demo.entity.Member;
import com.example.demo.entity.Movie;
import com.example.demo.entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    @Test
    public void 리뷰저장(){
        LongStream.rangeClosed(1,30).forEach(i->{
            Member member = Member.builder().id(i).build();
            Movie movie = Movie.builder().id(i).build();

            Review review
                    = Review.builder()
                            .member(member)
                            .movie(movie)
                            .grade((int)Math.random()*5+1)
                            .text("이 영화 감상평... "+i)
                            .build();

            reviewRepository.save(review);
        });

        System.out.println(reviewRepository.findAll().get(0));
    }

//    @Transactional
//    @Test
//    public void 영화리뷰_조회(){
//        Movie movie = Movie.builder().id(1L).build();
//        List<Review> result=reviewRepository.findByMovie(movie);
//
//        for(Review review:result){
//            System.out.println(review.getId());
//            System.out.println(review.getGrade());
//            System.out.println(review.getMember().getEmail());
//        }
//
//        Movie movie2 = Movie.builder().id(2L).build();
//        List<Review> result2=reviewRepository.findByMovie(movie);
//
//        for(Review review:result2){
//            System.out.println(review.getId());
//            System.out.println(review.getGrade());
//            System.out.println(review.getMember().getEmail());
//        }
//    }

    @Test
    public void 영화리뷰_조회(){
        List<Object[]> result=reviewRepository.getMovieWithReviewsAndNicknames(1L);
        System.out.println(result);

        for(Object[] review:result){
            System.out.println(Arrays.toString(review));
        }
    }

    @Test
    public void 영화리뷰_조회_그냥(){       //이렇게 하면 그냥 진짜 리뷰 테이블에 있는 것만 나옴. 연관관계에 있는 것들 안 나옴.
        Movie movie = Movie.builder().id(1L).build();
        List<Review> result = reviewRepository.findByMovie(movie);
        System.out.println(result);

        for(Review review: result){
            System.out.println(review);
        }
    }

    @Transactional
    @Test
    public void 영화리뷰_삭제(){
        Member member = Member.builder().id(1L).build();

        reviewRepository.deleteByMember(member);
        memberRepository.delete(member);

        reviewRepository.findAll().forEach(System.out::println);
    }

}