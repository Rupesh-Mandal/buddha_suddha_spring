package com.softkali.buddha_suddha.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SignUpPickupBoyModel {
    private String name;
    private String phoneNumber;
    private String password;

    private String location;
}
