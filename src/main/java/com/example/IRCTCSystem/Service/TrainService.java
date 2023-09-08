package com.example.IRCTCSystem.Service;

import com.example.IRCTCSystem.Model.Train;
import com.example.IRCTCSystem.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;
    public void addTrain(Train train) {
        trainRepository.save(train);
    }
}
