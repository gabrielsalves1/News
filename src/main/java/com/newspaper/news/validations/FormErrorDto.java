package com.newspaper.news.validations;

public class FormErrorDto {
    private String field;
    private String error;

    public FormErrorDto(String field, String error) {
        this.error = error;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
