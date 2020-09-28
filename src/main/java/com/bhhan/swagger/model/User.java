package com.bhhan.swagger.model;

import com.bhhan.swagger.api.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    private String firstName;

    private int age;

    @Column(unique = true)
    private String email;

    public User updateUser(UserDto.UserReq userReq){
        this.firstName = userReq.getFirstName();
        this.age = userReq.getAge();
        this.email = userReq.getEmail();

        return this;
    }

    @Builder
    public User(Long id, String firstName, int age, String email){
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
    }
}
