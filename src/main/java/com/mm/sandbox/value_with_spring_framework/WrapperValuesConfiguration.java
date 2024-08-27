package com.mm.sandbox.value_with_spring_framework;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class WrapperValuesConfiguration {
    @Value("${custom._boolean}") private Boolean _Boolean;
    @Value("${custom._byte}") private Byte _Byte;
    @Value("${custom._short}") private Short _Short;
    @Value("${custom._int}") private Integer _Integer;
    @Value("${custom._long}") private Long _Long;
    @Value("${custom._float}") private Float _Float;
    @Value("${custom._double}") private Double _Double;
    @Value("${custom._char}") private Character _Char;
}
