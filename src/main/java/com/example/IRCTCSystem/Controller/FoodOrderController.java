package com.example.IRCTCSystem.Controller;

import com.example.IRCTCSystem.Model.FoodOrder;
import com.example.IRCTCSystem.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class FoodOrderController {
    @Autowired
    FoodOrderService foodOrderService;

    @PostMapping("/add-order")
    public ResponseEntity addOrder(@RequestBody FoodOrder order){
        foodOrderService.addOrder(order);
        return new ResponseEntity("added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get-price")
    public ResponseEntity getPriceByPassenger(@RequestParam int trainId, @RequestParam Date date){
        int price = foodOrderService.getPriceByPassenger(trainId,date);
        return new ResponseEntity(price, HttpStatus.FOUND);
    }
}
