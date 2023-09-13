package com.amazon.pay.api.wrapper;

public class ErrorStatusCodeRecievedException extends Exception {

    private static final long serialVersionUID = 1L;

    private final Integer errorStatusCode;

    public ErrorStatusCodeRecievedException(Integer errorStatusCode) {
        super("status code: " + errorStatusCode);
        this.errorStatusCode = errorStatusCode;
    }

    public Integer getErrorStatusCode() {
        return errorStatusCode;
    }
}
