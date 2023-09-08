package com.example.IRCTCSystem.Repository;

import com.example.IRCTCSystem.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
}
