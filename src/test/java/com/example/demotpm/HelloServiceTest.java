package com.example.demotpm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    @Test
    public void shouldReturnMessageWithName() {
        HelloService helloService = new HelloService();

        String message = helloService.getMessage("Johny");

        Assertions.assertThat(message).isEqualTo("Hello Johny!");
    }

}