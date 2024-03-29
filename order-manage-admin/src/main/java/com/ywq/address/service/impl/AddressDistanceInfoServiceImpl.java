package com.ywq.address.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ywq.address.mapper.AddressDistanceInfoMapper;
import com.ywq.address.domain.AddressDistanceInfo;
import com.ywq.address.service.IAddressDistanceInfoService;

import javax.annotation.Resource;

/**
 * 地址间距信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class AddressDistanceInfoServiceImpl implements IAddressDistanceInfoService 
{
    @Resource
    private AddressDistanceInfoMapper addressDistanceInfoMapper;

    /**
     * 查询地址间距信息
     * 
     * @param id 地址间距信息ID
     * @return 地址间距信息
     */
    @Override
    public AddressDistanceInfo selectAddressDistanceInfoById(Long id)
    {
        return addressDistanceInfoMapper.selectAddressDistanceInfoById(id);
    }

    /**
     * 查询地址间距信息列表
     * 
     * @param addressDistanceInfo 地址间距信息
     * @return 地址间距信息
     */
    @Override
    public List<AddressDistanceInfo> selectAddressDistanceInfoList(AddressDistanceInfo addressDistanceInfo)
    {
        return addressDistanceInfoMapper.selectAddressDistanceInfoList(addressDistanceInfo);
    }

    /**
     * 查询地址间距信息数量
     *
     * @param addressDistanceInfo 地址间距信息
     * @return 地址间距信息集合
     */
    @Override
    public int selectAddressDistanceInfoCount(AddressDistanceInfo addressDistanceInfo){
        return addressDistanceInfoMapper.selectAddressDistanceInfoCount(addressDistanceInfo);
    }

    /**
     * 新增地址间距信息
     * 
     * @param addressDistanceInfo 地址间距信息
     * @return 结果
     */
    @Override
    public int insertAddressDistanceInfo(AddressDistanceInfo addressDistanceInfo)
    {
        return addressDistanceInfoMapper.insertAddressDistanceInfo(addressDistanceInfo);
    }

    /**
     * 修改地址间距信息
     * 
     * @param addressDistanceInfo 地址间距信息
     * @return 结果
     */
    @Override
    public int updateAddressDistanceInfo(AddressDistanceInfo addressDistanceInfo)
    {
        return addressDistanceInfoMapper.updateAddressDistanceInfo(addressDistanceInfo);
    }

    /**
     * 批量删除地址间距信息
     * 
     * @param ids 需要删除的地址间距信息ID
     * @return 结果
     */
    @Override
    public int deleteAddressDistanceInfoByIds(Long[] ids)
    {
        return addressDistanceInfoMapper.deleteAddressDistanceInfoByIds(ids);
    }

    /**
     * 删除地址间距信息信息
     * 
     * @param id 地址间距信息ID
     * @return 结果
     */
    @Override
    public int deleteAddressDistanceInfoById(Long id)
    {
        return addressDistanceInfoMapper.deleteAddressDistanceInfoById(id);
    }
}
