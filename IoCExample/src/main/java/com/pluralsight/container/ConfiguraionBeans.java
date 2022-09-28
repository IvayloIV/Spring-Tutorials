package com.pluralsight.container;

import java.util.List;

public class ConfiguraionBeans {

    private String from;
    private String to;
    private List<BeanParams> params;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<BeanParams> getParams() {
        return params;
    }

    public void setParams(List<BeanParams> params) {
        this.params = params;
    }
}
