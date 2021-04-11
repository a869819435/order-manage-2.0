package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TradingRecordInfo;

/**
 * 交易记录Mapper接口
 * 
 * @author ywq
 * @date 2021-04-11
 */
public interface TradingRecordInfoMapper 
{
    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    public TradingRecordInfo selectTradingRecordInfoById(Long id);

    /**
     * 查询交易记录列表
     * 
     * @param tradingRecordInfo 交易记录
     * @return 交易记录集合
     */
    public List<TradingRecordInfo> selectTradingRecordInfoList(TradingRecordInfo tradingRecordInfo);

    /**
     * 新增交易记录
     * 
     * @param tradingRecordInfo 交易记录
     * @return 结果
     */
    public int insertTradingRecordInfo(TradingRecordInfo tradingRecordInfo);

    /**
     * 修改交易记录
     * 
     * @param tradingRecordInfo 交易记录
     * @return 结果
     */
    public int updateTradingRecordInfo(TradingRecordInfo tradingRecordInfo);

    /**
     * 删除交易记录
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    public int deleteTradingRecordInfoById(Long id);

    /**
     * 批量删除交易记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTradingRecordInfoByIds(Long[] ids);
}
