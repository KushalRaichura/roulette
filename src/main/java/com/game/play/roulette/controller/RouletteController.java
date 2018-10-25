package com.game.play.roulette.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.play.roulette.io.BetRequest;
import com.game.play.roulette.io.BetResponse;
import com.game.play.roulette.service.RouletteService;

/**
 * 
 * RouletteController.java - Controller class to help expose roulette resource/api
 * 
 * @since 23 Sep 2018
 */
@RestController
@RequestMapping("roulette")
public class RouletteController {

    @Autowired
    RouletteService rouletteService;

    @PostMapping("/v1/placeBet")
    public BetResponse placeBet(@Valid @RequestBody BetRequest betRequest) {
        return rouletteService.processBet(betRequest);
    }

}
