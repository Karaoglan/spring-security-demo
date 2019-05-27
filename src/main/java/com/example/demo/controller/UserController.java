package com.example.demo.controller;

import com.example.demo.domain.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class UserController {

    @PostMapping("/registration")
    public UserDto register(@RequestBody UserDto accountDto) {
        return accountDto;
    }

    @PostMapping("/user/registration")
    public ResponseEntity<UserDto> registerUserAccount(@RequestBody @Valid UserDto accountDto) {
        /* UserDto registered = new UserDto();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }*/
        // rest of the implementation
        return ResponseEntity.ok(accountDto);
    }
/*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }*/

    private UserDto createUserAccount(UserDto accountDto, BindingResult result) {
        // UserDto registered = null;
        return accountDto;
    }
}
