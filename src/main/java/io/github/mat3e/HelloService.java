package io.github.mat3e;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";

    String prepareGreweting(String name) {
       return "Hello " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";
    }

}
