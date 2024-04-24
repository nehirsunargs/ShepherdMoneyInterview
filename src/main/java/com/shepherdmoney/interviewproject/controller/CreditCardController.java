package com.shepherdmoney.interviewproject.controller;

import com.shepherdmoney.interviewproject.model.CreditCard;
import com.shepherdmoney.interviewproject.model.User;
import com.shepherdmoney.interviewproject.repository.CreditCardRepository;
import com.shepherdmoney.interviewproject.repository.UserRepository;
import com.shepherdmoney.interviewproject.vo.request.AddCreditCardToUserPayload;
import com.shepherdmoney.interviewproject.vo.request.UpdateBalancePayload;
import com.shepherdmoney.interviewproject.vo.response.CreditCardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class CreditCardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/credit-card")
    public ResponseEntity<Integer> addCreditCardToUser(@RequestBody AddCreditCardToUserPayload payload) {
         Optional<User> optionalUser = userRepository.findById(payload.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            CreditCard creditCard = new CreditCard();
            creditCard.setIssuanceBank(payload.getCardIssuanceBank());
            creditCard.setNumber(payload.getCardNumber());
            creditCard.setOwner(user);
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok(creditCard.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/credit-card:all")
    public ResponseEntity<List<CreditCardView>> getAllCardOfUser(@RequestParam int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<CreditCardView> cardViews = user.getCreditCards().stream()
                    .map(creditCard -> CreditCardView.builder()
                            .issuanceBank(creditCard.getIssuanceBank())
                            .number(creditCard.getNumber())
                            .build())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(cardViews);
        } else {
            return ResponseEntity.ok().body(List.of());
        }
    }

    @GetMapping("/credit-card:user-id")
    public ResponseEntity<Integer> getUserIdForCreditCard(@RequestParam String creditCardNumber) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findByNumber(creditCardNumber);
        if (optionalCreditCard.isPresent()) {
            CreditCard creditCard = optionalCreditCard.get();
            int userId = creditCard.getOwner().getId();
            return ResponseEntity.ok(userId);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/credit-card:update-balance")
    public ResponseEntity<String> updateCreditCardBalance(@RequestBody UpdateBalancePayload[] payload) {
        
        return ResponseEntity.ok("Update successful");
    }
    
}
