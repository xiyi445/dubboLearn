package org.apache.dubbo.demo;

import javax.persistence.Transient;
import java.io.Serializable;


public class RR implements Serializable {
    @Transient
    private Long ts;
    @Transient
    private String name;

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
