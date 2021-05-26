package com.example.demo.repository;

import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.LongStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository imageRepository;

//    @Transactional
//    @Test
//    public void 영화_영화이미지_저장(){
//        LongStream.rangeClosed(1,30).forEach(i->{
//            Movie movie = Movie.builder().title("movie"+i).build();
//            movieRepository.save(movie);
//
//            int count=(int)(Math.random()*5)+1;
//
//            for(int j=0;j<count;j++){
//                MovieImage movieImage
//                        = MovieImage.builder()
//                            .uuid(UUID.randomUUID().toString())
//                            .movie(movie)
//                            .imgName("test"+j+".jpg").build();
//
//                imageRepository.save(movieImage);
//            }
//
//            System.out.println(movieRepository.findAll().get(0));
//            System.out.println(imageRepository.findAll().get(0));
//        });
//    }

    @Test
    public void 페이징test(){
        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"id"));
        Page<Object[]> result = movieRepository.getListPage(pageRequest);

        for(Object[] objects:result.getContent()){
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void 특정영화_모든이미지_가져오기(){
        List<Object[]> result = movieRepository.getMovieWithAll(1L);
        System.out.println(result);

        for(Object[] arr:result){
            System.out.println(Arrays.toString(arr));
        }
    }




}