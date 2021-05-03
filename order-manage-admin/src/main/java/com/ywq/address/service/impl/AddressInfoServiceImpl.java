package com.ywq.address.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.address.mapper.AddressInfoMapper;
import com.ywq.address.domain.AddressInfo;
import com.ywq.address.service.IAddressInfoService;

/**
 * 地址经纬度信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class AddressInfoServiceImpl implements IAddressInfoService 
{
    @Autowired
    private AddressInfoMapper addressInfoMapper;

    /**
     * 查询地址经纬度信息
     * 
     * @param id 地址经纬度信息ID
     * @return 地址经纬度信息
     */
    @Override
    public AddressInfo selectAddressInfoById(Long id)
    {
        return addressInfoMapper.selectAddressInfoById(id);
    }

    /**
     * 查询地址经纬度信息列表
     * 
     * @param addressInfo 地址经纬度信息
     * @return 地址经纬度信息
     */
    @Override
    public List<AddressInfo> selectAddressInfoList(AddressInfo addressInfo)
    {
        return addressInfoMapper.selectAddressInfoList(addressInfo);
    }

    /**
     * 新增地址经纬度信息
     * 
     * @param addressInfo 地址经纬度信息
     * @return 结果
     */
    @Override
    public int insertAddressInfo(AddressInfo addressInfo)
    {
        return addressInfoMapper.insertAddressInfo(addressInfo);
    }

    /**
     * 修改地址经纬度信息
     * 
     * @param addressInfo 地址经纬度信息
     * @return 结果
     */
    @Override
    public int updateAddressInfo(AddressInfo addressInfo)
    {
        return addressInfoMapper.updateAddressInfo(addressInfo);
    }

    /**
     * 批量删除地址经纬度信息
     * 
     * @param ids 需要删除的地址经纬度信息ID
     * @return 结果
     */
    @Override
    public int deleteAddressInfoByIds(Long[] ids)
    {
        return addressInfoMapper.deleteAddressInfoByIds(ids);
    }

    /**
     * 删除地址经纬度信息信息
     * 
     * @param id 地址经纬度信息ID
     * @return 结果
     */
    @Override
    public int deleteAddressInfoById(Long id)
    {
        return addressInfoMapper.deleteAddressInfoById(id);
    }
}
