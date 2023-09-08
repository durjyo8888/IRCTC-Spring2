package com.example.IRCTCSystem.Service;

import com.example.IRCTCSystem.Model.FoodOrder;
import com.example.IRCTCSystem.Model.Passenger;
import com.example.IRCTCSystem.Repository.FoodOrderRepository;
import com.example.IRCTCSystem.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodOrderService {
    @Autowired
    FoodOrderRepository foodOrderRepository;

    @Autowired
    PassengerRepository passengerRepository;
    public void addOrder(FoodOrder order) {
        foodOrderRepository.save(order);
    }

    public int getPriceByPassenger(int trainId, Date date) {
        int price = 0;
        List<Passenger> passengerList = passengerRepository.findAll();
//        Passenger passenger = passengerRepository.findAllById(date);
        List<FoodOrder> foodOrderList = foodOrderRepository.findAll();

        for(Passenger currPassenger : passengerList){
            if(currPassenger.getDate() == date){
                for(FoodOrder currOrder : foodOrderList){
                    if(currPassenger.getTrainId() == currOrder.getTrainId()){
                        price += currOrder.getPrice();
                    }
                }
            }
        }
        return price;
    }
}
