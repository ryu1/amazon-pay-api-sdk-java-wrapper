package com.amazon.pay.api.wrapper;

import java.io.Serializable;

public class Price implements Serializable {

    private static final long serialVersionUID = 1L;
    private String amount;
    private String currencyCode;

    public Price() {
        super();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Price [amount=" + amount + ", currencyCode=" + currencyCode + "]";
    }

}