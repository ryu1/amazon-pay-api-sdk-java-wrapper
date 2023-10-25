package com.amazon.pay.api.wrapper;

import org.apache.commons.lang3.StringUtils;

public class ErrorStatusCodeReceivedException extends Exception {

    public enum ReasonCode {
        TRANSACTION_AMOUNT_EXCEEDED("TransactionAmountExceeded"),
        PERIODIC_AMOUNT_EXCEEDED("PeriodicAmountExceeded"),
        INVALID_PARAMETER_VALUE("InvalidParameterValue"),
        INVALID_CHARGE_PERMISSION_STATUS("InvalidChargePermissionStatus"),
        SOFT_DECLINED("SoftDeclined"),
        HARD_DECLINED("HardDeclined"),
        TRANSACTION_COUNT_EXCEEDED("TransactionCountExceeded"),
        PAYMENT_METHOD_NOT_ALLOWED("PaymentMethodNotAllowed"),
        AMAZON_REJECTED("AmazonRejected"),
        MFA_NOT_COMPLETED("MFANotCompleted"),
        TRANSACTION_TIMED_OUT("TransactionTimedOut"),
        PROCESSING_FAILURE("ProcessingFailure"),
        INVALID_HEADER_VALUE("InvalidHeaderValue"),
        INVALID_REQUEST("InvalidRequest"),
        INVALID_REQUEST_FORMAT("InvalidRequestFormat"),
        MISSING_HEADER("MissingHeader"),
        MISSING_HEADER_VALUE("MissingHeaderValue"),
        MISSING_PARAMETER_VALUE("MissingParameterValue"),
        UNRECOGNIZED_FIELD("UnrecognizedField"),
        INVALID_SANDBOX_SIMULATION_SPECIFIED("InvalidSandboxSimulationSpecified"),
        DUPLICATE_IDEMPOTENCY_KEY("DuplicateIdempotencyKey"),
        INVALID_PARAMETER_COMBINATION("InvalidParameterCombination"),
        CURRENCY_MISMATCH("CurrencyMismatch"),
        INVALID_API_VERSION("InvalidAPIVersion"),
        UNAUTHORIZED_ACCESS("UnauthorizedAccess"),
        INVALID_AUTHENTICATION("InvalidAuthentication"),
        INVALID_ACCOUNT_STATUS("InvalidAccountStatus"),
        INVALID_REQUEST_SIGNATURE("InvalidRequestSignature"),
        INVALID_AUTHORIZATION_TOKEN("InvalidAuthorizationToken"),
        RESOURCE_NOT_FOUND("ResourceNotFound"),
        UNSUPPORTED_OPERATION("UnsupportedOperation"),
        REQUEST_NOT_SUPPORTED("RequestNotSupported"),
        REQUEST_TIMEOUT("RequestTimeout"),
        TLS_VERSION_NOT_SUPPORTED("TLSVersionNotSupported"),
        TOO_MANY_REQUESTS("TooManyRequests"),
        INTERNAL_SERVER_ERROR("InternalServerError"),
        SERVICE_UNAVAILABLE("ServiceUnavailable"),
        INVALID_CHARGE_STATUS("InvalidChargeStatus"),
        INVALID_CHECKOUT_SESSION_STATUS("InvalidCheckoutSessionStatus"),
        AMOUNT_MISMATCH("AmountMismatch"),
        CHECKOUT_SESSION_CANCELED("CheckoutSessionCanceled"),
        UNKNOWN("Unknown");

        private final String name;

        ReasonCode(final String name) {
            this.name = name;
        }

        public static ErrorStatusCodeReceivedException.ReasonCode enumOf(final String name) {
            for (ErrorStatusCodeReceivedException.ReasonCode value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static ErrorStatusCodeReceivedException.ReasonCode fromString(String string) {
            return ErrorStatusCodeReceivedException.ReasonCode.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    private static final long serialVersionUID = 1L;
    private final Integer errorStatusCode;
    private final ReasonCode reasonCode;
    private final String message;


    public ErrorStatusCodeReceivedException(final Integer errorStatusCode, final String reasonCode, final String message) {
        super(String.format("status code: %d, reasonCode: %s, message: %s", errorStatusCode, reasonCode, message));
        this.errorStatusCode = errorStatusCode;
        this.reasonCode = ReasonCode.fromString(reasonCode);
        this.message = message;
    }

    public Integer getErrorStatusCode() {
        return errorStatusCode;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

}
