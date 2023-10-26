package com.amazon.pay.api.wrapper;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChargeTest {

    @Test
    void createObject_001() {
        String json = "{\n" +
                "    \"chargePermissionId\": \"P21-1111111-1111111\",\n" +
                "    \"chargeAmount\": {\n" +
                "        \"amount\": \"14.00\",\n" +
                "        \"currencyCode\": \"USD\"\n" +
                "    },\n" +
                "    \"captureNow\": true, // default is false\n" +
                "    \"softDescriptor\": \"Descriptor\",\n" +
                "    \"canHandlePendingAuthorization\": false //default is false\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Charge charge = Charge.createObject(jsonObject);
//        System.out.println(charge.toString());
        assertEquals(charge.toString(), "Charge{chargeId='null', chargePermissionId='P21-1111111-1111111', chargeAmount=Price [amount=14.00, currencyCode=USD], captureAmount=null, refundedAmount=null, softDescriptor='Descriptor', captureNow=true, canHandlePendingAuthorization=false, providerMetadata=null, creationTimestamp=null, expirationTimestamp=null, merchantMetadata=null, platformId='null', statusDetails=null, convertedAmount=null, conversionRate=null, releaseEnvironment='null', chargeInitiator=null, channel='null'}");
    }

    @Test
    void createObject_002() {
        String json = "{\n" +
                "     \"chargeId\": \"P21-1111111-1111111-C111111\",\n" +
                "     \"chargePermissionId\": \"P21-1111111-1111111\",\n" +
                "     \"chargeAmount\": {\n" +
                "         \"amount\": \"14.00\",\n" +
                "         \"currencyCode\": \"USD\"\n" +
                "     },\n" +
                "     \"captureAmount\": {\n" +
                "         \"amount\": \"14.00\",\n" +
                "         \"currencyCode\": \"USD\"\n" +
                "     },\n" +
                "     \"refundedAmount\": {\n" +
                "         \"amount\": \"0.00\",\n" +
                "         \"currencyCode\": \"USD\"\n" +
                "     },\n" +
                "     \"convertedAmount\": \"14.00\",\n" +
                "     \"conversionRate\": \"1.00\",\n" +
                "     \"softDescriptor\": \"Descriptor\",\n" +
                "     \"merchantMetadata\": null,\n" +
                "     \"providerMetadata\": {\n" +
                "         \"providerReferenceId\": null\n" +
                "     },\n" +
                "     \"statusDetails\":{\n" +
                "         \"state\": \"Captured\",\n" +
                "         \"reasonCode\": null,\n" +
                "         \"reasonDescription\": null,\n" +
                "         \"lastUpdatedTimestamp\": \"20190714T155300Z\"\n" +
                "     },\n" +
                "     \"creationTimestamp\": \"20190714T155300Z\",\n" +
                "     \"expirationTimestamp\": \"20190715T155300Z\",\n" +
                "     \"releaseEnvironment\": \"Sandbox\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Charge charge = Charge.createObject(jsonObject);
        System.out.println(charge.toString());
        assertEquals(charge.toString(), "Charge{chargeId='P21-1111111-1111111-C111111', chargePermissionId='P21-1111111-1111111', chargeAmount=Price [amount=14.00, currencyCode=USD], captureAmount=Price [amount=14.00, currencyCode=USD], refundedAmount=Price [amount=0.00, currencyCode=USD], softDescriptor='Descriptor', captureNow=null, canHandlePendingAuthorization=null, providerMetadata=ProviderMetadata [providerReferenceId=null], creationTimestamp=Sun Jul 14 15:53:00 JST 2019, expirationTimestamp=Mon Jul 15 15:53:00 JST 2019, merchantMetadata=null, platformId='null', statusDetails=StatusDetails [state=Captured, reasonCode=null, reasonDescription=null, lastUpdatedTimestamp=Sun Jul 14 15:53:00 JST 2019], convertedAmount=Price [amount=null, currencyCode=null], conversionRate=1.0, releaseEnvironment='Sandbox', chargeInitiator=null, channel='null'}");
    }

    @Test
    void createObject_003() {
        String json = "{\n" +
                "     \"chargeId\": \"P21-1111111-1111111-C111111\",\n" +
                "     \"chargePermissionId\": \"P21-1111111-1111111\",\n" +
                "     \"chargeInitiator\":\"CITU\",\n" +
                "     \"channel\":\"Web\",\n" +
                "     \"chargeAmount\": {\n" +
                "         \"amount\": \"14.00\",\n" +
                "         \"currencyCode\": \"USD\"\n" +
                "     },\n" +
                "     \"captureAmount\": {\n" +
                "         \"amount\": \"14.00\",\n" +
                "         \"currencyCode\": \"USD\"\n" +
                "     },\n" +
                "     \"refundedAmount\": {\n" +
                "         \"amount\": \"0.00\",\n" +
                "         \"currencyCode\": \"USD\"\n" +
                "     },\n" +
                "     \"convertedAmount\": \"14.00\",\n" +
                "     \"conversionRate\": \"1.00\",\n" +
                "     \"softDescriptor\": \"Descriptor\",\n" +
                "     \"merchantMetadata\": null,\n" +
                "     \"providerMetadata\": {\n" +
                "         \"providerReferenceId\": null\n" +
                "     },\n" +
                "     \"statusDetails\":{\n" +
                "         \"state\": \"Captured\",\n" +
                "         \"reasonCode\": null,\n" +
                "         \"reasonDescription\": null,\n" +
                "         \"lastUpdatedTimestamp\": \"20190714T155300Z\"\n" +
                "     },\n" +
                "     \"creationTimestamp\": \"20190714T155300Z\",\n" +
                "     \"expirationTimestamp\": \"20190715T155300Z\",\n" +
                "     \"releaseEnvironment\": \"Sandbox\"\n" +
                "}\n";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Charge charge = Charge.createObject(jsonObject);
        System.out.println(charge.toString());
        assertEquals(charge.toString(), "Charge{chargeId='P21-1111111-1111111-C111111', chargePermissionId='P21-1111111-1111111', chargeAmount=Price [amount=14.00, currencyCode=USD], captureAmount=Price [amount=14.00, currencyCode=USD], refundedAmount=Price [amount=0.00, currencyCode=USD], softDescriptor='Descriptor', captureNow=null, canHandlePendingAuthorization=null, providerMetadata=ProviderMetadata [providerReferenceId=null], creationTimestamp=Sun Jul 14 15:53:00 JST 2019, expirationTimestamp=Mon Jul 15 15:53:00 JST 2019, merchantMetadata=null, platformId='null', statusDetails=StatusDetails [state=Captured, reasonCode=null, reasonDescription=null, lastUpdatedTimestamp=Sun Jul 14 15:53:00 JST 2019], convertedAmount=Price [amount=null, currencyCode=null], conversionRate=1.0, releaseEnvironment='Sandbox', chargeInitiator=CITU, channel='WEB'}");
    }

    @Test
    void createObject_004() {
        String json = "{\n" +
                "   \"chargeId\":\"S03-5890444-1926095-C064126\",\n" +
                "   \"chargeAmount\":{\n" +
                "      \"amount\":\"500\",\n" +
                "      \"currencyCode\":\"JPY\"\n" +
                "   },\n" +
                "   \"chargePermissionId\":\"C03-1442027-5744374\",\n" +
                "   \"captureAmount\":null,\n" +
                "   \"refundedAmount\":null,\n" +
                "   \"softDescriptor\":null,\n" +
                "   \"providerMetadata\":{\n" +
                "      \"providerReferenceId\":null\n" +
                "   },\n" +
                "   \"convertedAmount\":null,\n" +
                "   \"conversionRate\":null,\n" +
                "   \"channel\":null,\n" +
                "   \"chargeInitiator\":\"CITU\",\n" +
                "   \"statusDetails\":{\n" +
                "      \"state\":\"Authorized\",\n" +
                "      \"reasonCode\":null,\n" +
                "      \"reasonDescription\":null,\n" +
                "      \"lastUpdatedTimestamp\":\"20231026T062827Z\"\n" +
                "   },\n" +
                "   \"creationTimestamp\":\"20231026T062827Z\",\n" +
                "   \"expirationTimestamp\":\"20231125T062827Z\",\n" +
                "   \"releaseEnvironment\":\"Sandbox\",\n" +
                "   \"merchantMetadata\":{\n" +
                "      \"merchantReferenceId\":null,\n" +
                "      \"merchantStoreName\":null,\n" +
                "      \"noteToBuyer\":null,\n" +
                "      \"customInformation\":null\n" +
                "   },\n" +
                "   \"platformId\":\"ADZQ303FTXBLZ\",\n" +
                "   \"webCheckoutDetails\":null\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Charge charge = Charge.createObject(jsonObject);
        System.out.println(charge.toString());
        assertEquals(charge.toString(), "Charge{chargeId='S03-5890444-1926095-C064126', chargePermissionId='C03-1442027-5744374', chargeAmount=Price [amount=500, currencyCode=JPY], captureAmount=null, refundedAmount=null, softDescriptor='null', captureNow=null, canHandlePendingAuthorization=null, providerMetadata=ProviderMetadata [providerReferenceId=null], creationTimestamp=Thu Oct 26 06:28:27 JST 2023, expirationTimestamp=Sat Nov 25 06:28:27 JST 2023, merchantMetadata=MerchantMetadata [merchantReferenceId=null, merchantStoreName=null, noteToBuyer=null, customInformation=null], platformId='ADZQ303FTXBLZ', statusDetails=StatusDetails [state=Authorized, reasonCode=null, reasonDescription=null, lastUpdatedTimestamp=Thu Oct 26 06:28:27 JST 2023], convertedAmount=null, conversionRate=null, releaseEnvironment='Sandbox', chargeInitiator=CITU, channel='null'}");
    }

}