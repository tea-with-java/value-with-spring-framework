package com.mm.sandbox.value_with_spring_framework;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PrimitiveValuesConfiguration {
    @Value("${custom._boolean}") private boolean _boolean;
    @Value("${custom._byte}") private byte _byte;
    @Value("${custom._short}") private short _short;
    @Value("${custom._int}") private int _int;
    @Value("${custom._long}") private long _long;
    @Value("${custom._float}") private float _float;
    @Value("${custom._double}") private double _double;
    @Value("${custom._char}") private char _char;

}
