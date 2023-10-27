package com.amazon.pay.api.wrapper;

import org.junit.jupiter.api.Test;

import static com.amazon.pay.api.wrapper.ErrorStatusCodeReceivedException.ReasonCode.INVALID_PARAMETER_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorStatusCodeReceivedExceptionTest {

    @Test
    void test() {
        ErrorStatusCodeReceivedException exception = new ErrorStatusCodeReceivedException(400, "InvalidParameterValue", "The value provided for [Parameter] is invalid.");
        assertEquals(exception.getErrorStatusCode(), 400);
        assertEquals(exception.getReasonCode(), INVALID_PARAMETER_VALUE);
        assertEquals(exception.getMessage(), "status code: 400, reasonCode: InvalidParameterValue, message: The value provided for [Parameter] is invalid.");
    }

}
