package com.restaurant.app.controller;


import com.restaurant.app.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
@CrossOrigin("*")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public void findAll() {
    }
}
