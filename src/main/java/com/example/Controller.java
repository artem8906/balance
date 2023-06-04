package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Get;

import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.Principal;
import java.text.SimpleDateFormat;

import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;


@io.micronaut.http.annotation.Controller
@Secured(SecurityRule.IS_AUTHENTICATED)
public class Controller {

    @Inject
    DataService dataService;

    @Inject
    ExchangeRateService rateService;


    @Get(produces = MediaType.TEXT_HTML)

    public String main() throws IOException {

        Balance balance = dataService.repository.getLast().get();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        double rate = rateService.getRateEUR_RUB();
        double rate = 89.989876;
        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(rate, context);

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Home</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    Balance is " + balance.getBalance() + " EUR on date " + sdf.format(balance.getDate()) + ".\n" +
                "Current exchange rate is " + result + " + 5% for transfer" + "\n" +
                "</div>\n" +
                "<input id=\"numb\" type=\"number\" placeholder=\"Type amount EUR\"> <button type=\"button\" onclick=\"myFunction()\">Calculate</button>" + "\n" +
                "<p id=\"demo\"></p>" + "\n" +
                "<script> function myFunction() { let x = document.getElementById(\"numb\").value; let text; if (isNaN(x) || x<=0) { text = \"Input not valid\";} else {" +
                " text = x * " + rate * 1.05 +"\n" +
                ";}document.getElementById(\"demo\").innerHTML = Math.round(Number(text));} </script>\n" +
                "</body>\n" +
                "</html>";
    }

    @Post("/{number}")
    public void topUp(float number) {
        dataService.addBalance(number);
    }


}
