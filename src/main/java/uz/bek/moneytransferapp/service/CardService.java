package uz.bek.moneytransferapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bek.moneytransferapp.entity.Card;
import uz.bek.moneytransferapp.entity.User;
import uz.bek.moneytransferapp.payload.ApiResponse;
import uz.bek.moneytransferapp.payload.CardDto;
import uz.bek.moneytransferapp.repository.CardRepository;
import uz.bek.moneytransferapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * GET CARDS
     * @return List<Card>
     */
    public List<Card> getCards(){
        return cardRepository.findAll();
    }

    /**
     * GET Card BY ID
     * @param id
     * @return Card
     */
    public Card getCardById(UUID id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        return optionalCard.orElse(null);
    }

    /**
     * ADD Card
     * @param cardDto
     * @return ApiResponse
     */
    public ApiResponse addCard(CardDto cardDto){
        boolean existsByNumber = cardRepository.existsByNumber(cardDto.getNumber());
        if (existsByNumber)
            return new ApiResponse("Card Number already exist", false);

        Optional<User> optionalUser = userRepository.findById(cardDto.getUserId());
        if (optionalUser.isEmpty())
            return new ApiResponse("User not found", false);
        User user = optionalUser.get();

        Card card = new Card();
        card.setUsername(cardDto.getUsername());
        card.setCardNumber(cardDto.getNumber());
        card.setBalance(cardDto.getBalance());
        card.setActive(cardDto.isActive());

        cardRepository.save(card);
        return new ApiResponse("Card added", true);
    }

    /**
     * EDIT Card
     * @param id
     * @param cardDto
     * @return ApiResponse
     */
    public ApiResponse editCard(UUID id, CardDto cardDto){
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (optionalCard.isEmpty())
            return new ApiResponse("Card not found", false);

        Card card = optionalCard.get();

        boolean existsByNumber = cardRepository.existsByNumber(cardDto.getNumber());
        if (existsByNumber)
            return new ApiResponse("Card Number already exist", false);

        Optional<User> optionalUser = userRepository.findById(cardDto.getUserId());
        if (optionalUser.isEmpty())
            return new ApiResponse("User not found", false);
        User user = optionalUser.get();

        card.setUsername(cardDto.getUsername());
        card.setCardNumber(cardDto.getNumber());
        card.setBalance(cardDto.getBalance());
        card.setActive(cardDto.isActive());

        cardRepository.save(card);
        return new ApiResponse("Card edited", true);
    }

    /**
     * DELETE Card
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteCard(UUID id){
        try {
            cardRepository.deleteById(id);
            return new ApiResponse("Card deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("Card not found", false);
        }
    }
}
