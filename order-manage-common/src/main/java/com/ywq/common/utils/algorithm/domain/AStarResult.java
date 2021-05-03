package com.ywq.common.utils.algorithm.domain;

import java.math.BigDecimal;
import java.util.List;

public class AStarResult {

    /** 花费量 */
    private List<BigDecimal> dist;

    private List<List<String>> paths;

    private Integer size;

    private Object picture;

    public AStarResult(List<BigDecimal> dist, List<List<String>> paths, Integer size, Object picture) {
        this.dist = dist;
        this.paths = paths;
        this.size = size;
        this.picture = picture;
    }

    public List<BigDecimal> getDist() {
        return dist;
    }

    public void setDist(List<BigDecimal> dist) {
        this.dist = dist;
    }

    public List<List<String>> getPaths() {
        return paths;
    }

    public void setPaths(List<List<String>> paths) {
        this.paths = paths;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }
}
