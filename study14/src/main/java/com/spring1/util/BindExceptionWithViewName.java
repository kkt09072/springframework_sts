package com.spring1.util;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@SuppressWarnings("serial")
public class BindExceptionWithViewName extends BindException {

    private final String viewName;

    public BindExceptionWithViewName(BindingResult bindingResult, String viewName) {
        super(bindingResult);
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }
}
