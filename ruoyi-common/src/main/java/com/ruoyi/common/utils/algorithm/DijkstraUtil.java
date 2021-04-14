package com.ruoyi.common.utils.algorithm;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DijkstraUtil {

    /** 存储图 */
    private List<List<BigDecimal>> picture = new ArrayList<>();

    /** 第几次遍历的顶点记录 */
    class Path{
        int before;
        int times;
        Path(int before,int times){
            this.before = before;
            this.times = times;
        }
    }

    public static void productPicture(List<String> msg)
    {

    }



}
