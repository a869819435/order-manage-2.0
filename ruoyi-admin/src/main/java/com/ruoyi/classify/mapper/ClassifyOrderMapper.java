package com.ruoyi.classify.mapper;

import java.util.List;
import com.ruoyi.classify.domain.ClassifyOrder;

/**
 * 工单分类Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface ClassifyOrderMapper 
{
    /**
     * 查询工单分类
     * 
     * @param id 工单分类ID
     * @return 工单分类
     */
    public ClassifyOrder selectClassifyOrderById(Long id);

    /**
     * 查询工单分类列表
     * 
     * @param classifyOrder 工单分类
     * @return 工单分类集合
     */
    public List<ClassifyOrder> selectClassifyOrderList(ClassifyOrder classifyOrder);

    /**
     * 新增工单分类
     * 
     * @param classifyOrder 工单分类
     * @return 结果
     */
    public int insertClassifyOrder(ClassifyOrder classifyOrder);

    /**
     * 修改工单分类
     * 
     * @param classifyOrder 工单分类
     * @return 结果
     */
    public int updateClassifyOrder(ClassifyOrder classifyOrder);

    /**
     * 删除工单分类
     * 
     * @param id 工单分类ID
     * @return 结果
     */
    public int deleteClassifyOrderById(Long id);

    /**
     * 批量删除工单分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClassifyOrderByIds(Long[] ids);
}
