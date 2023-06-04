package com.example;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.AuthenticationException;
import io.micronaut.security.authentication.AuthenticationExceptionHandler;
import io.micronaut.security.authentication.AuthorizationException;
import io.micronaut.security.authentication.DefaultAuthorizationExceptionHandler;
import jakarta.inject.Singleton;
import static io.micronaut.http.HttpHeaders.WWW_AUTHENTICATE;

@Singleton
@Replaces(DefaultAuthorizationExceptionHandler.class)
public class MyAuthExceptionHandler extends DefaultAuthorizationExceptionHandler {

    @Override
    protected MutableHttpResponse<?> httpResponseWithStatus (HttpRequest request, AuthorizationException e) {
        if (e.isForbidden()) {
            return HttpResponse.status(HttpStatus.FORBIDDEN);
        }
        return HttpResponse.unauthorized().header(WWW_AUTHENTICATE, "Basic realm=\"Micronaut HTTP Basic Demo\"");
    }
}
