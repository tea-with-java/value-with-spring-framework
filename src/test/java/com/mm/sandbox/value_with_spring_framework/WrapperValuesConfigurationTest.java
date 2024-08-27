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
class WrapperValuesConfigurationTest {
    @Autowired
    WrapperValuesConfiguration configuration;

    @Test
    void testInjectedValues() {
        assertThat(configuration.get_Boolean()).isEqualTo(true);
        assertThat(configuration.get_Byte()).isEqualTo((byte)24);
        assertThat(configuration.get_Short()).isEqualTo((short)376);
        assertThat(configuration.get_Integer()).isEqualTo(453534345);
        assertThat(configuration.get_Long()).isEqualTo(77453534345L);

        assertThat(configuration.get_Char()).isEqualTo('c');

        assertThat(configuration.get_Float()).isEqualTo(3.56f);
        assertThat(configuration.get_Double()).isEqualTo(-234.345);
    }

    @Configuration
    @PropertySource("classpath:custom.properties")
    static class Config {
        @Bean
        WrapperValuesConfiguration wrapperValuesConfiguration() {
            return new WrapperValuesConfiguration();
        }
    }
}


