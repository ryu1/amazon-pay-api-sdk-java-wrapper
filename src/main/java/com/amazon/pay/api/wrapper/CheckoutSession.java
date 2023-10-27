package com.amazon.pay.api.wrapper;

import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertySetStrategy;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckoutSession implements Serializable {

    private static final long serialVersionUID = 1L;
    private Address billingAddress;
    private Buyer buyer;
    private String chargeId;
    private String chargePermissionId;
    private ChargePermissionType chargePermissionType;
    private String checkoutSessionId;
    private List<Constraint> constraints;
    private Date creationTimestamp;
    private DeliverySpecifications deliverySpecifications;
    private Date expirationTimestamp;
    private MerchantMetadata merchantMetadata;
    private PaymentDetails paymentDetails;
    private List<PaymentPreferences> paymentPreferences;
    private String platformId;
    private String productType;
    private ProviderMetadata providerMetadata;
    private RecurringMetadata recurringMetadata;
    private String ReleaseEnvironment;
    private Address shippingAddress;
    private StatusDetails statusDetails;
    private String storeId;
    private String supplementaryData;
    private WebCheckoutDetails webCheckoutDetails;

    public CheckoutSession() {
        super();
    }

    public static CheckoutSession createObject(JSONObject jsonObject) {

        JsonConfig config = new JsonConfig();

        @SuppressWarnings("rawtypes")
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("billingAddress", Address.class);
        classMap.put("buyer", Buyer.class);
        classMap.put("constraints", Constraint.class);

        classMap.put("deliverySpecifications", DeliverySpecifications.class);

        classMap.put("addressRestrictions", AddressRestrictions.class);
//			classMap.put("restrictions", Map<String, Restriction>.class);
        classMap.put("US", Restriction.class);
        classMap.put("JP", Restriction.class);
        classMap.put("GB", Restriction.class);
        classMap.put("IN", Restriction.class);

        classMap.put("merchantMetadata", MerchantMetadata.class);

        classMap.put("paymentDetails", PaymentDetails.class);
        classMap.put("chargeAmount", Price.class);
        classMap.put("totalOrderAmount", Price.class);

        classMap.put("paymentPreferences", PaymentPreferences.class);
        classMap.put("providerMetadata", ProviderMetadata.class);

        classMap.put("recurringMetadata", RecurringMetadata.class);
        classMap.put("amount", Price.class);
        classMap.put("frequency", Frequency.class);

        classMap.put("shippingAddress", Address.class);
        classMap.put("statusDetails", StatusDetails.class);
        classMap.put("WebCheckoutDetails", WebCheckoutDetails.class);
        config.setPropertySetStrategy(new PropertyStrategyWrapper(PropertySetStrategy.DEFAULT));
        config.setClassMap(classMap);
        config.setRootClass(CheckoutSession.class);


        // フォーマット指定
        MorpherRegistry mr = JSONUtils.getMorpherRegistry();
        mr.registerMorpher(new DateMorpher(new String[]{"yyyyMMdd't'HHmmss'z'"}));

        mr.registerMorpher(new CustomEnumMorpher(ChargePermissionType.class));
        mr.registerMorpher(new CustomEnumMorpher(PaymentIntent.class));
        mr.registerMorpher(new CustomEnumMorpher(Unit.class));
        mr.registerMorpher(new CustomEnumMorpher(ReasonCode.class));
        mr.registerMorpher(new CustomEnumMorpher(State.class));
        mr.registerMorpher(new CustomEnumMorpher(CheckoutMode.class));
        mr.registerMorpher(new CustomEnumMorpher(Type.class));

        // https://www.doraxdora.com/blog/2019/04/24/post-8324/
        CheckoutSession checkoutSession = (CheckoutSession) JSONObject.toBean(jsonObject, config);

        return checkoutSession;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
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

    public ChargePermissionType getChargePermissionType() {
        return chargePermissionType;
    }

    public void setChargePermissionType(ChargePermissionType chargePermissionType) {
        this.chargePermissionType = chargePermissionType;
    }

    public String getCheckoutSessionId() {
        return checkoutSessionId;
    }

    public void setCheckoutSessionId(String checkoutSessionId) {
        this.checkoutSessionId = checkoutSessionId;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public DeliverySpecifications getDeliverySpecifications() {
        return deliverySpecifications;
    }

    public void setDeliverySpecifications(DeliverySpecifications deliverySpecifications) {
        this.deliverySpecifications = deliverySpecifications;
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

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<PaymentPreferences> getPaymentPreferences() {
        return paymentPreferences;
    }

    public void setPaymentPreferences(List<PaymentPreferences> paymentPreferences) {
        this.paymentPreferences = paymentPreferences;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public ProviderMetadata getProviderMetadata() {
        return providerMetadata;
    }

    public void setProviderMetadata(ProviderMetadata providerMetadata) {
        this.providerMetadata = providerMetadata;
    }

    public RecurringMetadata getRecurringMetadata() {
        return recurringMetadata;
    }

    public void setRecurringMetadata(RecurringMetadata recurringMetadata) {
        this.recurringMetadata = recurringMetadata;
    }

    public String getReleaseEnvironment() {
        return ReleaseEnvironment;
    }

    public void setReleaseEnvironment(String releaseEnvironment) {
        ReleaseEnvironment = releaseEnvironment;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public StatusDetails getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(StatusDetails statusDetails) {
        this.statusDetails = statusDetails;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSupplementaryData() {
        return supplementaryData;
    }

    public void setSupplementaryData(String supplementaryData) {
        this.supplementaryData = supplementaryData;
    }

    public WebCheckoutDetails getWebCheckoutDetails() {
        return webCheckoutDetails;
    }

    public void setWebCheckoutDetails(WebCheckoutDetails webCheckoutDetails) {
        this.webCheckoutDetails = webCheckoutDetails;
    }

    @Override
    public String toString() {
        return "CheckoutSession [checkoutSessionId=" + checkoutSessionId + ", chargePermissionType="
                + chargePermissionType + ", recurringMetadata=" + recurringMetadata + ", webCheckoutDetails="
                + webCheckoutDetails + ", productType=" + productType + ", paymentDetails=" + paymentDetails
                + ", merchantMetadata=" + merchantMetadata + ", platformId=" + platformId + ", providerMetadata="
                + providerMetadata + ", buyer=" + buyer + ", shippingAddress=" + shippingAddress
                + ", billingAddress=" + billingAddress + ", paymentPreferences=" + paymentPreferences
                + ", statusDetails=" + statusDetails + ", constraints=" + constraints + ", creationTimestamp="
                + creationTimestamp + ", expirationTimestamp=" + expirationTimestamp + ", chargePermissionId="
                + chargePermissionId + ", chargeId=" + chargeId + ", storeId=" + storeId
                + ", deliverySpecifications=" + deliverySpecifications + ", ReleaseEnvironment="
                + ReleaseEnvironment + ", supplementaryData=" + supplementaryData + "]";
    }

    public enum ChargePermissionType {

        ONE_TIME("OneTime"), RECURRING("Recurring"), UNKNOWN("Unknown");

        private final String name;

        ChargePermissionType(final String name) {
            this.name = name;
        }

        public static ChargePermissionType enumOf(final String name) {
            for (ChargePermissionType value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static ChargePermissionType fromString(String string) {
            return ChargePermissionType.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public enum CheckoutMode {

        PROCESS_ORDER("ProcessOrder"), UNKNOWN("Unknown");

        private final String name;

        CheckoutMode(final String name) {
            this.name = name;
        }

        public static CheckoutMode enumOf(final String name) {
            for (CheckoutMode value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static CheckoutMode fromString(String string) {
            return CheckoutMode.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public enum PaymentIntent {

        AUTHORIZE("Authorize"), AUTHORIZE_WITH_CAPTURE("AuthorizeWithCapture"), CONFIRM("Confirm"),
        UNKNOWN("Unknown");

        private final String name;

        PaymentIntent(final String name) {
            this.name = name;
        }

        public static PaymentIntent enumOf(final String name) {
            for (PaymentIntent value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static PaymentIntent fromString(String string) {
            return PaymentIntent.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public enum ReasonCode {
        AMAZON_CANCELED("AmazonCanceled"), BUYER_CANCELED("BuyerCanceled"), DECLINED("Declined"),
        EXPIRED("Expired"), UNKNOWN("Unknown");

        private final String name;

        ReasonCode(final String name) {
            this.name = name;
        }

        public static ReasonCode enumOf(final String name) {
            for (ReasonCode value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static ReasonCode fromString(String string) {
            return ReasonCode.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public enum State {
        CANCELED("Canceled"), COMPLETED("Completed"), OPEN("Open"), UNKNOWN("Unknown");

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

    public enum Type {
        ALLOWED("Allowed"), NOT_ALLOWED("NotAllowed"), UNKNOWN("Unknown");

        private final String name;

        Type(final String name) {
            this.name = name;
        }

        public static Type enumOf(final String name) {
            for (Type value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static Type fromString(String string) {
            return Type.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public enum Unit {

        DAY("Day"), MONTH("Month"), UNKNOWN("Unknown"), VARIABLE("Variable"), WEEK("Week"), YEAR("Year");

        private final String name;

        Unit(final String name) {
            this.name = name;
        }

        public static Unit enumOf(final String name) {
            for (Unit value : values()) {
                if (StringUtils.equals(value.getName(), name)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static Unit fromString(String string) {
            return Unit.enumOf(string);
        }

        private String getName() {
            return this.name;
        }
    }

    public static class Address implements Serializable {

        private static final long serialVersionUID = 1L;

        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String city;
        private String countryCode;
        private String county;
        private String district;
        private String name;
        private String phoneNumber;
        private String postalCode;
        private String stateOrRegion;

        public Address() {
            super();
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getAddressLine3() {
            return addressLine3;
        }

        public void setAddressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getStateOrRegion() {
            return stateOrRegion;
        }

        public void setStateOrRegion(String stateOrRegion) {
            this.stateOrRegion = stateOrRegion;
        }

        @Override
        public String toString() {
            return "Address [name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
                    + ", addressLine3=" + addressLine3 + ", city=" + city + ", county=" + county + ", district="
                    + district + ", stateOrRegion=" + stateOrRegion + ", postalCode=" + postalCode
                    + ", countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + "]";
        }

    }

    public static class AddressRestrictions implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private Map<String, Restriction> restrictions;
        //			private Map restrictions;
        private Type type;

        public AddressRestrictions() {
            super();
        }

        public Map<String, Restriction> getRestrictions() {
//			public Map getRestrictions() {
            return restrictions;
        }

        public void setRestrictions(Map<String, Restriction> restrictions) {
//			public void setRestrictions(Map restrictions) {
            this.restrictions = restrictions;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "AddressRestrictions [type=" + type + ", restrictions=" + restrictions + "]";
        }

    }

    public static class Buyer implements Serializable {

        private static final long serialVersionUID = 1L;

        private String buyerId;
        private String email;
        private String name;
        private String phoneNumber;
        //	    	primeMembershipTypes

        public Buyer() {
            super();
        }

        public String getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(String buyerId) {
            this.buyerId = buyerId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Buyer [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNumber="
                    + phoneNumber + "]";
        }

    }

    public static class Constraint implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private String constraintId;
        private String description;

        public Constraint() {
            super();
        }

        public String getConstraintId() {
            return constraintId;
        }

        public void setConstraintId(String constraintId) {
            this.constraintId = constraintId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Constraint [constraintId=" + constraintId + ", description=" + description + "]";
        }

    }

    public static class DeliverySpecifications implements Serializable {

        private static final long serialVersionUID = 1L;

        private AddressRestrictions addressRestrictions;
        private List<String> specialRestrictions;

        public DeliverySpecifications() {
            super();
        }

        public AddressRestrictions getAddressRestrictions() {
            return addressRestrictions;
        }

        public void setAddressRestrictions(AddressRestrictions addressRestrictions) {
            this.addressRestrictions = addressRestrictions;
        }

        public List<String> getSpecialRestrictions() {
            return specialRestrictions;
        }

        public void setSpecialRestrictions(List<String> specialRestrictions) {
            this.specialRestrictions = specialRestrictions;
        }

        @Override
        public String toString() {
            return "DeliverySpecifications [specialRestrictions=" + specialRestrictions + ", addressRestrictions="
                    + addressRestrictions + "]";
        }

    }

    public static class Frequency implements Serializable {

        private static final long serialVersionUID = 1L;
        private Unit unit;
        private String value;

        public Frequency() {
            super();
        }

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Frequency [unit=" + unit + ", value=" + value + "]";
        }
    }

    public static class PaymentDetails implements Serializable {

        private static final long serialVersionUID = 1L;

        private Boolean allowOvercharge;
        private Boolean canHandlePendingAuthorization;
        private Price chargeAmount;
        private Boolean extendExpiration;
        private PaymentIntent paymentIntent;
        private String presentmentCurrency;
        private String softDescriptor;
        private Price totalOrderAmount;

        public PaymentDetails() {
            super();
        }

        public Price getChargeAmount() {
            return chargeAmount;
        }

        public void setChargeAmount(Price chargeAmount) {
            this.chargeAmount = chargeAmount;
        }

        public PaymentIntent getPaymentIntent() {
            return paymentIntent;
        }

        public void setPaymentIntent(PaymentIntent paymentIntent) {
            this.paymentIntent = paymentIntent;
        }

        public String getPresentmentCurrency() {
            return presentmentCurrency;
        }

        public void setPresentmentCurrency(String presentmentCurrency) {
            this.presentmentCurrency = presentmentCurrency;
        }

        public String getSoftDescriptor() {
            return softDescriptor;
        }

        public void setSoftDescriptor(String softDescriptor) {
            this.softDescriptor = softDescriptor;
        }

        public Price getTotalOrderAmount() {
            return totalOrderAmount;
        }

        public void setTotalOrderAmount(Price totalOrderAmount) {
            this.totalOrderAmount = totalOrderAmount;
        }

        public Boolean isAllowOvercharge() {
            return allowOvercharge;
        }

        public Boolean isCanHandlePendingAuthorization() {
            return canHandlePendingAuthorization;
        }

        public Boolean isExtendExpiration() {
            return extendExpiration;
        }

        public void setAllowOvercharge(Boolean allowOvercharge) {
            this.allowOvercharge = allowOvercharge;
        }

        public void setCanHandlePendingAuthorization(Boolean canHandlePendingAuthorization) {
            this.canHandlePendingAuthorization = canHandlePendingAuthorization;
        }

        public void setExtendExpiration(Boolean extendExpiration) {
            this.extendExpiration = extendExpiration;
        }

        @Override
        public String toString() {
            return "PaymentDetails [paymentIntent=" + paymentIntent + ", canHandlePendingAuthorization="
                    + canHandlePendingAuthorization + ", chargeAmount=" + chargeAmount + ", totalOrderAmount="
                    + totalOrderAmount + ", presentmentCurrency=" + presentmentCurrency + ", softDescriptor="
                    + softDescriptor + ", allowOvercharge=" + allowOvercharge + ", extendExpiration="
                    + extendExpiration + "]";
        }

    }

    public static class PaymentPreferences implements Serializable {

        private static final long serialVersionUID = 1L;

        private String paymentDescriptor;

        public PaymentPreferences() {
            super();
        }

        public String getPaymentDescriptor() {
            return paymentDescriptor;
        }

        public void setPaymentDescriptor(String paymentDescriptor) {
            this.paymentDescriptor = paymentDescriptor;
        }

        @Override
        public String toString() {
            return "PaymentPreferences [paymentDescriptor=" + paymentDescriptor + "]";
        }

    }

    public static class RecurringMetadata implements Serializable {

        private static final long serialVersionUID = 1L;
        private Price amount;
        private Frequency frequency;

        public RecurringMetadata() {
            super();
        }

        public Price getAmount() {
            return amount;
        }

        public void setAmount(Price amount) {
            this.amount = amount;
        }

        public Frequency getFrequency() {
            return frequency;
        }

        public void setFrequency(Frequency frequency) {
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "RecurringMetadata [frequency=" + frequency + ", amount=" + amount + "]";
        }

    }

    public static class Restriction implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private List<String> statesOrRegions;
        private List<String> zipCodes;

        public Restriction() {
            super();
        }

        public List<String> getStatesOrRegions() {
            return statesOrRegions;
        }

        public void setStatesOrRegions(List<String> statesOrRegions) {
            this.statesOrRegions = statesOrRegions;
        }

        public List<String> getZipCodes() {
            return zipCodes;
        }

        public void setZipCodes(List<String> zipCodes) {
            this.zipCodes = zipCodes;
        }

        @Override
        public String toString() {
            return "Restriction [statesOrRegions=" + statesOrRegions + ", zipCodes=" + zipCodes + "]";
        }

    }

    public static class WebCheckoutDetails implements Serializable {
        private static final long serialVersionUID = 1L;
        private String amazonPayRedirectUrl;
        private String checkoutCancelUrl;
        private CheckoutMode checkoutMode;
        private String checkoutResultReturnUrl;
        private String checkoutReviewReturnUrl;

        public WebCheckoutDetails() {
            super();
        }

        public String getAmazonPayRedirectUrl() {
            return amazonPayRedirectUrl;
        }

        public void setAmazonPayRedirectUrl(String amazonPayRedirectUrl) {
            this.amazonPayRedirectUrl = amazonPayRedirectUrl;
        }

        public String getCheckoutCancelUrl() {
            return checkoutCancelUrl;
        }

        public void setCheckoutCancelUrl(String checkoutCancelUrl) {
            this.checkoutCancelUrl = checkoutCancelUrl;
        }

        public CheckoutMode getCheckoutMode() {
            return checkoutMode;
        }

        public void setCheckoutMode(CheckoutMode checkoutMode) {
            this.checkoutMode = checkoutMode;
        }

        public String getCheckoutResultReturnUrl() {
            return checkoutResultReturnUrl;
        }

        public void setCheckoutResultReturnUrl(String checkoutResultReturnUrl) {
            this.checkoutResultReturnUrl = checkoutResultReturnUrl;
        }

        public String getCheckoutReviewReturnUrl() {
            return checkoutReviewReturnUrl;
        }

        public void setCheckoutReviewReturnUrl(String checkoutReviewReturnUrl) {
            this.checkoutReviewReturnUrl = checkoutReviewReturnUrl;
        }

        @Override
        public String toString() {
            return "WebCheckoutDetails [checkoutReviewReturnUrl=" + checkoutReviewReturnUrl
                    + ", checkoutResultReturnUrl=" + checkoutResultReturnUrl + ", checkoutCancelUrl="
                    + checkoutCancelUrl + ", amazonPayRedirectUrl=" + amazonPayRedirectUrl + ", checkoutMode="
                    + checkoutMode + "]";
        }

    }

    public static class StatusDetails extends com.amazon.pay.api.wrapper.StatusDetails<CheckoutSession.ReasonCode, CheckoutSession.State> {
    }

}
