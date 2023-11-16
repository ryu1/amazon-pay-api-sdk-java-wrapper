package com.amazon.pay.api.wrapper;

import com.amazon.pay.api.AmazonPayResponse;
import com.amazon.pay.api.PayConfiguration;
import com.amazon.pay.api.WebstoreClient;
import com.amazon.pay.api.exceptions.AmazonPayClientException;
import com.amazon.pay.api.types.Environment;
import com.amazon.pay.api.types.Region;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * SimpleAmazonPayApiClient
 * <p>
 * <a href="https://github.com/amzn/amazon-pay-api-sdk-java">amazon-pay-api-sdk-java</a>
 *
 * @author ishitsuka
 */
@SuppressWarnings("unused")
public class SimpleAmazonPayApiClient {

    private final Log log = LogFactory.getLog(this.getClass());

    private final WebstoreClient client;

    private final Environment environment;

    public SimpleAmazonPayApiClient(final String privateKeyFilePath, final String publicKeyId, final String environment)
            throws AmazonPayClientException, IOException {
        this.environment = Environment.valueOf(environment);
        client = getWebstoreClient(privateKeyFilePath, publicKeyId, this.environment.name());
    }

    private static PayConfiguration createPayConfiguration(final String privateKeyFilePath, final String publicKeyId,
                                                           final String environment) throws AmazonPayClientException, IOException {
        return new PayConfiguration()
                .setPublicKeyId(publicKeyId).setRegion(Region.JP)
                .setPrivateKey(new String(Files.readAllBytes(Paths.get(privateKeyFilePath))).toCharArray())
                .setEnvironment(Environment.valueOf(environment));
    }

    private static WebstoreClient getWebstoreClient(final String privateKeyFilePath, final String publicKeyId, final String environment)
            throws AmazonPayClientException, IOException {
        return new WebstoreClient(createPayConfiguration(privateKeyFilePath, publicKeyId, environment));
    }

    /**
     * Get Refund
     * <p>
     * <a href="https://developer.amazon.com/ja/docs/amazon-pay-api-v2/refund.html">refund</a>
     *
     * @param refundId refundId
     * @return refund
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeReceivedException
     */
    public Refund getRefund(final String refundId) throws AmazonPayClientException, ErrorStatusCodeReceivedException {
        AmazonPayResponse response = client.getRefund(refundId);
        //noinspection DuplicatedCode
        log.debug(response);
        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return Refund.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }

    /**
     * Create Refund
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/refund.html#create-refund
     *
     * @param chargeId chargeId
     * @param amount   amount
     * @return Refund
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeReceivedException
     */
    public Refund createRefund(final String chargeId, final String amount) throws AmazonPayClientException, ErrorStatusCodeReceivedException {
        AmazonPayResponse response = null;

        JSONObject payload = new JSONObject();
        JSONObject refundAmount = new JSONObject();
        refundAmount.put("amount", amount);
        refundAmount.put("currencyCode", "JPY");
        payload.put("chargeId", chargeId);
        payload.put("refundAmount", refundAmount);
        payload.put("softDescriptor", "AMZ*soft");

        Map<String, String> header = new HashMap<String, String>();
        header.put("x-amz-pay-idempotency-key", UUID.randomUUID().toString().replace("-", ""));

        response = client.createRefund(payload, header);
        //noinspection DuplicatedCode
        log.debug(response);
        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return Refund.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }

    /**
     * getCheckoutSession
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/checkout-session.html#get-checkout-session
     *
     * @param checkoutSessionId checkoutSessionId
     * @return checkoutSession
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeReceivedException
     */
    public CheckoutSession getCheckoutSession(final String checkoutSessionId) throws AmazonPayClientException, ErrorStatusCodeReceivedException {
        AmazonPayResponse response = client.getCheckoutSession(checkoutSessionId);
        //noinspection DuplicatedCode
        log.debug(response);
        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return CheckoutSession.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }


