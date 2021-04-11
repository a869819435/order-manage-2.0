package com.ruoyi.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.OrderIncomeInfoMapper;
import com.ruoyi.order.domain.OrderIncomeInfo;
import com.ruoyi.order.service.IOrderIncomeInfoService;

/**
 * 工单评价Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-11
 */
@Service
public class OrderIncomeInfoServiceImpl implements IOrderIncomeInfoService 
{
    @Autowired
    private OrderIncomeInfoMapper orderIncomeInfoMapper;

    /**
     * 查询工单评价
     * 
     * @param id 工单评价ID
     * @return 工单评价
     */
    @Override
    public OrderIncomeInfo selectOrderIncomeInfoById(Long id)
    {
        return orderIncomeInfoMapper.selectOrderIncomeInfoById(id);
    }

    /**
     * 查询工单评价列表
     * 
     * @param orderIncomeInfo 工单评价
     * @return 工单评价
     */
    @Override
    public List<OrderIncomeInfo> selectOrderIncomeInfoList(OrderIncomeInfo orderIncomeInfo)
    {
        return orderIncomeInfoMapper.selectOrderIncomeInfoList(orderIncomeInfo);
    }

    /**
     * 新增工单评价
     * 
     * @param orderIncomeInfo 工单评价
     * @return 结果
     */
    @Override
    public int insertOrderIncomeInfo(OrderIncomeInfo orderIncomeInfo)
    {
        return orderIncomeInfoMapper.insertOrderIncomeInfo(orderIncomeInfo);
    }

    /**
     * 修改工单评价
     * 
     * @param orderIncomeInfo 工单评价
     * @return 结果
     */
    @Override
    public int updateOrderIncomeInfo(OrderIncomeInfo orderIncomeInfo)
    {
        return orderIncomeInfoMapper.updateOrderIncomeInfo(orderIncomeInfo);
    }

    /**
     * 批量删除工单评价
     * 
     * @param ids 需要删除的工单评价ID
     * @return 结果
     */
    @Override
    public int deleteOrderIncomeInfoByIds(Long[] ids)
    {
        return orderIncomeInfoMapper.deleteOrderIncomeInfoByIds(ids);
    }

    /**
     * 删除工单评价信息
     * 
     * @param id 工单评价ID
     * @return 结果
     */
    @Override
    public int deleteOrderIncomeInfoById(Long id)
    {
        return orderIncomeInfoMapper.deleteOrderIncomeInfoById(id);
    }
}
