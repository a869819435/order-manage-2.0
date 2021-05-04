package com.ywq.common.utils.algorithm;

import com.ywq.common.core.domain.TreeEntity;
import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.ArrayList;
import java.util.List;

public class TreeBuildUtils {

    /**
     * 构建树
     * 要求T必须有继承Tree才可以使用
     * @param dataList
     * @param <T>
     * @return
     */
    public static <T> List<T> buildTree(List<T> dataList){
        List<TreeEntity> list = new ArrayList<>();
        for (T data : dataList) {
            if (data instanceof TreeEntity){
                list.add((TreeEntity) data);
            }else {
                return null;
            }
        }
        MultiValuedMap<Long,TreeEntity> map = new HashSetValuedHashMap<>();
        List<TreeEntity> answer = new ArrayList<>();
        for (TreeEntity treeEntity : list) {
            if (treeEntity.getParentId().equals(0L)){
                answer.add(treeEntity);
            }
            map.put(treeEntity.getParentId(),treeEntity);
        }
        fillTree(answer,map);
        dataList = new ArrayList<>(answer.size());
        for (TreeEntity treeEntity : answer) {
            dataList.add((T) treeEntity);
        }
        return dataList;
    }

    private static void fillTree(List<TreeEntity> list, MultiValuedMap<Long,TreeEntity> map){
        for (TreeEntity treeEntity : list) {
            List<TreeEntity> children = MultiMapUtils.getValuesAsList(map, treeEntity.getId());
            treeEntity.setChildren(children);
            fillTree(children,map);
        }
    }
}
