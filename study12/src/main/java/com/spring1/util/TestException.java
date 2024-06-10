package com.spring1.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestException extends Exception {
    public TestException(String msg) {
        super(msg);
    }
}