    /**
     * updateCheckoutSession
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/checkout-session.html#update-checkout-session
     *
     * @param checkoutSessionId       checkoutSessionId
     * @param merchantReferenceId     merchantReferenceId
     * @param amount                  amount
     * @param checkoutResultReturnUrl checkoutResultReturnUrl
     * @return checkoutSession
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeReceivedException
     */
    public CheckoutSession updateCheckoutSession(final String checkoutSessionId, final String merchantReferenceId,
                                                 final String amount, final String checkoutResultReturnUrl) throws AmazonPayClientException, ErrorStatusCodeReceivedException {

        AmazonPayResponse response = null;
        JSONObject payload = new JSONObject();
        JSONObject updateWebCheckoutDetails = new JSONObject();
        updateWebCheckoutDetails.put("checkoutResultReturnUrl", checkoutResultReturnUrl);
        payload.put("webCheckoutDetails", updateWebCheckoutDetails);

        JSONObject paymentDetail = new JSONObject();
        paymentDetail.put("paymentIntent", "AuthorizeWithCapture");
        paymentDetail.put("canHandlePendingAuthorization", false);
        JSONObject chargeAmount = new JSONObject();
        chargeAmount.put("amount", amount);
        chargeAmount.put("currencyCode", "JPY");
        paymentDetail.put("chargeAmount", chargeAmount);
        payload.put("paymentDetails", paymentDetail);

        JSONObject merchantMetadata = new JSONObject();
        merchantMetadata.put("merchantReferenceId", merchantReferenceId);
        payload.put("merchantMetadata", merchantMetadata);

        response = client.updateCheckoutSession(checkoutSessionId, payload);
        //noinspection DuplicatedCode
        log.debug(response);
        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return CheckoutSession.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }

    /**
     * completeCheckoutSession
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/checkout-session.html#complete-checkout-session
     *
     * @param checkoutSessionId
     * @param amount
     * @return checkoutSession
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeReceivedException
     */
    public CheckoutSession completeCheckoutSession(final String checkoutSessionId, final String amount) throws AmazonPayClientException, ErrorStatusCodeReceivedException {
        AmazonPayResponse response = null;
        JSONObject payload = new JSONObject();

        JSONObject chargeAmount = new JSONObject();
        chargeAmount.put("amount", amount);
        chargeAmount.put("currencyCode", "JPY");
        payload.put("chargeAmount", chargeAmount);

        response = client.completeCheckoutSession(checkoutSessionId, payload);
        //noinspection DuplicatedCode
        log.debug(response);

        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return CheckoutSession.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }

    public Charge createCharge(final String chargePermissionId, final String amount, final String merchantReferenceId ,final Boolean captureNow, final String simulationCode) throws AmazonPayClientException, ErrorStatusCodeReceivedException {
        JSONObject chargeAmount = new JSONObject();
        chargeAmount.put("amount", amount);
        chargeAmount.put("currencyCode", "JPY");

        JSONObject merchantMetadata = new JSONObject();
        merchantMetadata.put("merchantReferenceId", merchantReferenceId);

        JSONObject payload = new JSONObject();
        payload.put("chargePermissionId", chargePermissionId);
        payload.put("captureNow", captureNow);
        payload.put("chargeAmount", chargeAmount);
        payload.put("merchantMetadata", merchantMetadata);
        payload.put("chargeInitiator", Charge.ChargeInitiator.CITU.toString());
        payload.put("canHandlePendingAuthorization", false);

        Map<String, String> header = new HashMap<String, String>();
        header.put("x-amz-pay-idempotency-key", UUID.randomUUID().toString().replace("-", ""));

        if (environment == Environment.SANDBOX && !StringUtils.isBlank(simulationCode)) {
            header.put("x-amz-pay-simulation-code", simulationCode);
            log.debug(String.format("x-amz-pay-simulation-code is %s.", simulationCode));
        }

        AmazonPayResponse response = client.createCharge(payload, header);
        //noinspection DuplicatedCode
        log.debug(response);
        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return Charge.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }

    public Charge getCharge(final String chargeId) throws AmazonPayClientException, ErrorStatusCodeReceivedException {
        AmazonPayResponse response = client.getCharge(chargeId);
        //noinspection DuplicatedCode
        log.debug(response);
        JSONObject json = response.getResponse();
        if (response.isSuccess()) {
            return Charge.createObject(json);
        }
        final String reasonCode = (String) json.get("reasonCode");
        final String message = (String) json.get("message");
        throw new ErrorStatusCodeReceivedException(response.getStatus(), reasonCode, message);
    }

}
