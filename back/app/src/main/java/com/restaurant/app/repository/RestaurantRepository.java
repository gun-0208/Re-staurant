package com.restaurant.app.repository;

import com.restaurant.app.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    public Restaurant findRestaurantByRestaurantIndex(Long index);

}
