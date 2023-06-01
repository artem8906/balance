package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Singleton
@io.micronaut.http.annotation.Controller
public class Controller {

    @Inject
    DataService dataService;

    @Inject
    ExchangeRateService rateService;


    @Get(produces = MediaType.TEXT_HTML)
    @View("main")
    public String main() throws IOException {

        Balance balance = dataService.repository.getLast().get();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        double rate = 80.0;

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Home</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    Balance is " + balance.getBalance() + " EUR on date " + sdf.format(balance.getDate()) + ".\n" +
                "Current exchange rate is NUMBER + 5% for transfer" + "\n" +
                "</div>\n" +
                "<input id=\"numb\" type=\"number\"> <button type=\"button\" onclick=\"myFunction()\">Calculate</button>" + "\n" +
                "<p id=\"demo\"></p>" + "\n" +
                "<script> function myFunction() { let x = document.getElementById(\"numb\").value; let text; if (isNaN(x) || x < 1 || x > 10) { text = \"Input not valid\";} else { text = \"Input OK\";}document.getElementById(\"demo\").innerHTML = text;} </script>\n" +
                "</body>\n" +
                "</html>";
    }


}
