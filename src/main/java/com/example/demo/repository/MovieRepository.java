package com.example.demo.repository;

import com.example.demo.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
//    @Query("select m,avg(coalesce(r.grade,0)), count(distinct r) from Movie m "+ "left outer join Review r on r.movie = m group by m")
//    Page<Object[]> getListPage(Pageable pageable);

    //페이지 처리
    //select에서 max쓰면 n+1문제 발생함..
    @Query(
            "select m,mi,avg(coalesce(r.grade,0)), count(distinct r) from Movie m "
            +"left outer join MovieImage mi on mi.movie = m "
            +"left outer join Review r on r.movie = m group by m"
    )
    Page<Object[]> getListPage(Pageable pageable);

//    //특정 영화 조회
//    @Query(
//            "select m,mi "
//            +"from Movie  m left outer join MovieImage mi on mi.movie=m "
//            +"where m.id = :id"
//    )
//    List<Object[]> getMovieWithAll(Long id);

    //특정 영화의 모든 이미지와 이미지별 평균 평점/리뷰 개수 조회
    @Query(
            "select m,mi,avg(coalesce(r.grade,0)),count(r)"+
                    "from Movie m left outer join MovieImage mi on mi.movie = m " +
                    "left outer join Review r on r.movie=m "+
                    "where m.id = :id group by mi"
    )
    List<Object[]> getMovieWithAll(Long id);



}
