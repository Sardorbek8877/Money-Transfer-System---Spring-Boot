package uz.bek.moneytransferapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bek.moneytransferapp.entity.Card;
import uz.bek.moneytransferapp.payload.ApiResponse;
import uz.bek.moneytransferapp.payload.CardDto;
import uz.bek.moneytransferapp.service.CardService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;

    /**
     * GET CARDS
     * @return List<Card>
     */
    @GetMapping
    public ResponseEntity<List<Card>> getCards(){
        List<Card> cards = cardService.getCards();
        return ResponseEntity.ok(cards);
    }

    /**
     * GET Card BY ID
     * @param id
     * @return Card
     */
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable UUID id){
        Card cardById = cardService.getCardById(id);
        return ResponseEntity.ok(cardById);
    }

    /**
     * ADD Card
     * @param cardDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<?> addCard(@RequestBody CardDto cardDto){
        ApiResponse apiResponse = cardService.addCard(cardDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT Card
     * @param id
     * @param cardDto
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> editCard(@PathVariable UUID id, @RequestBody CardDto cardDto){
        ApiResponse apiResponse = cardService.editCard(id, cardDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE Card
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable UUID id){
        ApiResponse apiResponse = cardService.deleteCard(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
