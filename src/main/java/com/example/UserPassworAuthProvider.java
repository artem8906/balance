package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;


@Singleton
public class UserPassworAuthProvider implements AuthenticationProvider {

//        @Inject
//        UserStore store;



    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> req) {
        return Flux.create(emitter -> {
            if (isValid(req)) {
                emitter.next(AuthenticationResponse.success((String) req.getIdentity()));
                emitter.complete();
            } else {
                emitter.error(AuthenticationResponse.exception());
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }
    private boolean isValid(AuthenticationRequest<?, ?> req) {
        return "srzaev".equals(req.getIdentity()) && "7351355@mail.ru".equals(req.getSecret());
    }
}


