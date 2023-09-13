package com.amazon.pay.api.wrapper;

import net.sf.json.util.EnumMorpher;

public class CustomEnumMorpher extends EnumMorpher {

    public CustomEnumMorpher(@SuppressWarnings("rawtypes") Class enumClass) {
        super(enumClass);
    }

    @Override
    public Object morph(Object value) {
        if (morphsTo() == Refund.State.class) {
            return Refund.State.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.CheckoutMode.class) {
            return CheckoutSession.CheckoutMode.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.ChargePermissionType.class) {
            return CheckoutSession.ChargePermissionType.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.Unit.class) {
            return CheckoutSession.Unit.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.PaymentIntent.class) {
            return CheckoutSession.PaymentIntent.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.Type.class) {
            return CheckoutSession.Type.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.State.class) {
            return CheckoutSession.State.fromString((String) value);
        }
        if (morphsTo() == CheckoutSession.ReasonCode.class) {
            return CheckoutSession.ReasonCode.fromString((String) value);
        }
        if (morphsTo() == Charge.State.class) {
            return Charge.State.fromString((String) value);
        }
        if (morphsTo() == Charge.ReasonCode.class) {
            return Charge.ReasonCode.fromString((String) value);
        }

        return super.morph(value);
    }
}