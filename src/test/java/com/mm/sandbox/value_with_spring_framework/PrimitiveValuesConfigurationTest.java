package com.mm.sandbox.value_with_spring_framework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class PrimitiveValuesConfigurationTest {

    @Autowired
    PrimitiveValuesConfiguration configuration;

    @Test
    void testInjectedValues() {
        assertThat(configuration.is_boolean()).isEqualTo(true);
        assertThat(configuration.get_byte()).isEqualTo((byte)24);
        assertThat(configuration.get_short()).isEqualTo((short)376);
        assertThat(configuration.get_int()).isEqualTo(453534345);
        assertThat(configuration.get_long()).isEqualTo(77453534345L);

        assertThat(configuration.get_char()).isEqualTo('c');

        assertThat(configuration.get_float()).isEqualTo(3.56f);
        assertThat(configuration.get_double()).isEqualTo(-234.345);
    }

    @Configuration
    @PropertySource("classpath:custom.properties")
    static class Config {
        @Bean
        PrimitiveValuesConfiguration primitiveValuesConfiguration() {
            return new PrimitiveValuesConfiguration();
        }
    }

}
