package com.bhhan.swagger.api;

import com.bhhan.swagger.api.dto.UserDto;
import com.bhhan.swagger.api.error.Error;
import com.bhhan.swagger.api.error.ErrorCode;
import com.bhhan.swagger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApi {
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto.UserRes> readUsers(){
        return userService.readUsers();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto.UserRes readUser(@PathVariable Long userId){
        return userService.readUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto.UserRes createUser(@RequestBody @Valid UserDto.UserReq userReq){
        return userService.createUser(userReq);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto.UserRes updateUser(@PathVariable Long userId, @RequestBody @Valid UserDto.UserReq userReq){
        return userService.updateUser(userReq, userId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        return Error.builder()
                .errorCode(ErrorCode.BAD_PARAMETER)
                .fieldErrors(bindingResult.getFieldErrors())
                .build();
    }
}
