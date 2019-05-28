package com.example.demo.controller;

import com.example.demo.domain.UserDto;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/registration")
    public UserDto register(@RequestBody UserDto accountDto) {
        return accountDto;
    }

    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(@Valid @RequestBody UserDto accountDto) {
        /* UserDto registered = new UserDto();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }*/
        // rest of the implementation
        if (accountDto.getFirstName().equals("Burak")) {
            throw new UserAlreadyExistException();
        }

        if (accountDto.getFirstName().equals("1")) {
            throw new RuntimeException();
        }

        return new GenericResponse(accountDto);

        //return new GenericResponse(messageSource.getMessage("message.post.success", new Object[] {"UserDto"}, LocaleContextHolder.getLocale()));
    }
/*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(exception -> {
            String fieldName = ((FieldError) exception).getField();
            String errorCode = exception.getDefaultMessage();
            errors.put(fieldName, errorCode);
        });
        return errors;
    }*/

    private UserDto createUserAccount(UserDto accountDto, BindingResult result) {
        // UserDto registered = null;
        return accountDto;
    }
}
