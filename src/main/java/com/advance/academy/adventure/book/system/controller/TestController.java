package com.advance.academy.adventure.book.system.controller;

import com.advance.academy.adventure.book.system.model.dto.BittrexTickerResponce;
import com.advance.academy.adventure.book.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test-rest")
public class TestController {

    private final TestService testService;



    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/test-paypal")
    public String testPayPal(){
        return testService.testPayPalCapture();
    }
    @GetMapping("/test-bittrex")
    public BittrexTickerResponce getResponse(){
        BittrexTickerResponce response = testService.getBittrexTicker();
        return response;

    }
}
