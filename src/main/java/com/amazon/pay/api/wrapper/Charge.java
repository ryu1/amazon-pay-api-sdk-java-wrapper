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

public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;
    private String chargeId;
    private String chargePermissionId;
    private Price chargeAmount;
    private Price captureAmount;
    private Price refundedAmount;
    private String softDescriptor;
    private Boolean captureNow;
    private Boolean canHandlePendingAuthorization;
    private ProviderMetadata providerMetadata;
    private Date creationTimestamp;
    private Date expirationTimestamp;
    private MerchantMetadata merchantMetadata;
    private String platformId;
    private StatusDetails<Charge.ReasonCode, Charge.State> statusDetails;
    private Price convertedAmount;
    private Double conversionRate;
    private String releaseEnvironment;

    public static Charge createObject(JSONObject jsonObject) {
        JsonConfig config = new JsonConfig();

        @SuppressWarnings("rawtypes")
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("chargeAmount", Price.class);
        classMap.put("captureAmount", Price.class);
        classMap.put("refundedAmount", Price.class);
        classMap.put("ProviderMetadata", ProviderMetadata.class);
        classMap.put("merchantMetadata", MerchantMetadata.class);
        classMap.put("statusDetails", StatusDetails.class);
        classMap.put("convertedAmount", Price.class);
        config.setClassMap(classMap);
        config.setRootClass(Charge.class);

        // フォーマット指定
        MorpherRegistry mr = JSONUtils.getMorpherRegistry();
        mr.registerMorpher(new DateMorpher(new String[]{"yyyyMMdd't'HHmmss'z'"}));
        mr.registerMorpher(new CustomEnumMorpher(State.class));
        mr.registerMorpher(new CustomEnumMorpher(ReasonCode.class));

        // https://www.doraxdora.com/blog/2019/04/24/post-8324/
        Charge charge = (Charge) JSONObject.toBean(jsonObject, config);
        return charge;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "chargeId='" + chargeId + '\'' +
                ", chargePermissionId='" + chargePermissionId + '\'' +
                ", chargeAmount=" + chargeAmount +
                ", captureAmount=" + captureAmount +
                ", refundedAmount=" + refundedAmount +
                ", softDescriptor='" + softDescriptor + '\'' +
                ", captureNow=" + captureNow +
                ", canHandlePendingAuthorization=" + canHandlePendingAuthorization +
                ", providerMetadata=" + providerMetadata +
                ", creationTimestamp=" + creationTimestamp +
                ", expirationTimestamp=" + expirationTimestamp +
                ", merchantMetadata=" + merchantMetadata +
                ", platformId='" + platformId + '\'' +
                ", statusDetails=" + statusDetails +
                ", convertedAmount=" + convertedAmount +
                ", conversionRate=" + conversionRate +
                ", releaseEnvironment='" + releaseEnvironment + '\'' +
                '}';
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargePermissionId() {
        return chargePermissionId;
    }

    public void setChargePermissionId(String chargePermissionId) {
        this.chargePermissionId = chargePermissionId;
    }

    public Price getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Price chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Price getCaptureAmount() {
        return captureAmount;
    }

    public void setCaptureAmount(Price captureAmount) {
        this.captureAmount = captureAmount;
    }

    public Price getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Price refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public void setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
    }

    public Boolean getCaptureNow() {
        return captureNow;
    }

    public void setCaptureNow(Boolean captureNow) {
        this.captureNow = captureNow;
    }

    public Boolean getCanHandlePendingAuthorization() {
        return canHandlePendingAuthorization;
    }

    public void setCanHandlePendingAuthorization(Boolean canHandlePendingAuthorization) {
        this.canHandlePendingAuthorization = canHandlePendingAuthorization;
    }

    public ProviderMetadata getProviderMetadata() {
        return providerMetadata;
    }

    public void setProviderMetadata(ProviderMetadata providerMetadata) {
        this.providerMetadata = providerMetadata;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Date getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public void setExpirationTimestamp(Date expirationTimestamp) {
        this.expirationTimestamp = expirationTimestamp;
    }

    public MerchantMetadata getMerchantMetadata() {
        return merchantMetadata;
    }

    public void setMerchantMetadata(MerchantMetadata merchantMetadata) {
        this.merchantMetadata = merchantMetadata;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public StatusDetails<ReasonCode, State> getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(StatusDetails<ReasonCode, State> statusDetails) {
        this.statusDetails = statusDetails;
    }

    public Price getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Price convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getReleaseEnvironment() {
        return releaseEnvironment;
    }

    public void setReleaseEnvironment(String releaseEnvironment) {
        this.releaseEnvironment = releaseEnvironment;
    }


    public enum State {
        AUTHORIZATION_INITIATED("AuthorizationInitiated"),
        AUTHORIZED("Authorized"),
        CAPTURE_INITIATED("CaptureInitiated"),
        CAPTURED("Captured"),
        CANCELED("Canceled"),
        DECLINED("Declined"),
        UNKNOWN("Unknown");

        private final String name;

        State(final String name) {
            this.name = name;
        }

        public static Charge.State enumOf(final String name) {
            for (Charge.State value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static Charge.State fromString(String string) {
            return Charge.State.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public enum ReasonCode {
        EXPIRED_UNUSED("ExpiredUnused"),
        AMAZON_CANCELED("AmazonCanceled"),
        MERCHANT_CANCELED("MerchantCanceled"),
        CHARGE_PERMISSION_CANCELED("ChargePermissionCanceled"),
        BUYER_CANCELED("BuyerCanceled"),
        SOFT_DECLINED("SoftDeclined"),
        HARD_DECLINED("HardDeclined"),
        AMAZON_REJECTED("AmazonRejected"),
        PROCESSING_FAILURE("ProcessingFailure"),
        TRANSACTION_TIMED_OUT("TransactionTimedOut"),

        UNKNOWN("Unknown");

        private final String name;

        ReasonCode(final String name) {
            this.name = name;
        }

        public static Charge.ReasonCode enumOf(final String name) {
            for (Charge.ReasonCode value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static Charge.ReasonCode fromString(String string) {
            return Charge.ReasonCode.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

}
