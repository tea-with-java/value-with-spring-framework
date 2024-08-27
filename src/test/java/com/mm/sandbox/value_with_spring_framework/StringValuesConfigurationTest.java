package com.mm.sandbox.value_with_spring_framework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
  "string01=Monday"
})
public class StringValuesConfigurationTest {
    @Value("${string01}") String string01;
    @Value("${string02}") String string02;
    @Value("${user.home}") String userHome; //System properties
    @Value("${NUMBER_OF_PROCESSORS}") String NUMBER_OF_PROCESSORS; //Environment variables

    @Test
    void testString01() {
        assertThat(string01).isEqualTo("Monday");
    }
    @Test
    void testString02() {
        assertThat(string02).isEqualTo("${string02}");
    }

    @Configuration
    static class Config {}

}
