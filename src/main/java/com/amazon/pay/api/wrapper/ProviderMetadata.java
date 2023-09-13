package com.amazon.pay.api.wrapper;

import java.io.Serializable;

public class ProviderMetadata implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String providerReferenceId;

    public ProviderMetadata() {
        super();
    }

    public String getProviderReferenceId() {
        return providerReferenceId;
    }

    public void setProviderReferenceId(String providerReferenceId) {
        this.providerReferenceId = providerReferenceId;
    }

    @Override
    public String toString() {
        return "ProviderMetadata [providerReferenceId=" + providerReferenceId + "]";
    }

}