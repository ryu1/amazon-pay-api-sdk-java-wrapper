package com.amazon.pay.api.wrapper;

import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Refund implements Serializable {

    private static final long serialVersionUID = 1L;
    private String chargeId;
    private Date creationTimestamp;
    private RefundAmount refundAmount;
    private String refundId;
    private String releaseEnvironment;
    private String softDescriptor;
    private StatusDetails statusDetails;

    public Refund() {
        super();
    }

    public static Refund createObject(JSONObject jsonObject) {
        JsonConfig config = new JsonConfig();

        @SuppressWarnings("rawtypes")
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("refundAmount", RefundAmount.class);
        classMap.put("statusDetails", StatusDetails.class);
        config.setClassMap(classMap);
        config.setRootClass(Refund.class);

        // フォーマット指定
        MorpherRegistry mr = JSONUtils.getMorpherRegistry();
        mr.registerMorpher(new DateMorpher(new String[]{"yyyyMMdd't'HHmmss'z'"}));
        mr.registerMorpher(new CustomEnumMorpher(State.class));

        // https://www.doraxdora.com/blog/2019/04/24/post-8324/
        Refund refund = (Refund) JSONObject.toBean(jsonObject, config);
        return refund;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public RefundAmount getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(RefundAmount refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getReleaseEnvironment() {
        return releaseEnvironment;
    }

    public void setReleaseEnvironment(String releaseEnvironment) {
        this.releaseEnvironment = releaseEnvironment;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public void setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
    }

    public StatusDetails getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(StatusDetails statusDetails) {
        this.statusDetails = statusDetails;
    }

    @Override
    public String toString() {
        return "Refund [refundId=" + refundId + ", chargeId=" + chargeId + ", refundAmount=" + refundAmount
                + ", softDescriptor=" + softDescriptor + ", creationTimestamp=" + creationTimestamp
                + ", statusDetails=" + statusDetails + ", releaseEnvironment=" + releaseEnvironment + "]";
    }

    public enum State {
        DECLINED("Declined"), REFUND_INITIATED("RefundInitiated"), REFUNDED("Refunded"), UNKNOWN("Unknown");

        private final String name;

        State(final String name) {
            this.name = name;
        }

        public static State enumOf(final String name) {
            for (State value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static State fromString(String string) {
            return State.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public static class RefundAmount implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private String amount;
        private String currencyCode;

        public RefundAmount() {
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
            return "RefundAmount [amount=" + amount + ", currencyCode=" + currencyCode + "]";
        }
    }

    public static class StatusDetails implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private Date lastUpdatedTimestamp;
        private String reasonCode;
        private String reasonDescription;
        private State state;

        public StatusDetails() {
            super();
        }

        public Date getLastUpdatedTimestamp() {
            return lastUpdatedTimestamp;
        }

        public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
            this.lastUpdatedTimestamp = lastUpdatedTimestamp;
        }

        public String getReasonCode() {
            return reasonCode;
        }

        public void setReasonCode(String reasonCode) {
            this.reasonCode = reasonCode;
        }

        public String getReasonDescription() {
            return reasonDescription;
        }

        public void setReasonDescription(String reasonDescription) {
            this.reasonDescription = reasonDescription;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "StatusDetails [state=" + state + ", reasonCode=" + reasonCode + ", reasonDescription="
                    + reasonDescription + ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + "]";
        }

    }
}