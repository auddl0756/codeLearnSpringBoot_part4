package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;


@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String email;

    private String password;

    private String nickname;

}
