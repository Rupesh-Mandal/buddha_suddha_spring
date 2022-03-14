package com.softkali.buddha_suddha.user.auth.controller;

import com.softkali.buddha_suddha.user.auth.model.SignInModel;
import com.softkali.buddha_suddha.user.auth.model.SignUpUserModel;
import com.softkali.buddha_suddha.user.auth.service.AuthService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "sign_up_user")
    public Object signUpUser(@RequestBody SignUpUserModel signUpModel) {
        return authService.signUpUser(signUpModel);
    }

    @PostMapping(path = "sign_in_user")
    public Object signInUser(@RequestBody SignInModel signInModel) {
        return authService.signInUser(signInModel);
    }



}
