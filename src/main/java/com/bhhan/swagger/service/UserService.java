package com.bhhan.swagger.service;

import com.bhhan.swagger.api.dto.UserDto;
import com.bhhan.swagger.model.User;
import com.bhhan.swagger.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto.UserRes createUser(UserDto.UserReq userReq){
        return new UserDto.UserRes(userRepository.save(userReq.toEntity()));
    }

    public UserDto.UserRes readUser(Long userId){
        return new UserDto.UserRes(userRepository.findById(userId).orElseThrow(IllegalArgumentException::new));
    }

    public List<UserDto.UserRes> readUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserDto.UserRes::new)
                .collect(Collectors.toList());
    }

    public UserDto.UserRes updateUser(UserDto.UserReq userReq, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(IllegalArgumentException::new);

        return new UserDto.UserRes(user.updateUser(userReq));
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
