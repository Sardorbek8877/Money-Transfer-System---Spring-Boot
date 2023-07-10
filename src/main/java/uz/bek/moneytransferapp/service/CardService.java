package uz.bek.moneytransferapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bek.moneytransferapp.repository.CardRepository;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;


}
