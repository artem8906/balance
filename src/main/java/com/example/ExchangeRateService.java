package com.example;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class ExchangeRateService {
    @Value("${micronaut.application.rateservice}")
    private String URL;

    public double getRateEUR_RUB() throws IOException {
        InputStream is = new URL(URL).openStream();
        double rate = 0.0;
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            rate = new JSONObject(readAll(rd))
                    .getJSONObject("rates")
                    .getDouble("RUB");
        }
        return rate;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
