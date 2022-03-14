package com.softkali.buddha_suddha.user.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SignUpUserModel {
    private String name;
    private String phoneNumber;
    private String password;

    private String location;
}
