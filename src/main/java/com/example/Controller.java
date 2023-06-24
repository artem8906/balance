package com.example;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;

import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Singleton
@io.micronaut.http.annotation.Controller
@Secured(SecurityRule.IS_AUTHENTICATED)
public class Controller {

    @Inject
    DataService dataService;

    @Inject
    ExchangeRateService rateService;

    @Get()
    ModelAndView modelAndView() throws IOException {
        double rate = rateService.getRateEUR_RUB();
//        double rate = 89.989876;
        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(rate, context);
        List <Operation> last10 = dataService.get10LastOperation();
        return new ModelAndView("index", CollectionUtils
                .mapOf("operations", last10,
                                "balance", last10.get(0).getBalance(),
                                "rate", result));
    }

    @Post("/{number}")
    public void changeBalance(float number) {
        dataService.addOperation(number);
    }


}
