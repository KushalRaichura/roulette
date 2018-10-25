/**
 * Module: roulette
 */
package com.game.play.roulette.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.game.play.roulette.service.RouletteService;
import com.game.play.roulette.util.RandomNumberGenerator;

@RunWith(SpringRunner.class)
@WebMvcTest({ RouletteController.class, RouletteService.class })
public class RouletteControllerTest {

    /**
     * ROULETTE_PLACE_BET
     */
    private static final String ROULETTE_PLACE_BET = "/roulette/v1/placeBet";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private RandomNumberGenerator randomNumberGenerator;

    @Test
    public void testPlaceBetNumberBetWon() throws Exception {
        when(randomNumberGenerator.getRandomNumber()).thenReturn(10);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(ROULETTE_PLACE_BET).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bets\": [ { \"type\" : \"Number\", \"betAmount\" : 10, \"number\":10 }]}");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseActual = mvcResult.getResponse().getContentAsString();

        String responseExpected = "{\"bets\": [ {  \"type\": \"Number\", \"betAmount\":  10, \"number\":10, \"betOutcome\": { \"won\": true, \"resultAmount\": 360 }}], \"spinResult\": 10}";

        JSONAssert.assertEquals(responseExpected, responseActual, false);
    }

    @Test
    public void testPlaceBetNumberBetLost() throws Exception {
        when(randomNumberGenerator.getRandomNumber()).thenReturn(27);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(ROULETTE_PLACE_BET).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bets\": [ { \"type\" : \"Number\", \"betAmount\" : 10, \"number\":10 }]}");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseActual = mvcResult.getResponse().getContentAsString();

        String responseExpected = "{\"bets\": [ {  \"type\": \"Number\", \"betAmount\":  10, \"number\":10, \"betOutcome\": { \"won\": false, \"resultAmount\": 0 }}], \"spinResult\": 27}";

        JSONAssert.assertEquals(responseExpected, responseActual, false);
    }

    @Test
    public void testPlaceBetNumberBetFailed() throws Exception {
        when(randomNumberGenerator.getRandomNumber()).thenReturn(27);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(ROULETTE_PLACE_BET).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bets\": [ { \"type\" : \"Number\", \"betAmount\" : 10, \"number\":10 }]}");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseActual = mvcResult.getResponse().getContentAsString();

        String responseExpected = "{\"bets\": [ {  \"type\": \"Number\", \"betAmount\":  10, \"number\":10, \"betOutcome\": { \"won\": true, \"resultAmount\": 360 }}], \"spinResult\": 27}";

        JSONAssert.assertNotEquals(responseExpected, responseActual, false);
    }

    @Test
    public void testPlaceInvalidBet() throws Exception {
        when(randomNumberGenerator.getRandomNumber()).thenReturn(27);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(ROULETTE_PLACE_BET).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bets\": [ { }");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseActual = mvcResult.getResponse().getContentAsString();

        String responseExpected = "{ \"status\": \"BAD_REQUEST\", \"message\": \"Malformed JSON request\"}  ";

        JSONAssert.assertEquals(responseExpected, responseActual, false);
    }

    @Test
    public void testPlaceCornerBet() throws Exception {
        when(randomNumberGenerator.getRandomNumber()).thenReturn(1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(ROULETTE_PLACE_BET).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bets\": [{\"type\": \"Corner\",\"pockets\": [1,4,2,5],\"betAmount\": 10}]}");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String responseActual = mvcResult.getResponse().getContentAsString();

        String responseExpected = "{\"bets\": [{\"type\": \"Corner\",\"betAmount\": 10,\"pockets\": [1,2,4,5],\"betOutcome\": {\"won\": true,\"resultAmount\": 90}}],\"spinResult\": 1}";

        JSONAssert.assertEquals(responseExpected, responseActual, false);
    }

    // TODO: Add further test to cover possible scenarios

}
