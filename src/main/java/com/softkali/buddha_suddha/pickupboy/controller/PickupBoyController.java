package com.softkali.buddha_suddha.pickupboy.controller;

import com.softkali.buddha_suddha.pickupboy.service.PickupBoyService;
import com.softkali.buddha_suddha.user.auth.model.SignInModel;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "pickboy/api/v1")
@AllArgsConstructor
public class PickupBoyController {
    private final PickupBoyService pickupBoyService;

    @PostMapping(path = "sign_in_pickup_boy")
    public JSONObject signInPickupBboy(@RequestBody SignInModel signInModel){
        return pickupBoyService.signInPickupBboy(signInModel);
    }


}
