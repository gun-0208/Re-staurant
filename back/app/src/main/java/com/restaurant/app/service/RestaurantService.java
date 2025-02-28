package com.restaurant.app.service;

import com.restaurant.app.DTO.RestaurantDTO;
import com.restaurant.app.model.Restaurant;
import com.restaurant.app.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
//    public List<Restaurant> findAll() {
//        return restaurantRepository.findAll();}

    public Restaurant createPlaceInfo(RestaurantDTO restaurantDTO) {

        if(restaurantRepository.findRestaurantByBusId(restaurantDTO.getBusId()) != null) {
            throw new RuntimeException("이미 DB에 저장되어있습니다.");
        }

        Restaurant restaurant = Restaurant.builder()
                                .busId(restaurantDTO.getBusId())
                                .restaurantCategory(restaurantDTO.getRestaurantCategory())
                                .restaurantName(restaurantDTO.getRestaurantName())
                                .tellNumber(restaurantDTO.getTellNumber())
                                .fullAddress(restaurantDTO.getFullAddress())
                                .fullRoadAddress(restaurantDTO.getFullRoadAddress())
                                .siCode(restaurantDTO.getSiCode())
                                .guCode(restaurantDTO.getGuCode())
                                .dongCode(restaurantDTO.getDongCode())
                                .businessHourInfo(restaurantDTO.getBusinessHourInfo())
                                .description(restaurantDTO.getDescription())
                                .x(restaurantDTO.getX())
                                .y(restaurantDTO.getY())
                                .avgRating(restaurantDTO.getAvgRating())
                                .authorCount(restaurantDTO.getAuthorCount())
                                .build();

        return restaurantRepository.save(restaurant);
    }

//
    public List<Restaurant> findRestaurantByName(String restaurantName){
        List<Restaurant> restaurantList = restaurantRepository.findRestaurantByRestaurantNameContainingIgnoreCase(restaurantName);

        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }


    @Transactional
    public Restaurant findRestaurantByBusId(String busId) {
        Restaurant restaurant = restaurantRepository.findRestaurantByBusId(busId);

        if (restaurant == null) {
            throw new RuntimeException("해당 식당이 없습니다.");
        }

        return restaurant;
    }


    public List<Restaurant>  findRestaurantBySiCode(String siCode){
        List<Restaurant> restaurantList  = restaurantRepository.findRestaurantBySiCode(siCode);

        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }

    public List<Restaurant>  findRestaurantBySiCodeAndGuCode(String siCode ,String guCode){
        List<Restaurant> restaurantList  = restaurantRepository.findRestaurantBySiCodeAndGuCode(siCode, guCode);


        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }

    public List<Restaurant>  findRestaurantBySiCodeAndGuCodeAndDongCode(String siCode ,String guCode,String dongCode){
        List<Restaurant> restaurantList  = restaurantRepository.findRestaurantBySiCodeAndGuCodeAndDongCode(siCode, guCode, dongCode);


        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }


    public List<Restaurant> findRestaurantByRestaurantCategory(String restaurantCategory){
        List<Restaurant> restaurantList  = restaurantRepository.findRestaurantByRestaurantCategoryContainingIgnoreCase(restaurantCategory);


        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }

    public List<Restaurant> findRestaurant(RestaurantDTO restaurantDTO){
        List<Restaurant> restaurantList  = restaurantRepository.findRestaurantByRestaurantCategoryContainingIgnoreCaseOrRestaurantNameContainingIgnoreCase(restaurantDTO.getRestaurantCategory(), restaurantDTO.getRestaurantCategory());


        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }

    public List<Restaurant> findRestaurantByRestaurantCategoryOrRestaurantName(String restaurantCategory,String restaurantName){
        List<Restaurant> restaurantList  = restaurantRepository.findRestaurantByRestaurantCategoryContainingIgnoreCaseOrRestaurantNameContainingIgnoreCase(restaurantCategory,restaurantName);


        if (restaurantList.size() == 0) {
            throw new RuntimeException("식당이 없습니다.");
        }

        return restaurantList;
    }







}
