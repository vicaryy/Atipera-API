package com.vicary.atipera.exception;

import com.vicary.atipera.model.ErrorResponse;

public class ApiException extends RuntimeException {

    private ErrorResponse error;

    public ApiException(ErrorResponse error) {
        this.error = error;
    }

    public ErrorResponse getError() {
        return this.error;
    }
}
