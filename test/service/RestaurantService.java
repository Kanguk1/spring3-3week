package com.sparta.test.service;

import com.sparta.test.dto.RestaurantDto;
import com.sparta.test.model.Restaurant;
import com.sparta.test.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service   //
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;  //

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(RestaurantDto requestDto) {
// 요청받은 DTO 로 DB에 저장할 객체 만들기
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if (!(1000 <= minOrderPrice && minOrderPrice <= 100000)) {

            throw new IllegalArgumentException("최소주문 가격값이 아닙니다.");
        }
        if (minOrderPrice % 100 > 0) {
            throw new IllegalArgumentException("100원 단위로 입력하세요.");
        }
        if (0 > deliveryFee || deliveryFee > 10_000) {
            throw new IllegalArgumentException("기본 배달비 값이 아닙니다.");
        }
        if (deliveryFee % 500 > 0) {
            throw new IllegalArgumentException("기본 배달비 500원 단위로 입력하세요.");
        }

        Restaurant restaurant = new Restaurant(requestDto);

        restaurantRepository.save(restaurant);

        return restaurant;
    }


    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }
}


//
//
//    public Restaurant createRestaurant(RestaurantDto requestDto) {
//
//
//        Restaurant res = new Restaurant();
//        return res;
//    }



//- 음식점 정보 입력받아 등록
//        1. 음식점 이름 (name)
//        2. 최소주문 가격 (minOrderPrice)
//        1. 허용값: 1,000원 ~ 100,000원 입력
//        2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
//        3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
//
//        3. 기본 배달비 (deliveryFee)
//        1. 허용값: 0원 ~ 10,000원
//        2. 500 원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능)
//        3. 허용값이 아니거나 1,000원 단위 입력이 아닌 경우 에러 발생시킴
//
//        - 음식점 조회
//        - 등록된 모든 음식점 정보 조회 가능
//        1. 등록 시 입력한 음식점 정보 (name, minOrderPrice, deliveryFee)
//        2. DB 테이블 ID (id)


//    public Restaurant updateRestaurant(Long id, RestaurantMypriceRequestDto requestDto) throws SQLException {
//        RestaurantRepository restaurantRepository = new RestaurantRepository();
//        Restaurant restaurant = restaurantRepository.getRestaurant(id);
//        if (restaurant == null) {
//            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
//        }
//
//        int myprice = requestDto.getMyprice();
//        restaurantRepository.updateMyprice(id, myprice);
//
//        return restaurant;
//    }

//    public List<Restaurant> getRestaurants() throws SQLException {
//        RestaurantRepository restaurantRepository = new RestaurantRepository();
//        List<Restaurant> restaurants = restaurantRepository.getRestaurants();
//
//        return restaurants;
//    }