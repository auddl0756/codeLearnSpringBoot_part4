package com.example.demo;

import com.example.demo.entity.Member;
import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieImage;
import com.example.demo.entity.Review;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MovieImageRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.stream.LongStream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository imageRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {
//        LongStream.rangeClosed(1,30).forEach(i->{
//            //영화 샘플 데이터 저장
//            Movie movie = Movie.builder().title("movie"+i).build();
//            movieRepository.save(movie);
//
//            int count=(int)(Math.random()*5)+1;
//
//            for(int j=0;j<count;j++){
//                MovieImage movieImage
//                        = MovieImage.builder()
//                        .uuid(UUID.randomUUID().toString())
//                        .movie(movie)
//                        .imgName("test"+j+".jpg").build();
//
//                //영화 이미지 샘플 데이터 저장
//                imageRepository.save(movieImage);
//            }
//
//            //멤버 샘플 데이터 저장
//            Member member
//                    = Member.builder()
//                    .email("email"+i)
//                    .password("1111"+i)
//                    .nickname("nickname"+i)
//                    .build();
//
//            memberRepository.save(member);
//
//            Review review
//                    = Review.builder()
//                    .member(member)
//                    .movie(movie)
//                    .grade((int)Math.random()*5+1)
//                    .text("이 영화 감상평... "+i)
//                    .build();
//
//            reviewRepository.save(review);
//        });
    }
}
