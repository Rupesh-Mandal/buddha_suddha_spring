package com.softkali.buddha_suddha.user.auth.service;

import com.softkali.buddha_suddha.product.model.Product;
import com.softkali.buddha_suddha.product.repository.CategoryRepository;
import com.softkali.buddha_suddha.product.repository.ProductRepository;
import com.softkali.buddha_suddha.user.auth.model.AuthUser;
import com.softkali.buddha_suddha.user.auth.model.SignInModel;
import com.softkali.buddha_suddha.user.auth.model.SignUpUserModel;
import com.softkali.buddha_suddha.user.auth.repository.SignUpUserRepository;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final SignUpUserRepository signUpUserRepository;

    public Object signUpUser(SignUpUserModel signUpUserModel) {
        JSONObject jsonObject = new JSONObject();
        boolean userExists = signUpUserRepository.findByPhoneNumber(signUpUserModel.getPhoneNumber()).isPresent();

        if (userExists) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "PhoneNumber already taken");
            return jsonObject;
        }
        String userId= UUID.randomUUID().toString();

        AuthUser authUser = new AuthUser(userId,signUpUserModel.getName(),signUpUserModel.getPhoneNumber(),
                signUpUserModel.getPassword(), LocalDateTime.now(),signUpUserModel.getLocation());
        Long status = signUpUserRepository.save(authUser).getId();
        if (status == null) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "SignUp Faild");
            return jsonObject;
        }
        jsonObject.put("status", true);
        jsonObject.put("messag", "User Succefully SignUp");
        jsonObject.put("authUser",authUser);

        return jsonObject;
    }

    public Object signInUser(SignInModel signInModel) {
        JSONObject jsonObject = new JSONObject();
        Optional<AuthUser> authUserOptional=signUpUserRepository.findByPhoneNumber(signInModel.getPhoneNumber());

        if (authUserOptional.isPresent()) {
            AuthUser authUser = authUserOptional.get();
            if (authUser.getPassword().equals(signInModel.getPassword())){
                jsonObject.put("status", true);
                jsonObject.put("messag", "You are loged in");

                jsonObject.put("authUser",authUser);
                return jsonObject;
            }else {
                jsonObject.put("status", false);
                jsonObject.put("messag", "Please Provide Correct Password");
                return jsonObject;
            }



        } else {
            jsonObject.put("status", false);
            jsonObject.put("messag", "You are not a register user");
            return jsonObject;
        }
    }



}
