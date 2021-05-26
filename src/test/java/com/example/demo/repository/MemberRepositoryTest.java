package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    @Test
    public void 멤버저장(){
        LongStream.rangeClosed(1,30).forEach(i->{
            Member member
                    = Member.builder()
                            .email("email"+i)
                            .password("1111"+i)
                            .nickname("nickname"+i)
                            .build();

            memberRepository.save(member);
        });
    }

}