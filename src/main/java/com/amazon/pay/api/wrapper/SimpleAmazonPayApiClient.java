package com.amazon.pay.api.wrapper;

import com.amazon.pay.api.AmazonPayResponse;
import com.amazon.pay.api.PayConfiguration;
import com.amazon.pay.api.WebstoreClient;
import com.amazon.pay.api.exceptions.AmazonPayClientException;
import com.amazon.pay.api.types.Environment;
import com.amazon.pay.api.types.Region;
import net.sf.json.JSONObject;
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
 * https://github.com/amzn/amazon-pay-api-sdk-java
 *
 * @author ishitsuka
 */
public class SimpleAmazonPayApiClient {

    private final Log log = LogFactory.getLog(this.getClass());

    private final WebstoreClient client;

    public SimpleAmazonPayApiClient(final String privateKeyFilePath, final String publicKeyId, final String environment)
            throws AmazonPayClientException, IOException {
        client = getWebstoreClient(privateKeyFilePath, publicKeyId, environment);
    }

    private static PayConfiguration createPayConfiguration(final String privateKeyFilePath, final String publicKeyId,
                                                           final String environment) throws AmazonPayClientException, IOException {
        PayConfiguration configuration = new PayConfiguration()
                .setPublicKeyId(publicKeyId).setRegion(Region.JP)
                .setPrivateKey(new String(Files.readAllBytes(Paths.get(privateKeyFilePath))).toCharArray())
                .setEnvironment(Environment.valueOf(environment));
        return configuration;
    }

    private static WebstoreClient getWebstoreClient(final String privateKeyFilePath, final String publicKeyId, final String environment)
            throws AmazonPayClientException, IOException {
        return new WebstoreClient(createPayConfiguration(privateKeyFilePath, publicKeyId, environment));
    }

    /**
     * Get Refund
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/refund.html
     *
     * @param refundId
     * @return refund
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeRecievedException
     */
    public Refund getRefund(final String refundId) throws AmazonPayClientException, ErrorStatusCodeRecievedException {
        AmazonPayResponse res = client.getRefund(refundId);
        log.debug(res);
        JSONObject json = res.getResponse();

        if (res.isSuccess()) {
            return Refund.createObject(json);
        }
        throw new ErrorStatusCodeRecievedException(res.getStatus());
    }

    /**
     * Create Refund
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/refund.html#create-refund
     *
     * @param chargeId
     * @param amount
     * @return Refund
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeRecievedException
     */
    public Refund createRefund(final String chargeId, final String amount) throws AmazonPayClientException, ErrorStatusCodeRecievedException {
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

        try {
            response = client.createRefund(payload, header);
            log.debug(response);
        } catch (AmazonPayClientException e) {
            log.warn(e);
            e.printStackTrace();
        }
        if (response.isSuccess()) {
            JSONObject json = response.getResponse();
            return Refund.createObject(json);
        }
        throw new ErrorStatusCodeRecievedException(response.getStatus());
    }

    /**
     * getCheckoutSession
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/checkout-session.html#get-checkout-session
     *
     * @param checkoutSessionId
     * @return checkoutSession
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeRecievedException
     */
    public CheckoutSession getCheckoutSession(final String checkoutSessionId) throws AmazonPayClientException, ErrorStatusCodeRecievedException {
        AmazonPayResponse response = client.getCheckoutSession(checkoutSessionId);
        log.debug(response);
        if (response.isSuccess()) {
            JSONObject json = response.getResponse();
            return CheckoutSession.createObject(json);
        }

        throw new ErrorStatusCodeRecievedException(response.getStatus());
    }


    /**
     * updateCheckoutSession
     * <p>
     * https://developer.amazon.com/ja/docs/amazon-pay-api-v2/checkout-session.html#update-checkout-session
     *
     * @param checkoutSessionId
     * @param merchantReferenceId
     * @param amount
     * @param checkoutResultReturnUrl
     * @return checkoutSession
     * @throws AmazonPayClientException
     * @throws ErrorStatusCodeRecievedException
     */
    public CheckoutSession updateCheckoutSession(final String checkoutSessionId, final String merchantReferenceId,
                                                 final String amount, final String checkoutResultReturnUrl) throws AmazonPayClientException, ErrorStatusCodeRecievedException {

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
        log.debug(response);

        if (response.isSuccess()) {
            JSONObject json = response.getResponse();
            return CheckoutSession.createObject(json);
        }

        throw new ErrorStatusCodeRecievedException(response.getStatus());
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
     * @throws ErrorStatusCodeRecievedException
     */
    public CheckoutSession completeCheckoutSession(final String checkoutSessionId, final String amount) throws AmazonPayClientException, ErrorStatusCodeRecievedException {
        AmazonPayResponse response = null;
        JSONObject payload = new JSONObject();

        JSONObject chargeAmount = new JSONObject();
        chargeAmount.put("amount", amount);
        chargeAmount.put("currencyCode", "JPY");
        payload.put("chargeAmount", chargeAmount);

        response = client.completeCheckoutSession(checkoutSessionId, payload);
        log.debug(response);

        if (response.isSuccess()) {
            JSONObject json = response.getResponse();
            return CheckoutSession.createObject(json);
        }

        throw new ErrorStatusCodeRecievedException(response.getStatus());
    }

    public Charge createCharge(final String chargePermissionId, final String amount) throws AmazonPayClientException, ErrorStatusCodeRecievedException {
        JSONObject chargeAmount = new JSONObject();
        chargeAmount.put("amount", amount);
        chargeAmount.put("currencyCode", "JPY");

        JSONObject payload = new JSONObject();
        payload.put("chargePermissionId", chargePermissionId);
        payload.put("chargeAmount", chargeAmount);
        payload.put("captureNow", true);
        payload.put("softDescriptor", "AMZ * <SELLER_NAME> pay.amazon.co.jp");
        payload.put("canHandlePendingAuthorization", false);

        Map<String, String> header = new HashMap<String, String>();
        header.put("x-amz-pay-idempotency-key", UUID.randomUUID().toString().replace("-", ""));

        AmazonPayResponse response = client.createCharge(payload, header);
        log.debug(response);
        if (response.isSuccess()) {
            JSONObject json = response.getResponse();
            return Charge.createObject(json);
        }
        throw new ErrorStatusCodeRecievedException(response.getStatus());
    }

    public Charge getCharge(final String chargeId) throws AmazonPayClientException, ErrorStatusCodeRecievedException {
        AmazonPayResponse response = client.getCharge(chargeId);
        log.debug(response);
        if (response.isSuccess()) {
            JSONObject json = response.getResponse();
            return Charge.createObject(json);
        }

        throw new ErrorStatusCodeRecievedException(response.getStatus());
    }

}
