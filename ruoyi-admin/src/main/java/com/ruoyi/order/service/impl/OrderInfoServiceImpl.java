package com.ruoyi.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.OrderInfoMapper;
import com.ruoyi.order.domain.OrderInfo;
import com.ruoyi.order.service.OrderInfoService;

/**
 * 工单信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService
{
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    /**
     * 查询工单信息
     * 
     * @param id 工单信息ID
     * @return 工单信息
     */
    @Override
    public OrderInfo selectOrderInfoById(Long id)
    {
        return orderInfoMapper.selectOrderInfoById(id);
    }

    /**
     * 查询工单信息列表
     * 
     * @param orderInfo 工单信息
     * @return 工单信息
     */
    @Override
    public List<OrderInfo> selectOrderInfoList(OrderInfo orderInfo)
    {
        return orderInfoMapper.selectOrderInfoList(orderInfo);
    }

    /**
     * 新增工单信息
     * 
     * @param orderInfo 工单信息
     * @return 结果
     */
    @Override
    public int insertOrderInfo(OrderInfo orderInfo)
    {
        return orderInfoMapper.insertOrderInfo(orderInfo);
    }

    /**
     * 修改工单信息
     * 
     * @param orderInfo 工单信息
     * @return 结果
     */
    @Override
    public int updateOrderInfo(OrderInfo orderInfo)
    {
        return orderInfoMapper.updateOrderInfo(orderInfo);
    }

    /**
     * 批量删除工单信息
     * 
     * @param ids 需要删除的工单信息ID
     * @return 结果
     */
    @Override
    public int deleteOrderInfoByIds(Long[] ids)
    {
        return orderInfoMapper.deleteOrderInfoByIds(ids);
    }

    /**
     * 删除工单信息信息
     * 
     * @param id 工单信息ID
     * @return 结果
     */
    @Override
    public int deleteOrderInfoById(Long id)
    {
        return orderInfoMapper.deleteOrderInfoById(id);
    }
}
