package com.sparta.test.controller;


import com.sparta.test.model.Restaurant;
import com.sparta.test.dto.RestaurantDto;
import com.sparta.test.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class RestaurantController {

    private final RestaurantService restaurantService;  // @RequiredArgsConstructor까지!

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {
        Restaurant restaurant = restaurantService.createRestaurant(requestDto);

        return restaurant;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> findAllRestaurant(
    ) {
        return restaurantService.findAllRestaurant();
    }
}


//    // 음식점 조회
//    @GetMapping("/api/restaurants")
//    public List<Restaurant> findAllRestaurants() {
//
//    // 응답 보내기
//        return restaurantsServive.findAllRestaurants();
//    }
//}
