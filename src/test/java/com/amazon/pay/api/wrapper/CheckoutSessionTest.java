package com.amazon.pay.api.wrapper;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSessionTest {


    @Test
    public void testCheckoutSessionCreateObject1() {
        String json = "{\n" + "    \"webCheckoutDetails\": {\n"
                + "        \"checkoutResultReturnUrl\": \"https://a.com/merchant-confirm-page\"\n" + "    },\n"
                + "    \"paymentDetails\": {\n" + "        \"paymentIntent\": \"AuthorizeWithCapture\",\n"
                + "        \"canHandlePendingAuthorization\":false,\n" + "        \"softDescriptor\": \"Descriptor\",\n"
                + "        \"chargeAmount\": {\n" + "            \"amount\": \"1\",\n"
                + "            \"currencyCode\": \"USD\"\n" + "        }\n" + "     },\n"
                + "    \"merchantMetadata\": {\n" + "        \"merchantReferenceId\": \"Merchant reference ID\",\n"
                + "        \"merchantStoreName\": \"Merchant store name\",\n"
                + "        \"noteToBuyer\": \"Note to buyer\",\n"
                + "        \"customInformation\": \"Custom information\"\n" + "    }\n" + "}\n";

        JSONObject jsonObject = JSONObject.fromObject(json);
        CheckoutSession checkoutSession = CheckoutSession.createObject(jsonObject);
        // System.out.println(checkoutSession);
        assertEquals(checkoutSession.toString(),
                "CheckoutSession [checkoutSessionId=null, chargePermissionType=null, recurringMetadata=null, webCheckoutDetails=WebCheckoutDetails [checkoutReviewReturnUrl=null, checkoutResultReturnUrl=https://a.com/merchant-confirm-page, checkoutCancelUrl=null, amazonPayRedirectUrl=null, checkoutMode=null], productType=null, paymentDetails=PaymentDetails [paymentIntent=AUTHORIZE_WITH_CAPTURE, canHandlePendingAuthorization=false, chargeAmount=Price [amount=1, currencyCode=USD], totalOrderAmount=null, presentmentCurrency=null, softDescriptor=Descriptor, allowOvercharge=null, extendExpiration=null], merchantMetadata=MerchantMetadata [merchantReferenceId=Merchant reference ID, merchantStoreName=Merchant store name, noteToBuyer=Note to buyer, customInformation=Custom information], platformId=null, providerMetadata=null, buyer=null, shippingAddress=null, billingAddress=null, paymentPreferences=null, statusDetails=null, constraints=null, creationTimestamp=null, expirationTimestamp=null, chargePermissionId=null, chargeId=null, storeId=null, deliverySpecifications=null, ReleaseEnvironment=null, supplementaryData=null]");

    }

    @Test
    public void testCheckoutSessionCreateObject2() {
        String json = "{\n" + "    \"checkoutSessionId\": \"bd504926-f659-4ad7-a1a9-9a747aaf5275\",\n"
                + "    \"webCheckoutDetails\": {\n"
                + "        \"checkoutReviewReturnUrl\": \"https://a.com/merchant-review-page\",\n"
                + "        \"checkoutResultReturnUrl\": null,\n" + "        \"checkoutCancelUrl\": null,\n"
                + "        \"amazonPayRedirectUrl\": null\n" + "    },\n"
                + "    \"chargePermissionType\": \"Recurring\",   \n" + "    \"recurringMetadata\": {\n"
                + "        \"frequency\": { \n" + "            \"unit\": \"Month\", \n"
                + "            \"value\": \"1\" \n" + "        },\n" + "        \"amount\": { \n"
                + "            \"amount\": \"30\",\n" + "            \"currencyCode\": \"USD\"\n" + "        }\n"
                + "    },\n" + "    \"productType\": \"PayAndShip\",\n" + "    \"paymentDetails\": {\n"
                + "        \"paymentIntent\": null,\n" + "        \"canHandlePendingAuthorization\": false,\n"
                + "        \"chargeAmount\": null,\n" + "        \"totalOrderAmount\": null,\n"
                + "        \"softDescriptor\": null,\n" + "        \"presentmentCurrency\": null,\n"
                + "        \"allowOvercharge\": null,\n" + "        \"extendExpiration\": null\n" + "    },\n"
                + "    \"merchantMetadata\": {\n" + "        \"merchantReferenceId\": null,\n"
                + "        \"merchantStoreName\": null,\n" + "        \"noteToBuyer\": null,\n"
                + "        \"customInformation\": null\n" + "    },\n"
                + "    \"supplementaryData\": null, // Amazon Pay system data\n" + "    \"buyer\": {\n"
                + "        \"buyerId\": \"buyerId\",\n" + "        \"name\": \"name-1\",\n"
                + "        \"email\": \"name@amazon.com\",\n" + "        \"phoneNumber\": \"800-000-0000\",\n"
                + "        \"primeMembershipTypes\": null\n" + "    },\n"
                + "    \"billingAddress\": {  // Only available in EU or for PayOnly product type\n"
                + "        \"name\": \"Work\",\n" + "        \"addressLine1\": \"440 Terry Ave\",\n"
                + "        \"addressLine2\": \"\",\n" + "        \"addressLine3\": \"\",\n"
                + "        \"city\": \"Seattle\",\n" + "        \"county\": \"King\",    \n"
                + "        \"district\": \"Seattle\",\n" + "        \"stateOrRegion\": \"WA\",\n"
                + "        \"postalCode\": \"98121\",\n" + "        \"countryCode\": \"US\"\n" + "    },\n"
                + "    \"paymentPreferences\": [\n" + "        {\n"
                + "            \"paymentDescriptor\": \"Your selected Amazon payment method\"\n" + "        }\n"
                + "    ],\n" + "    \"statusDetails\": {\n" + "        \"state\": \"Open\",\n"
                + "        \"reasonCode\": null,\n" + "        \"reasonDescription\": null,\n"
                + "        \"lastUpdatedTimestamp\": \"20191015T204327Z\"\n" + "    },\n"
                + "    \"shippingAddress\": {  // Null for PayOnly product type\n"
                + "        \"name\": \"Susie Smith\",\n" + "        \"addressLine1\": \"10 Ditka Ave\",\n"
                + "        \"addressLine2\": \"Suite 2500\",\n" + "        \"addressLine3\": null,\n"
                + "        \"city\": \"Chicago\",\n" + "        \"county\": null,\n" + "        \"district\": null,\n"
                + "        \"stateOrRegion\": \"IL\",\n" + "        \"postalCode\": \"60602\",\n"
                + "        \"countryCode\": \"US\",\n" + "        \"phoneNumber\": \"800-000-0000\"\n" + "    },\n"
                + "    \"platformId\": null,\n" + "    \"chargePermissionId\": null,\n" + "    \"chargeId\": null,\n"
                + "    \"constraints\": [\n" + "        {\n" + "            \"constraintId\": \"ChargeAmountNotSet\",\n"
                + "            \"description\": \"chargeAmount is not set.\"\n" + "        },\n" + "        {\n"
                + "            \"constraintId\": \"CheckoutResultReturnUrlNotSet\",\n"
                + "            \"description\": \"checkoutResultReturnUrl is not set.\"\n" + "        },\n"
                + "        {\n" + "            \"constraintId\": \"PaymentIntentNotSet\",\n"
                + "            \"description\": \"paymentIntent is not set.\"\n" + "        }\n" + "    ],\n"
                + "    \"creationTimestamp\": \"20191015T204313Z\",\n"
                + "    \"expirationTimestamp\": \"20191016T204313Z\",\n"
                + "    \"storeId\": \"amzn1.application-oa2-client.8b5e45312b5248b69eeaStoreId\",\n"
                + "    \"deliverySpecifications\": {\n" + "        \"specialRestrictions\": [\"RestrictPOBoxes\"],\n"
                + "        \"addressRestrictions\": {\n" + "            \"type\": \"Allowed\",\n"
                + "            \"restrictions\": {\n" + "                \"US\": {\n"
                + "                    \"statesOrRegions\": [\"WA\"],\n"
                + "                    \"zipCodes\": [\"95050\", \"93405\"]\n" + "                },\n"
                + "                \"GB\": {\n" + "                    \"zipCodes\": [\"72046\", \"72047\"]\n"
                + "                },\n" + "                \"IN\": {\n"
                + "                    \"statesOrRegions\": [\"AP\"]\n" + "                },\n"
                + "                \"JP\": {}\n" + "          }\n" + "        }\n" + "    },\n"
                + "    \"providerMetadata\": {\n" + "        \"providerReferenceId\": null\n" + "    },\n"
                + "    \"releaseEnvironment\": \"Sandbox\"\n" + "}\n";

        JSONObject jsonObject = JSONObject.fromObject(json);
        CheckoutSession checkoutSession = CheckoutSession.createObject(jsonObject);
        assertEquals(checkoutSession.getStatusDetails().getState(), CheckoutSession.State.OPEN);
        assertEquals(checkoutSession.toString(),
                "CheckoutSession [checkoutSessionId=bd504926-f659-4ad7-a1a9-9a747aaf5275, chargePermissionType=RECURRING, recurringMetadata=RecurringMetadata [frequency=Frequency [unit=MONTH, value=1], amount=Price [amount=30, currencyCode=USD]], webCheckoutDetails=WebCheckoutDetails [checkoutReviewReturnUrl=https://a.com/merchant-review-page, checkoutResultReturnUrl=null, checkoutCancelUrl=null, amazonPayRedirectUrl=null, checkoutMode=null], productType=PayAndShip, paymentDetails=PaymentDetails [paymentIntent=null, canHandlePendingAuthorization=false, chargeAmount=null, totalOrderAmount=null, presentmentCurrency=null, softDescriptor=null, allowOvercharge=null, extendExpiration=null], merchantMetadata=MerchantMetadata [merchantReferenceId=null, merchantStoreName=null, noteToBuyer=null, customInformation=null], platformId=null, providerMetadata=ProviderMetadata [providerReferenceId=null], buyer=Buyer [buyerId=buyerId, name=name-1, email=name@amazon.com, phoneNumber=800-000-0000], shippingAddress=Address [name=Susie Smith, addressLine1=10 Ditka Ave, addressLine2=Suite 2500, addressLine3=null, city=Chicago, county=null, district=null, stateOrRegion=IL, postalCode=60602, countryCode=US, phoneNumber=800-000-0000], billingAddress=Address [name=Work, addressLine1=440 Terry Ave, addressLine2=, addressLine3=, city=Seattle, county=King, district=Seattle, stateOrRegion=WA, postalCode=98121, countryCode=US, phoneNumber=null], paymentPreferences=[PaymentPreferences [paymentDescriptor=Your selected Amazon payment method]], statusDetails=StatusDetails [state=OPEN, reasonCode=null, reasonDescription=null, lastUpdatedTimestamp=Tue Oct 15 20:43:27 JST 2019], constraints=[Constraint [constraintId=ChargeAmountNotSet, description=chargeAmount is not set.], Constraint [constraintId=CheckoutResultReturnUrlNotSet, description=checkoutResultReturnUrl is not set.], Constraint [constraintId=PaymentIntentNotSet, description=paymentIntent is not set.]], creationTimestamp=Tue Oct 15 20:43:13 JST 2019, expirationTimestamp=Wed Oct 16 20:43:13 JST 2019, chargePermissionId=null, chargeId=null, storeId=amzn1.application-oa2-client.8b5e45312b5248b69eeaStoreId, deliverySpecifications=DeliverySpecifications [specialRestrictions=[RestrictPOBoxes], addressRestrictions=AddressRestrictions [type=ALLOWED, restrictions={IN=Restriction [statesOrRegions=[AP], zipCodes=null], JP=Restriction [statesOrRegions=null, zipCodes=null], GB=Restriction [statesOrRegions=null, zipCodes=[72046, 72047]], US=Restriction [statesOrRegions=[WA], zipCodes=[95050, 93405]]}]], ReleaseEnvironment=Sandbox, supplementaryData=null]");

    }

    @Test
    public void testCheckoutSessionCreateObject3() {
        String json = "{\n" + "    \"webCheckoutDetails\": {\n"
                + "        \"checkoutReviewReturnUrl\": \"https://a.com/merchant-review-page\"\n" + "    },\n"
                + "    \"storeId\": \"amzn1.application-oa2-client.8b5e45312b5248b69eeaStoreId\",\n"
                // + " \"scopes\": [\"name\", \"email\", \"phoneNumber\",
                // \"billingAddress\"],\n"
                + "    \"deliverySpecifications\": {\n" + "        \"specialRestrictions\": [\"RestrictPOBoxes\"],\n"
                + "        \"addressRestrictions\": {\n" + "            \"type\": \"Allowed\",\n"
                + "            \"restrictions\": {\n" + "                \"US\": {\n"
                + "                    \"statesOrRegions\": [\"WA\"],\n"
                + "                    \"zipCodes\": [\"95050\", \"93405\"]\n" + "                },\n"
                + "                \"GB\": {\n" + "                    \"zipCodes\": [\"72046\", \"72047\"]\n"
                + "                },\n" + "                \"IN\": {\n"
                + "                    \"statesOrRegions\": [\"AP\"]\n" + "                },\n"
                + "                \"JP\": {}\n" + "            }\n" + "        }\n" + "    }\n" + "}  \n";

        JSONObject jsonObject = JSONObject.fromObject(json);
        CheckoutSession checkoutSession = CheckoutSession.createObject(jsonObject);
        // System.out.println(checkoutSession);
        assertEquals(checkoutSession.toString(),
                "CheckoutSession [checkoutSessionId=null, chargePermissionType=null, recurringMetadata=null, webCheckoutDetails=WebCheckoutDetails [checkoutReviewReturnUrl=https://a.com/merchant-review-page, checkoutResultReturnUrl=null, checkoutCancelUrl=null, amazonPayRedirectUrl=null, checkoutMode=null], productType=null, paymentDetails=null, merchantMetadata=null, platformId=null, providerMetadata=null, buyer=null, shippingAddress=null, billingAddress=null, paymentPreferences=null, statusDetails=null, constraints=null, creationTimestamp=null, expirationTimestamp=null, chargePermissionId=null, chargeId=null, storeId=amzn1.application-oa2-client.8b5e45312b5248b69eeaStoreId, deliverySpecifications=DeliverySpecifications [specialRestrictions=[RestrictPOBoxes], addressRestrictions=AddressRestrictions [type=ALLOWED, restrictions={IN=Restriction [statesOrRegions=[AP], zipCodes=null], JP=Restriction [statesOrRegions=null, zipCodes=null], GB=Restriction [statesOrRegions=null, zipCodes=[72046, 72047]], US=Restriction [statesOrRegions=[WA], zipCodes=[95050, 93405]]}]], ReleaseEnvironment=null, supplementaryData=null]");

    }

    @Test
    public void testCheckoutSessionCreateObject4() {
        String json = "{\n" + "    \"checkoutSessionId\": \"bd504926-f659-4ad7-a1a9-9a747aaf5275\",\n"
                + "    \"webCheckoutDetails\": {\n"
                + "        \"checkoutReviewReturnUrl\": \"https://a.com/merchant-review-page\",\n"
                + "        \"checkoutResultReturnUrl\": null,\n" + "        \"amazonPayRedirectUrl\": null\n"
                + "    },\n" + "    \"productType\": \"PayAndShip\",\n"
                + "    \"chargePermissionType\": \"Recurring\",   \n" + "    \"recurringMetadata\": {\n"
                + "        \"frequency\": { \n" + "            \"unit\": \"Month\", \n"
                + "            \"value\": \"1\" \n" + "        },\n" + "        \"amount\": { \n"
                + "            \"amount\": \"30\",\n" + "            \"currencyCode\": \"USD\"\n" + "        }\n"
                + "    }, \n" + "    \"paymentDetails\": {\n" + "        \"paymentIntent\": null,\n"
                + "        \"canHandlePendingAuthorization\":false,\n" + "        \"chargeAmount\": null,\n"
                + "        \"totalOrderAmount\": null,\n" + "        \"softDescriptor\": null,\n"
                + "        \"presentmentCurrency\": null,\n" + "        \"allowOvercharge\": null,\n"
                + "        \"extendExpiration\": null\n" + "    },\n" + "    \"merchantMetadata\": {\n"
                + "        \"merchantReferenceId\": null,\n" + "        \"merchantStoreName\": null,\n"
                + "        \"noteToBuyer\": null,\n" + "        \"customInformation\": null\n" + "    },\n"
                + "    \"supplementaryData\": null, // Amazon Pay system data\n" + "    \"buyer\": null,\n"
                + "    \"billingAddress\": null,\n" + "    \"paymentPreferences\": [\n" + "        null\n" + "    ],\n"
                + "    \"statusDetails\": {\n" + "        \"state\": \"Open\",\n" + "        \"reasonCode\": null,\n"
                + "        \"reasonDescription\": null,\n" + "        \"lastUpdatedTimestamp\": \"20191015T204327Z\"\n"
                + "    },\n" + "    \"shippingAddress\": null,  // Null for PayOnly product type\n"
                + "    \"platformId\": null,\n" + "    \"chargePermissionId\": null,\n" + "    \"chargeId\": null,\n"
                + "    \"constraints\": [\n" + "        {\n" + "           \"constraintId\": \"BuyerNotAssociated\",\n"
                + "            \"description\": \"There is no buyer associated with the Checkout Session. Return the checkout session id to the Amazon Pay Button to allow buyer to login.\"\n"
                + "        },\n" + "        {\n" + "           \"constraintId\": \"ChargeAmountNotSet\",\n"
                + "            \"description\": \"chargeAmount is not set.\"\n" + "        },\n" + "        {\n"
                + "            \"constraintId\": \"CheckoutResultReturnUrlNotSet\",\n"
                + "            \"description\": \"checkoutResultReturnUrl is not set.\"\n" + "        },\n"
                + "        {\n" + "            \"constraintId\": \"PaymentIntentNotSet\",\n"
                + "            \"description\": \"paymentIntent is not set.\"\n" + "        }\n" + "    ],\n"
                + "    \"creationTimestamp\": \"20191015T204313Z\",\n"
                + "    \"expirationTimestamp\": \"20191016T204313Z\",\n"
                + "    \"storeId\": \"amzn1.application-oa2-client.8b5e45312b5248b69eeaStoreId\",\n"
                + "    \"deliverySpecifications\": {\n" + "        \"specialRestrictions\": [\"RestrictPOBoxes\"],\n"
                + "        \"addressRestrictions\": {\n" + "            \"type\": \"Allowed\",\n"
                + "            \"restrictions\": {\n" + "                \"US\": {\n"
                + "                    \"statesOrRegions\": [\"WA\"],\n"
                + "                    \"zipCodes\": [\"95050\", \"93405\"]\n" + "                },\n"
                + "                \"GB\": {\n" + "                    \"zipCodes\": [\"72046\", \"72047\"]\n"
                + "                },\n" + "                \"IN\": {\n"
                + "                    \"statesOrRegions\": [\"AP\"]\n" + "                },\n"
                + "                \"JP\": {}\n" + "            }\n" + "        }\n" + "    },\n"
                + "    \"providerMetadata\": {\n" + "        \"providerReferenceId\": null\n" + "    },\n"
                + "    \"releaseEnvironment\": \"Sandbox\"\n" + "}";

        JSONObject jsonObject = JSONObject.fromObject(json);
        CheckoutSession checkoutSession = CheckoutSession.createObject(jsonObject);
        System.out.println(checkoutSession.toString());
        assertEquals(checkoutSession.toString(),
                "CheckoutSession [checkoutSessionId=bd504926-f659-4ad7-a1a9-9a747aaf5275, chargePermissionType=RECURRING, recurringMetadata=RecurringMetadata [frequency=Frequency [unit=MONTH, value=1], amount=Price [amount=30, currencyCode=USD]], webCheckoutDetails=WebCheckoutDetails [checkoutReviewReturnUrl=https://a.com/merchant-review-page, checkoutResultReturnUrl=null, checkoutCancelUrl=null, amazonPayRedirectUrl=null, checkoutMode=null], productType=PayAndShip, paymentDetails=PaymentDetails [paymentIntent=null, canHandlePendingAuthorization=false, chargeAmount=null, totalOrderAmount=null, presentmentCurrency=null, softDescriptor=null, allowOvercharge=null, extendExpiration=null], merchantMetadata=MerchantMetadata [merchantReferenceId=null, merchantStoreName=null, noteToBuyer=null, customInformation=null], platformId=null, providerMetadata=ProviderMetadata [providerReferenceId=null], buyer=null, shippingAddress=null, billingAddress=null, paymentPreferences=[null], statusDetails=StatusDetails [state=OPEN, reasonCode=null, reasonDescription=null, lastUpdatedTimestamp=Tue Oct 15 20:43:27 JST 2019], constraints=[Constraint [constraintId=BuyerNotAssociated, description=There is no buyer associated with the Checkout Session. Return the checkout session id to the Amazon Pay Button to allow buyer to login.], Constraint [constraintId=ChargeAmountNotSet, description=chargeAmount is not set.], Constraint [constraintId=CheckoutResultReturnUrlNotSet, description=checkoutResultReturnUrl is not set.], Constraint [constraintId=PaymentIntentNotSet, description=paymentIntent is not set.]], creationTimestamp=Tue Oct 15 20:43:13 JST 2019, expirationTimestamp=Wed Oct 16 20:43:13 JST 2019, chargePermissionId=null, chargeId=null, storeId=amzn1.application-oa2-client.8b5e45312b5248b69eeaStoreId, deliverySpecifications=DeliverySpecifications [specialRestrictions=[RestrictPOBoxes], addressRestrictions=AddressRestrictions [type=ALLOWED, restrictions={IN=Restriction [statesOrRegions=[AP], zipCodes=null], JP=Restriction [statesOrRegions=null, zipCodes=null], GB=Restriction [statesOrRegions=null, zipCodes=[72046, 72047]], US=Restriction [statesOrRegions=[WA], zipCodes=[95050, 93405]]}]], ReleaseEnvironment=Sandbox, supplementaryData=null]");

    }

}
