package com.example.IRCTCSystem.Service;

import com.example.IRCTCSystem.Model.Passenger;
import com.example.IRCTCSystem.Model.Train;
import com.example.IRCTCSystem.Repository.PassengerRepository;
import com.example.IRCTCSystem.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;
    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public int getNoOfPassenger(String start, String end, Date date) {
        int passengerCount = 0;
        List<Train> trainList = trainRepository.findAll();
        List<Passenger> passengerList = passengerRepository.findAll();

        for(Passenger currPassenger : passengerList){
            if(currPassenger.getDate() == date ){
                for(Train currTrain : trainList){
                    if( currPassenger.getTrainId() == currTrain.getTrainNO() && currTrain.getSource() == start && currTrain.getDestination() == end){
                        passengerCount++;
                    }
                }
            }
        }
        return passengerCount;
    }

    public int getFemalePassengerBetweenAge(int minAge, int maxAge, String destination) {
        int femalePassengetCount = 0;
        List<Passenger> passengerList = passengerRepository.findAll();
        List<Train> trainList = trainRepository.findAll();

        for(Passenger currPassenger : passengerList){
            if(currPassenger.getGender().equals("female") && currPassenger.getAge() > minAge && currPassenger.getAge() <= maxAge){
                for(Train currTrain : trainList){
                    if(currPassenger.getTrainId() == currTrain.getTrainNO() && currTrain.getDestination().equals(destination)){
                        femalePassengetCount++;
                    }
                }
            }
        }
        return femalePassengetCount;
    }

//    - Find total No of female passengers of age between X and Y(X < = Y) who
//ended their destination at city C
//Get the total price of the orders placed by passengers on Date D in TrainId T

}
