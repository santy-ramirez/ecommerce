package com.example.appTestSpringSecurity.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class NonIterableToIterableUtils {

    @ToList
    public <T> List<T> toList(T in) {
        if (in != null) return Collections.singletonList(in);
        else return new ArrayList<T>();
    }
    
}
