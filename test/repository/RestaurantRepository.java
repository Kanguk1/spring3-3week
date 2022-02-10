package com.sparta.test.repository;

import com.sparta.test.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    Restaurant findByName(String name);
}








































//    public void createRestaurant(Restaurant restaurant) throws SQLException {
//// DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select max(id) as id from restaurant");
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//// restaurant id 설정 = restaurant 테이블의 마지막 id + 1
//            restaurant.setId(rs.getLong("id") + 1);
//        } else {
//            throw new SQLException("restaurant 테이블의 마지막 id 값을 찾아오지 못했습니다.");
//        }
//        ps = connection.prepareStatement("insert into restaurant(id, name, minOrderPrice, deliveryFee) values(?, ?, ?, ?)");
//        ps.setLong(1, restaurant.getId());
//        ps.setString(2, restaurant.getName());
//        ps.setInt(3, restaurant.getMinOrderPrice());
//        ps.setInt(4, restaurant.getDeliveryFee());
//
//// DB Query 실행
//        ps.executeUpdate();
//
//// DB 연결 해제
//        ps.close();
//        connection.close();
//    }
//
//    public Restaurant getRestaurant(Long id) throws SQLException {
//        Restaurant restaurant = new Restaurant();
//
//// DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select * from restaurant where id = ?");
//        ps.setLong(1, id);
//
//// DB Query 실행
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            restaurant.setId(rs.getLong("id"));
//            restaurant.setName(rs.getString("name"));
//            restaurant.setMinOrderPrice(rs.getInt("minOrderPrice"));
//            restaurant.setDeliveryFee(rs.getInt("deliveryFee"));
//        }
//
//// DB 연결 해제
//        rs.close();
//        ps.close();
//        connection.close();
//
//        return restaurant;
//    }
//
////    public void updateMyprice(Long id, int myprice) throws SQLException {
////// DB 연결
////        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
////
////// DB Query 작성
////        PreparedStatement ps = connection.prepareStatement("update restaurant set myprice = ? where id = ?");
////        ps.setInt(1, myprice);
////        ps.setLong(2, id);
////
////// DB Query 실행
////        ps.executeUpdate();
////
////// DB 연결 해제
////        ps.close();
////        connection.close();
////    }
//
//    public List<Restaurant> getRestaurants() throws SQLException {
//        List<Restaurant> restaurants = new ArrayList<>();
//
//// DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성 및 실행
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from restaurant");
//
//// DB Query 결과를 상품 객체 리스트로 변환
//        while (rs.next()) {
//            Restaurant restaurant = new Restaurant();
//            restaurant.setId(rs.getLong("id"));
//            restaurant.setName(rs.getString("name"));
//            restaurant.setMinOrderPrice(rs.getInt("minOrderPrice"));
//            restaurant.setDeliveryFee(rs.getInt("deliveryFee"));
//            restaurants.add(restaurant);
//        }
//
//// DB 연결 해제
//        rs.close();
//        connection.close();
//
//        return restaurants;
//    }
//}