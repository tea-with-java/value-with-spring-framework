package com.mm.sandbox.value_with_spring_framework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.nio.file.Path;
import java.util.LinkedHashSet;

import static com.mm.sandbox.value_with_spring_framework.VariousFieldTypesConfigurationTest.LIGHT.YELLOW;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "class=java.util.LinkedHashSet",
        "path=.\\",
        "url=http://github.com",
        "enum=YELLOW",
        "array=a,s,d,f"
})
public class VariousFieldTypesConfigurationTest {

    @Value("${class}") Class clazz;
    @Value("${path}") Path path;
    @Value("${url}") URL url;
    @Value("${enum}") LIGHT light;
    @Value("${array}") String[] array;

    @Test
    void test() {
        assertThat(clazz).isEqualTo(LinkedHashSet.class);
        assertThat(path.toFile().isDirectory()).isTrue();
        assertThat(url.getHost()).isEqualTo("github.com");
        assertThat(light).isEqualTo(YELLOW);
        assertThat(array.length).isEqualTo(4);
        assertThat(array).containsExactly("a", "s", "d", "f");
    }


    @Configuration
    static class Config {}

    enum LIGHT {RED, YELLOW, GREEN}
}
