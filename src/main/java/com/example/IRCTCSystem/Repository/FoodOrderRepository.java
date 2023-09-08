package com.example.IRCTCSystem.Repository;

import com.example.IRCTCSystem.Model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {
}
