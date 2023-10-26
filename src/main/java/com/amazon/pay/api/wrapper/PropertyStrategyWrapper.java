package com.amazon.pay.api.wrapper;

import net.sf.json.JSONException;
import net.sf.json.util.PropertySetStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyStrategyWrapper extends PropertySetStrategy {

    private final Log log = LogFactory.getLog(this.getClass());
    private final PropertySetStrategy original;

    public PropertyStrategyWrapper(PropertySetStrategy original) {
        this.original = original;
    }

    @Override
    public void setProperty(Object o, String string, Object o1) throws JSONException {
        try {
            original.setProperty(o, string, o1);
        } catch (Exception ex) {
            //ignore properties
            log.warn("Unknown property: " + string);
            log.debug("Unknown property: " + string, ex);
        }
    }
}