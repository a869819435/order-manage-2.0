package com.ruoyi.common.utils.algorithm;

import com.ruoyi.common.utils.algorithm.domain.ArrayPicture;
import com.ruoyi.common.utils.algorithm.domain.DijkstraResult;

import java.math.BigDecimal;
import java.util.*;

public class DijkstraUtil {

    static class Node{
        int vertex;
        BigDecimal cost;
        public Node(int view, BigDecimal cost) {
            this.vertex = view;
            this.cost = cost;
        }
    }

    /**
     * 获取数组存储的图运行结果
     * 参数要求：T所指类型前三个属性必须为 顶点1，顶点2，花费c[顶点1到顶点2花费c]
     *
     * @param msg
     * @param tClass
     * @param oldStart
     * @param isUndirectedResult
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> DijkstraResult getResultByArray(List<T> msg, Class<T> tClass,String oldStart,Boolean isUndirectedResult) throws IllegalAccessException {
        ArrayPicture arrayPicture = new ArrayPicture();
        arrayPicture.setPictureArray(msg,tClass,isUndirectedResult);
        Integer start = arrayPicture.getMap().get(oldStart);
        if (start == null){
            return null;
        }
        BigDecimal[][] picture = arrayPicture.getPictureArray();
        int total = arrayPicture.getTotal();
        int[] visited = new int[total];
        Arrays.fill(visited,0);
        String[] path = new String[total];
        // 花费量
        BigDecimal[] dist = new BigDecimal[total];
        Arrays.fill(dist,new BigDecimal(Double.MAX_VALUE));
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        queue.add(new Node(start, BigDecimal.ZERO));
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if (visited[temp.vertex] >= 1){
                continue;
            }
            visited[temp.vertex]++;
            for (int i = 0; i < picture[temp.vertex].length ; i++) {
                if (visited[i] >= 1){
                    continue;
                }
                if (dist[i].compareTo(dist[temp.vertex].add(picture[temp.vertex][i])) < 0){
                    dist[i] = dist[temp.vertex].add(picture[temp.vertex][i]);
                    queue.add(new Node(i,dist[i]));
                    path[i] = arrayPicture.getOldName().get(temp.vertex);
                }
            }
        }
        DijkstraResult result = new DijkstraResult();
        result.setDist(dist);
        result.setPath(path);
        result.setPicture(arrayPicture);
        return result;
    }

}
