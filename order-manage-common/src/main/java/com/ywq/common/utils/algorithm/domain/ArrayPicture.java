package com.ywq.common.utils.algorithm.domain;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 算法图对象
 * @author ywq
 */
public class ArrayPicture {

    /** 数组存储图 */
    private BigDecimal[][] pictureArray;

    /** 离散化顶点编号 */
    private Map<String,Integer> map;

    /** 顶点编号原名 */
    private List<String> oldName;

    /** 顶点总个数 */
    private int total;

    /** 边信息 */
    static class Edge{
        int x;
        int y;
        BigDecimal cost;
        public Edge(int x, int y, BigDecimal cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    /**
     * 分析数据，是否可以构建图，初步处理数据，将数据转化成edge对象存储
     * 获取顶点个数，顶点编号名称映射
     * 要求：T所指类型前三个属性必须为 顶点1，顶点2，花费c[顶点1到顶点2花费c]
     *
     * @param msg 构建图的信息
     * @param tClass 传入的对象
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public <T> List<Edge> parsingPicture(List<T> msg, Class<T> tClass) throws IllegalAccessException {
        if (CollectionUtils.isEmpty(msg)){
            return null;
        }
        Field[] field = tClass.getDeclaredFields();
        if (field.length != 3){
            return null;
        }
        this.map = new HashMap<>();
        this.oldName = new ArrayList<>();
        List<Edge> list = new ArrayList<>(msg.size());
        for (T t : msg) {
            // 点x
            String from = String.valueOf(field[0].get(t));
            // 点y
            String to = String.valueOf(field[1].get(t));
            // 花费
            BigDecimal cost = new BigDecimal(String.valueOf(field[2].get(t)));
            // 顶点映射
            Integer x = map.get(from);
            if (!map.containsKey(x)){
                oldName.add(from);
                map.put(from,++total);
            }
            Integer y = map.get(to);
            if (!map.containsKey(y)){
                oldName.add(to);
                map.put(to,++total);
            }
            list.add(new Edge(x, y, cost));
        }
        return list;
    }

    /**
     * 获取图  数组版
     * @param msg 构建图的信息
     * @param tClass 传入的对象Class
     * @param isUndirectedResult 是否无向图
     * @param <T> 采用泛型
     * @return
     * @throws IllegalAccessException
     */
    public <T> Boolean setPictureArray(List<T> msg, Class<T> tClass,boolean isUndirectedResult) throws IllegalAccessException {
        List<Edge> list = this.parsingPicture(msg,tClass);
        if (CollectionUtils.isEmpty(list)){
            return false;
        }
        this.pictureArray = new BigDecimal[this.total][this.total];
        // 组装图
        list.forEach(edge -> {
            BigDecimal ans = BigDecimal.valueOf(Math.min(this.pictureArray[edge.x][edge.y].doubleValue(),edge.cost.doubleValue()));
            this.pictureArray[edge.x][edge.y] = ans;
            if (isUndirectedResult){
                this.pictureArray[edge.y][edge.x] = ans;
            }
        });
        return true;
    }

    public BigDecimal[][] getPictureArray() {
        return this.pictureArray;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public List<String> getOldName() {
        return oldName;
    }

    public int getTotal() {
        return total;
    }
}
