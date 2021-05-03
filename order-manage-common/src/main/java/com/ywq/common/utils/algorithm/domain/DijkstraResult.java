package com.ywq.common.utils.algorithm.domain;

import java.math.BigDecimal;

public class DijkstraResult {

    /** 花费量 */
    private BigDecimal[] dist;

    private String[] path;

    private Object picture;

    public BigDecimal[] getDist() {
        return dist;
    }

    public void setDist(BigDecimal[] dist) {
        this.dist = dist;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }
}
