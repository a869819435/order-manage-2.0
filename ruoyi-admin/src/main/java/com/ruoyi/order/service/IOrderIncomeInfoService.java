package com.ruoyi.order.service;

import java.util.List;
import com.ruoyi.order.domain.OrderIncomeInfo;

/**
 * 工单评价Service接口
 * 
 * @author ywq
 * @date 2021-04-11
 */
public interface IOrderIncomeInfoService 
{
    /**
     * 查询工单评价
     * 
     * @param id 工单评价ID
     * @return 工单评价
     */
    public OrderIncomeInfo selectOrderIncomeInfoById(Long id);

    /**
     * 查询工单评价列表
     * 
     * @param orderIncomeInfo 工单评价
     * @return 工单评价集合
     */
    public List<OrderIncomeInfo> selectOrderIncomeInfoList(OrderIncomeInfo orderIncomeInfo);

    /**
     * 新增工单评价
     * 
     * @param orderIncomeInfo 工单评价
     * @return 结果
     */
    public int insertOrderIncomeInfo(OrderIncomeInfo orderIncomeInfo);

    /**
     * 修改工单评价
     * 
     * @param orderIncomeInfo 工单评价
     * @return 结果
     */
    public int updateOrderIncomeInfo(OrderIncomeInfo orderIncomeInfo);

    /**
     * 批量删除工单评价
     * 
     * @param ids 需要删除的工单评价ID
     * @return 结果
     */
    public int deleteOrderIncomeInfoByIds(Long[] ids);

    /**
     * 删除工单评价信息
     * 
     * @param id 工单评价ID
     * @return 结果
     */
    public int deleteOrderIncomeInfoById(Long id);
}
