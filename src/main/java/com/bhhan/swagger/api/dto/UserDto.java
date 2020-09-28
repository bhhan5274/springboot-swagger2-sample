package com.bhhan.swagger.api.dto;

import com.bhhan.swagger.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */
public class UserDto {

    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserReq {
        @NotNull(message = "First Name cannot be null")
        private String firstName;

        @Min(value = 15, message = "Age should not be less than 15")
        @Max(value = 65, message = "Age should not be greater than 65")
        private int age;

        @Email(message = "Email should be valid")
        private String email;

        @Builder
        public UserReq(String firstName, int age, String email){
            this.firstName = firstName;
            this.age = age;
            this.email = email;
        }

        public User toEntity(){
            return User.builder()
                    .firstName(this.firstName)
                    .age(this.age)
                    .email(this.email)
                    .build();
        }
    }


    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserRes {
        private Long id;
        private String firstName;
        private int age;
        private String email;

        public UserRes(User user){
            this.id = user.getId();
            this.firstName = user.getFirstName();
            this.age = user.getAge();
            this.email = user.getEmail();
        }
    }
}
