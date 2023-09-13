package com.amazon.pay.api.wrapper;

import java.io.Serializable;

public class MerchantMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customInformation;
    private String merchantReferenceId;
    private String merchantStoreName;
    private String noteToBuyer;

    public MerchantMetadata() {
        super();
    }

    public String getCustomInformation() {
        return customInformation;
    }

    public void setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
    }

    public String getMerchantReferenceId() {
        return merchantReferenceId;
    }

    public void setMerchantReferenceId(String merchantReferenceId) {
        this.merchantReferenceId = merchantReferenceId;
    }

    public String getMerchantStoreName() {
        return merchantStoreName;
    }

    public void setMerchantStoreName(String merchantStoreName) {
        this.merchantStoreName = merchantStoreName;
    }

    public String getNoteToBuyer() {
        return noteToBuyer;
    }

    public void setNoteToBuyer(String noteToBuyer) {
        this.noteToBuyer = noteToBuyer;
    }

    @Override
    public String toString() {
        return "MerchantMetadata [merchantReferenceId=" + merchantReferenceId + ", merchantStoreName="
                + merchantStoreName + ", noteToBuyer=" + noteToBuyer + ", customInformation="
                + customInformation + "]";
    }

}