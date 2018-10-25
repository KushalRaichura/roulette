/**
 * Module: roulette
 */
package com.game.play.roulette.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetRequest;
import com.game.play.roulette.io.BetResponse;
import com.game.play.roulette.util.RandomNumberGenerator;

/**
 * 
 * RouletteService.java - This service class facilitates processing bet operation.
 * 
 * @since 23 Sep 2018
 */
@Service
public class RouletteService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RouletteService.class);

    @Autowired
    RandomNumberGenerator randomNumberGenerator;

    public BetResponse processBet(@Valid @RequestBody BetRequest betRequest) {

        LOGGER.info("Entering processBet()");
        // TODO - Add validation

        int spinResult = randomNumberGenerator.getRandomNumber();
        BetResponse betReponse = new BetResponse();
        betReponse.setSpinResult(spinResult);

        for (Bet bet : betRequest.getBets()) {
            bet.processBet(spinResult);
            betReponse.addBets(bet);
        }

        LOGGER.info("Exiting processBet()");
        return betReponse;
    }

}
