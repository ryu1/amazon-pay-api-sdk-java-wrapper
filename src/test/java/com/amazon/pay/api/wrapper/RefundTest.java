package com.amazon.pay.api.wrapper;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefundTest {

    @Test
    public void testRefundCreateObject() {
        String json = "{\n" + "     \"refundId\": \"S01-5105180-3221187-R022311\",\n"
                + "     \"chargeId\": \"S01-5105180-3221187-C056351\",\n" + "     \"refundAmount\": {\n"
                + "         \"amount\": \"14.00\",\n" + "         \"currencyCode\": \"USD\"\n" + "     },\n"
                + "     \"softDescriptor\": \"Descriptor\",\n" + "     \"creationTimestamp\": \"20190714T155300Z\",\n"
                + "     \"statusDetails\": {\n" + "         \"state\": \"Refunded\",\n"
                + "         \"reasonCode\": null,\n" + "         \"reasonDescription\": null,\n"
                + "         \"lastUpdatedTimestamp\": \"20190714T155300Z\"\n" + "     },\n"
                + "     \"releaseEnvironment\": \"Sandbox\"\n" + "}\n";
        JSONObject jsonObject = JSONObject.fromObject(json);
        Refund refund = Refund.createObject(jsonObject);
        assertEquals(refund.toString(),
                "Refund [refundId=S01-5105180-3221187-R022311, chargeId=S01-5105180-3221187-C056351, refundAmount=RefundAmount [amount=14.00, currencyCode=USD], softDescriptor=Descriptor, creationTimestamp=Sun Jul 14 15:53:00 JST 2019, statusDetails=StatusDetails [state=REFUNDED, reasonCode=null, reasonDescription=null, lastUpdatedTimestamp=Sun Jul 14 15:53:00 JST 2019], releaseEnvironment=Sandbox]");

    }
}
