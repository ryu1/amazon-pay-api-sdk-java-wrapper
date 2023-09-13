package com.amazon.pay.api.wrapper;

import java.io.Serializable;
import java.util.Date;

public class StatusDetails<R, S> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date lastUpdatedTimestamp;
    private R reasonCode;
    private String reasonDescription;
    private S state;

    public StatusDetails() {
        super();
    }

    public Date getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public R getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(R reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public S getState() {
        return state;
    }

    public void setState(S state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StatusDetails [state=" + state + ", reasonCode=" + reasonCode + ", reasonDescription="
                + reasonDescription + ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + "]";
    }

}