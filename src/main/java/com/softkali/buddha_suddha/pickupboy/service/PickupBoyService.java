package com.softkali.buddha_suddha.pickupboy.service;

import com.softkali.buddha_suddha.admin.model.SignUpPickupBoyModel;
import com.softkali.buddha_suddha.pickupboy.model.PickupBoy;
import com.softkali.buddha_suddha.pickupboy.repository.PickupBoyRepository;
import com.softkali.buddha_suddha.user.auth.model.AuthUser;
import com.softkali.buddha_suddha.user.auth.model.SignInModel;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PickupBoyService {

    private final PickupBoyRepository pickupBoyRepository;


    public JSONObject signInPickupBboy(SignInModel signInModel) {
        JSONObject jsonObject = new JSONObject();
        Optional<PickupBoy> pickupBoyOptional=pickupBoyRepository.findByPhoneNumber(signInModel.getPhoneNumber());
        if (pickupBoyOptional.isPresent()) {
            PickupBoy pickupBoy = pickupBoyOptional.get();
            if (pickupBoy.getPassword().equals(signInModel.getPassword())){
                jsonObject.put("status", true);
                jsonObject.put("messag", "You are loged in");

                jsonObject.put("data",pickupBoy);
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

    public JSONObject signUpPickupBoy(SignUpPickupBoyModel signUpPickupBoyModel) {
        JSONObject jsonObject = new JSONObject();
        boolean userExists = pickupBoyRepository.findByPhoneNumber(signUpPickupBoyModel.getPhoneNumber()).isPresent();

        if (userExists) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "PhoneNumber already taken");
            return jsonObject;
        }
        String userId= UUID.randomUUID().toString();

        PickupBoy pickupBoy = new PickupBoy(userId,signUpPickupBoyModel.getName(),signUpPickupBoyModel.getPhoneNumber(),
                signUpPickupBoyModel.getPassword(), LocalDateTime.now(),signUpPickupBoyModel.getLocation());
        Long status = pickupBoyRepository.save(pickupBoy).getId();
        if (status == null) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "SignUp Faild");
            return jsonObject;
        }
        jsonObject.put("status", true);
        jsonObject.put("messag", "User Successfully SignUp");
        jsonObject.put("data",pickupBoy);

        return jsonObject;
    }

    public Object getAllPickupBoy(String location) {
        return pickupBoyRepository.findByLocation(location).get();
    }
}
