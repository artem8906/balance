package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@io.micronaut.http.annotation.Controller()

public class Controller {

    @Inject
    DataService dataService;


    @Get("/")
    @View("log")
    public ModelAndView modelAndView() {

//        return HttpResponse.ok(dataService.repository.getLast().get());
            //return view and model
        Balance balance = dataService.repository.getLast().get();

            return new ModelAndView("log", balance);

    }


}
