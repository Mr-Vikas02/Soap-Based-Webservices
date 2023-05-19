package com.extio.assesment.number.to.words.controller;

import io.codevikas.maven.wsdl.to.java.NumberConversionSoapType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/conversions")
public class ConversionController {
    private final NumberConversionSoapType portType;

    @Autowired
    public ConversionController(NumberConversionSoapType portType) {
        this.portType = portType;
    }

    /**
     *  Get call for numberToWords conversion.
     * */
    @GetMapping("/number-to-words")
    public Map<Integer, String> numberToWords(@RequestParam("number") BigInteger number) {
        String convertedResult = portType.numberToWords(number);

        HashMap<Integer, String> response = new HashMap<>();
        response.put(1, "Number to words is: " + response);
        return response;
    }

    /**
     *  Get call for numberToDollars conversion.
     * */
    @GetMapping("/number-to-dollars")
    public Map<Integer, String> numberToDollars(@RequestParam("dollar") BigDecimal dollar) {
        String convertedResult = portType.numberToDollars(dollar);

        HashMap<Integer, String> response = new HashMap<>();
        response.put(1, "Number to dollar is: " + response);
        return response;
    }
}
