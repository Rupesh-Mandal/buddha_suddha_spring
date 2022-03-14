package com.softkali.buddha_suddha.admin.controller;

import com.softkali.buddha_suddha.admin.model.AddProductModel;
import com.softkali.buddha_suddha.admin.model.Location;
import com.softkali.buddha_suddha.product.model.Product;
import com.softkali.buddha_suddha.admin.model.SignUpPickupBoyModel;
import com.softkali.buddha_suddha.admin.service.AdminService;
import com.softkali.buddha_suddha.pickupboy.service.PickupBoyService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "admin/api/v1")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final PickupBoyService pickupBoyService;

    @PostMapping(path = "sign_up_pickup_boy")
    public JSONObject signUpPickupBoy(@RequestBody SignUpPickupBoyModel signUpPickupBoyModel){
        return pickupBoyService.signUpPickupBoy(signUpPickupBoyModel);
    }

     @PostMapping(path = "getAllPickupBoy")
    public Object getAllPickupBoy(@RequestParam String location){
        return pickupBoyService.getAllPickupBoy(location);
    }

    
    
    @PostMapping(path = "sign_in")
    public Object signIn(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("password") String password){
        return adminService.signInAdmin(mobileNumber,password);
    }

    @PostMapping(path = "add_product")
    public Object addProduct(@RequestBody AddProductModel addProductModel){
        return adminService.addProduct(addProductModel);
    }

    @PostMapping(path = "update_product")
    public Object updateProduct(@RequestBody Product product){
        return adminService.updateProduct(product);
    }

    @PostMapping(path = "get_all_product")
    public Object getAllProoductSeller(@RequestParam("location") String location){
        return adminService.getAllProduct(location);
    }

    @PostMapping(path = "delet_product")
    public Object deletProoduct(@RequestBody Product product){
        return adminService.deletProduct(product);
    }

    @PostMapping(path = "add_location")
    public Object addLocation(@RequestParam("name") String name){
        return adminService.addLocation(name);
    }

    @PostMapping(path = "delet_location")
    public Object deletLocation(@RequestBody Location location){
        return adminService.deletLocation(location);
    }

    @GetMapping(path = "getAllLocation")
    public Object getAllLocation(){
        return adminService.getAllLocation();
    }

    @GetMapping(path = "getAllCategory")
    public Object getAllCategory(){
        return adminService.getAllCategory();
    }

    @PostMapping(path = "addCategory")
    public Object addCategory(@RequestParam("name") String name){
        return adminService.addCategory(name);
    }


}
