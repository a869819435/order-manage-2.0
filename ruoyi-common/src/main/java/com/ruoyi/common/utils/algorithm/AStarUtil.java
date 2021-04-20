package com.ruoyi.common.utils.algorithm;

import com.ruoyi.common.utils.algorithm.domain.AStarResult;
import com.ruoyi.common.utils.algorithm.domain.ArrayPicture;
import com.ruoyi.common.utils.algorithm.domain.DijkstraResult;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.*;

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
     * @param needTimes 求前needTimes的结果
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> DijkstraResult getResultByArray(List<T> msg, Class<T> tClass, String start,String end,Boolean isUndirectedResult,Integer needTimes) throws IllegalAccessException {
        DijkstraResult dijkstraResult = DijkstraUtil.getResultByArray(msg,tClass,end,isUndirectedResult);
        ArrayPicture arrayPicture = null;
        if (dijkstraResult.getPicture() instanceof ArrayPicture){
            arrayPicture = (ArrayPicture)dijkstraResult.getPicture();
        }else {
            return null;
        }
        // 起点编号
        Integer s = arrayPicture.getMap().get(start);
        if (s == null){
            return null;
        }
        // 终点编号,若-1表示无指定终点
        Integer e = arrayPicture.getMap().get(end);
        if (e == null){
            return null;
        }
        // 花费量
        BigDecimal[] dist = dijkstraResult.getDist();
        if (dist[e].equals(Double.MAX_VALUE)){
            return null;
        }
        int total = arrayPicture.getTotal();
        // 图
        BigDecimal[][] picture = arrayPicture.getPictureArray();
        // 路径
        Pair<Integer,Integer>[][] path = new Pair[total][total];
        // 访问次数标记
        int[] visited = new int[total];
        Arrays.fill(visited,0);
        // A*结果
        AStarResult aStarResult = new AStarResult(new ArrayList<>(needTimes),new ArrayList<>(needTimes),0,arrayPicture);
        // 优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        queue.add(new Node(new Pair<>(0,0),s,BigDecimal.ZERO,BigDecimal.ZERO));
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            visited[temp.vertex]++;
            Pair<Integer,Integer> temporary = path[temp.vertex][visited[temp.vertex]];
            path[temp.vertex][visited[temp.vertex]] = temp.prePath;
            // 判断环路
            if (isLoop(total,path[temp.vertex][visited[temp.vertex]],path)){
                path[temp.vertex][visited[temp.vertex]] = temporary;
                visited[temp.vertex]--;
                continue;
            }
            // 达到终点
            if (e.equals(temp.vertex)){
                // 临时结果存储器
                int[] ansPathTemp = new int[total + 1];
                int index = 0;
                ansPathTemp[index] = e;
                for (Pair<Integer,Integer> pre = temp.prePath ;pre.getKey() != 0 ;pre = path[pre.getKey()][pre.getValue()] ){
                    ansPathTemp[++index] = pre.getKey();
                }
                List<String> ansPath = new ArrayList<>(index);
                BigDecimal ansCost = BigDecimal.ZERO;
                for (int i = index - 1 ; i > 0 ; i--) {
                    ansCost = ansCost.add(picture[ansPathTemp[i]][ansPathTemp[i-1]]);
                    ansPath.add(arrayPicture.getOldName().get(ansPathTemp[i]));
                }
                ansPath.add(end);
                aStarResult.setSize(aStarResult.getSize() + 1);
                aStarResult.getPaths().add(ansPath);
                aStarResult.getDist().add(ansCost);
                // 如果都达到了需求的次数就不再走了
                if (aStarResult.getSize().equals(needTimes)){
                    queue.clear();
                    break;
                }
            }
            for (int i = 0; i < picture[temp.vertex].length ; i++) {
                queue.add(new Node(path[temp.vertex][visited[temp.vertex]],i,
                        temp.cost.add(picture[temp.vertex][i]),dist[i]));
            }
        }
        DijkstraResult result = new DijkstraResult();
        return result;
    }

    private static Boolean isLoop(int total,Pair<Integer,Integer> now,Pair<Integer,Integer>[][] path){
        // 访问标记
        int[] vis = new int[total];
        Arrays.fill(vis,0);
        // 上一个结点
        for (Pair<Integer,Integer> pre = path[now.getKey()][now.getValue()] ;pre.getKey() != 0 ;pre = path[pre.getKey()][pre.getValue()] ){
            vis[pre.getKey()]++;
            if (vis[pre.getKey()] > 1){
                return false;
            }
        }
        return true;
    }

}
