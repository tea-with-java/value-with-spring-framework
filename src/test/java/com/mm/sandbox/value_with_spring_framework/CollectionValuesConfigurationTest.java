package com.mm.sandbox.value_with_spring_framework;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource(
        properties = {
                "list=a,c,b,b"
        }
)
public class CollectionValuesConfigurationTest {

    @Value("${list}") Collection<String> collection;
    @Value("${list}") List<String> list;
    @Value("${list}") Set<String> set;

    @Test
    void testCollection() {
        assertThat(collection).isOfAnyClassIn(LinkedHashSet.class);
        assertThat(collection).containsOnly("a,c,b,b");
    }

    @Test
    void testList() {
        assertThat(list).isOfAnyClassIn(ArrayList.class);
        assertThat(list).containsOnly("a,c,b,b");
    }

    @Test
    void testSet() {
        assertThat(set).isOfAnyClassIn(LinkedHashSet.class);
        assertThat(set).containsOnly("a,c,b,b");
    }

    @Configuration
    static class Config {}

}
