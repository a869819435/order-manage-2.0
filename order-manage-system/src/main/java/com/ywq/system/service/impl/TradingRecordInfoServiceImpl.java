package com.ywq.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.system.mapper.TradingRecordInfoMapper;
import com.ywq.system.domain.TradingRecordInfo;
import com.ywq.system.service.ITradingRecordInfoService;

/**
 * 交易记录Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-11
 */
@Service
public class TradingRecordInfoServiceImpl implements ITradingRecordInfoService 
{
    @Autowired
    private TradingRecordInfoMapper tradingRecordInfoMapper;

    /**
     * 查询交易记录
     * 
     * @param id 交易记录ID
     * @return 交易记录
     */
    @Override
    public TradingRecordInfo selectTradingRecordInfoById(Long id)
    {
        return tradingRecordInfoMapper.selectTradingRecordInfoById(id);
    }

    /**
     * 查询交易记录列表
     * 
     * @param tradingRecordInfo 交易记录
     * @return 交易记录
     */
    @Override
    public List<TradingRecordInfo> selectTradingRecordInfoList(TradingRecordInfo tradingRecordInfo)
    {
        return tradingRecordInfoMapper.selectTradingRecordInfoList(tradingRecordInfo);
    }

    /**
     * 新增交易记录
     * 
     * @param tradingRecordInfo 交易记录
     * @return 结果
     */
    @Override
    public int insertTradingRecordInfo(TradingRecordInfo tradingRecordInfo)
    {
        return tradingRecordInfoMapper.insertTradingRecordInfo(tradingRecordInfo);
    }

    /**
     * 修改交易记录
     * 
     * @param tradingRecordInfo 交易记录
     * @return 结果
     */
    @Override
    public int updateTradingRecordInfo(TradingRecordInfo tradingRecordInfo)
    {
        return tradingRecordInfoMapper.updateTradingRecordInfo(tradingRecordInfo);
    }

    /**
     * 批量删除交易记录
     * 
     * @param ids 需要删除的交易记录ID
     * @return 结果
     */
    @Override
    public int deleteTradingRecordInfoByIds(Long[] ids)
    {
        return tradingRecordInfoMapper.deleteTradingRecordInfoByIds(ids);
    }

    /**
     * 删除交易记录信息
     * 
     * @param id 交易记录ID
     * @return 结果
     */
    @Override
    public int deleteTradingRecordInfoById(Long id)
    {
        return tradingRecordInfoMapper.deleteTradingRecordInfoById(id);
    }
}
