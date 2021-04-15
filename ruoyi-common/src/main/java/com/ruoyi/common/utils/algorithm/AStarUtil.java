package com.ruoyi.common.utils.algorithm;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.algorithm.domain.ArrayPicture;
import com.ruoyi.common.utils.algorithm.domain.DijkstraResult;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarUtil {

    static class Node{
        Pair<Integer, Integer> prePath;
        int vertex;
        BigDecimal cost;
        BigDecimal power;

        public Node(Pair<Integer, Integer> prePath, int vertex, BigDecimal cost, BigDecimal power) {
            this.prePath = prePath;
            this.vertex = vertex;
            this.cost = cost;
            this.power = power;
        }
    }

    /**
     * 获取数组存储的图运行结果
     * 参数要求：T所指类型前三个属性必须为 顶点1，顶点2，花费c[顶点1到顶点2花费c]
     *
     * @param msg
     * @param tClass
     * @param start
     * @param end
     * @param isUndirectedResult
     * @param times 求前times的结果
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> DijkstraResult getResultByArray(List<T> msg, Class<T> tClass, String start,String end,Boolean isUndirectedResult,Integer times) throws IllegalAccessException {
        DijkstraResult dijkstraResult = DijkstraUtil.getResultByArray(msg,tClass,end,isUndirectedResult);
        ArrayPicture arrayPicture = null;
        if (dijkstraResult.getPicture() instanceof ArrayPicture){
            arrayPicture = (ArrayPicture)dijkstraResult.getPicture();
        }else {
            return null;
        }
        int total = arrayPicture.getTotal();
        // 图
        BigDecimal[][] picture = arrayPicture.getPictureArray();
        // 花费量
        BigDecimal[] dist = dijkstraResult.getDist();
        // 路径
        Pair<Integer,Integer>[][] path = new Pair[total][total];
        // 访问次数标记
        int[] visited = new int[total];
        // 起点编号
        int s = arrayPicture.getMap().get(start);
        // 终点编号,若-1表示无指定终点
        int e = -1;
        if (!StringUtils.isEmpty(end)){
            e = arrayPicture.getMap().get(end);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        queue.add(new Node(new Pair<>(0,0),s,BigDecimal.ZERO));
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            visited[temp.vertex]++;
            Pair<Integer,Integer> temporary = path[temp.vertex][visited[temp.vertex]];
            path[temp.vertex][visited[temp.vertex]] = temp.prePath;
            // 判断环路

            // 如果都达到了需求的次数就不再走了
            if (isDemanded(e, temp.vertex, visited, times)){
                queue.clear();
                break;
            }
            for (int i = 0; i < picture[temp.vertex].length ; i++) {
                queue.add(new Node(path[temp.vertex][visited[temp.vertex]],i,
                        temp.cost.add(picture[temp.vertex][i])));
            }
        }
        DijkstraResult result = new DijkstraResult();
        return result;
    }

    private static Boolean isLoop(){

    }

    private static Boolean isDemanded(Integer e,int now, int[] visited,int times){
        if (e != null){
            return e.equals(now) && visited[e] >= times;
        }else {
            int sum = Arrays.stream(visited).sum();
            return sum >= times;
        }
    }
}
