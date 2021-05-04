package com.ywq.classify.service.impl;

import java.util.List;

import com.ywq.common.utils.algorithm.TreeBuildUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.classify.mapper.ClassifyOrderMapper;
import com.ywq.classify.domain.ClassifyOrder;
import com.ywq.classify.service.IClassifyOrderService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * 工单分类Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class ClassifyOrderServiceImpl implements IClassifyOrderService 
{
    @Resource
    private ClassifyOrderMapper classifyOrderMapper;

    /**
     * 查询工单分类
     * 
     * @param id 工单分类ID
     * @return 工单分类
     */
    @Override
    public ClassifyOrder selectClassifyOrderById(Long id)
    {
        return classifyOrderMapper.selectClassifyOrderById(id);
    }

    /**
     * 查询工单分类列表
     * 
     * @param classifyOrder 工单分类
     * @return 工单分类
     */
    @Override
    public List<ClassifyOrder> selectClassifyOrderList(ClassifyOrder classifyOrder)
    {
        List<ClassifyOrder> list = classifyOrderMapper.selectClassifyOrderList(classifyOrder);
        if (!CollectionUtils.isEmpty(list)){
            list = TreeBuildUtils.buildTree(list);
            list.forEach(order -> order.setParentName("(0)工单分类"));
        }
        return list;
    }

    /**
     * 新增工单分类
     * 
     * @param classifyOrder 工单分类
     * @return 结果
     */
    @Override
    public int insertClassifyOrder(ClassifyOrder classifyOrder)
    {
        if (classifyOrder.getParentId() == null){
            classifyOrder.setParentId(0L);
        }
        ClassifyOrder parentInfo = classifyOrderMapper.selectClassifyOrderById(classifyOrder.getParentId());
        classifyOrder.setLevel(parentInfo.getLevel() + 1);
        return classifyOrderMapper.insertClassifyOrder(classifyOrder);
    }

    /**
     * 修改工单分类
     * 
     * @param classifyOrder 工单分类
     * @return 结果
     */
    @Override
    public int updateClassifyOrder(ClassifyOrder classifyOrder)
    {
        return classifyOrderMapper.updateClassifyOrder(classifyOrder);
    }

    /**
     * 批量删除工单分类
     * 
     * @param ids 需要删除的工单分类ID
     * @return 结果
     */
    @Override
    public int deleteClassifyOrderByIds(Long[] ids)
    {
        return classifyOrderMapper.deleteClassifyOrderByIds(ids);
    }

    /**
     * 删除工单分类信息
     * 
     * @param id 工单分类ID
     * @return 结果
     */
    @Override
    public int deleteClassifyOrderById(Long id)
    {
        return classifyOrderMapper.deleteClassifyOrderById(id);
    }
}
