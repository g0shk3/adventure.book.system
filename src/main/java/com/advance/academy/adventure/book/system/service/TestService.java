package com.advance.academy.adventure.book.system.service;


import com.advance.academy.adventure.book.system.model.dto.BittrexTickerResponce;
import com.advance.academy.adventure.book.system.model.dto.PayPalCaptureRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TestService {

    private final RestTemplate restTemplate;

    @Autowired
    public TestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String testPayPalCapture() {
        ResponseEntity<String> response = null;
        try{
        PayPalCaptureRequest payPalCaptureRequest = new PayPalCaptureRequest();
        payPalCaptureRequest.setFinalCapture(Boolean.FALSE);
        payPalCaptureRequest.setInvoiceId("test invoice");
        payPalCaptureRequest.setAmountValue(new BigDecimal(19));
        payPalCaptureRequest.setAmountCurrencyCode("USD");

        HttpEntity<PayPalCaptureRequest> request = new HttpEntity<>(payPalCaptureRequest, new HttpHeaders());

        response = restTemplate.exchange("https://api.sandbox.paypal.com/v2/payments/authorizations/{authorization_id}/capture",
                HttpMethod.POST,
                request,
                String.class,
                "authKey"


        );
        return response.getBody();
    }catch (HttpClientErrorException e) {
            return e.getResponseBodyAsString()+ e.getMessage() + e.getStatusCode();
        }
    }

    public BittrexTickerResponce getBittrexTicker(){
        return restTemplate.getForObject(
         "https://api.bittrex.com/api/v1.1/public/getticker?market=USD-BTC",
                BittrexTickerResponce.class
                );


    }


}
