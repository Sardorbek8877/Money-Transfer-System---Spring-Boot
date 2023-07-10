package uz.bek.moneytransferapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bek.moneytransferapp.service.CardService;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;


}
