package com.mm.sandbox.value_with_spring_framework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "numbers={1,2,3,3,4}",
        "person={name:'Nikola',dob:'10-July-1856'}"
})
public class SpELConfigurationTest {

    @Value("#{${numbers}}") List<Integer> numbersList;
    @Value("#{${numbers}}") Set<Integer> numbersSet;
    @Value("#{${numbers}}") int[] numbersArray;

    @Value("#{${person}}") Map<String, String> person;



    @Test
    void test(){
        //numbersList is an instance of java.util.Collections$UnmodifiableRandomAccessList
        assertThat(numbersList).containsExactly(1,2,3,3,4);
        assertThatThrownBy(() -> numbersList.add(5)).isInstanceOf(UnsupportedOperationException.class);

        assertThat(numbersSet).containsExactly(1,2,3,4);
        assertThatNoException().isThrownBy(() ->numbersSet.add(5));

        assertThat(numbersArray).hasSize(5);
        assertThat(numbersArray).containsExactly(1,2,3,3,4);
    }


    @Configuration
    static class Config {}
}
