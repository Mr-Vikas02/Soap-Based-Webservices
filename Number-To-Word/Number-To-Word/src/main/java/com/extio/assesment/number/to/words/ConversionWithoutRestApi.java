package com.extio.assesment.number.to.words;

import io.codevikas.maven.wsdl.to.java.NumberConversion;
import io.codevikas.maven.wsdl.to.java.NumberConversionSoapType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class ConversionWithoutRestApi {
    public static void main(String[] args) throws MalformedURLException {
        //** Scanner object to read user input **//
        Scanner scanner = new Scanner(System.in);

        //** User input for number to words **//
        System.out.print("Enter a number: ");
        BigInteger numberType = scanner.nextBigInteger();

        //** User input for number to dollar **//
        System.out.print("Enter a dollar amount: ");
        BigDecimal dollarType = scanner.nextBigDecimal();

        scanner.close();

        final String endPoint = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";
        final URL url = URI.create(endPoint).toURL();
        final NumberConversion service = new NumberConversion(url);
        final NumberConversionSoapType portType = service.getPort(NumberConversionSoapType.class);

        System.out.println("Number to words type is: " +portType.numberToWords(numberType));
        System.out.println("Number to dollar type is: " +portType.numberToDollars(dollarType));
    }
}
