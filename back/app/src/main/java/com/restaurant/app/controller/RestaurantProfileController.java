package com.restaurant.app.controller;

import com.restaurant.app.dto.RestaurantDTO;
import com.restaurant.app.dto.RestaurantProfileDTO;
import com.restaurant.app.model.Restaurant;
import com.restaurant.app.model.RestaurantProfile;
import com.restaurant.app.repository.RestaurantProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantprofile")
@CrossOrigin("*")
public class RestaurantProfileController {

    private Object restaurantprofileDTO;
    private RestaurantProfileController restaurantProfileService;

//    @GetMapping("/")
//    public ResponseEntity<?> findAll(){
//        ResponseEntity<?> restaurantProfiles = restaurantProfileService.findAll();
//        //List<RestaurantProfileDTO> dtos = restaurantProfiles.stream().map(restaurantprofileDTO ::new).collect(collectors.tolist());
//        //return ResponseEntity.ok(dtos);
//    }
}
