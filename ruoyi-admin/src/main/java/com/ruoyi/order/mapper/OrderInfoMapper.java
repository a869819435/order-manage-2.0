package com.ruoyi.order.mapper;

import java.util.List;
import com.ruoyi.order.domain.OrderInfo;

/**
 * 工单信息Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface OrderInfoMapper 
{
    /**
     * 查询工单信息
     * 
     * @param id 工单信息ID
     * @return 工单信息
     */
    public OrderInfo selectOrderInfoById(Long id);

    /**
     * 查询工单信息列表
     * 
     * @param orderInfo 工单信息
     * @return 工单信息集合
     */
    public List<OrderInfo> selectOrderInfoList(OrderInfo orderInfo);

    /**
     * 新增工单信息
     * 
     * @param orderInfo 工单信息
     * @return 结果
     */
    public int insertOrderInfo(OrderInfo orderInfo);

    /**
     * 修改工单信息
     * 
     * @param orderInfo 工单信息
     * @return 结果
     */
    public int updateOrderInfo(OrderInfo orderInfo);

    /**
     * 删除工单信息
     * 
     * @param id 工单信息ID
     * @return 结果
     */
    public int deleteOrderInfoById(Long id);

    /**
     * 批量删除工单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderInfoByIds(Long[] ids);
}
