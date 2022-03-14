package com.softkali.buddha_suddha.addressbook.controller;


import com.softkali.buddha_suddha.addressbook.service.AddressBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/addressBook")
@AllArgsConstructor
public class AddressBookController {
    private final AddressBookService addressBookService;

    @PostMapping(path = "addAddress")
    public Object addAddress(@RequestParam String productDeliverAddress,@RequestParam String userId,@RequestParam String userPhoneNumber){
        return addressBookService.addAddress(productDeliverAddress,userId,userPhoneNumber);
    }
      @PostMapping(path = "deleltAddress")
    public Object deleltAddress(@RequestParam Long id){
        return addressBookService.deleltAddress(id);
    }
      @PostMapping(path = "getAddressByUserId")
    public Object getAddressByUserId(@RequestParam String userId){
        return addressBookService.getAddressByUserId(userId);
    }



}
