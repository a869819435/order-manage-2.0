package com.ywq.address.service.impl;

import java.util.List;

import com.ywq.address.domain.AddressDistanceInfo;
import com.ywq.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import com.ywq.address.mapper.AddressInfoMapper;
import com.ywq.address.domain.AddressInfo;
import com.ywq.address.service.IAddressInfoService;

import javax.annotation.Resource;

/**
 * 地址经纬度信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class AddressInfoServiceImpl implements IAddressInfoService 
{
    @Resource
    private AddressInfoMapper addressInfoMapper;

    @Resource
    private AddressDistanceInfoServiceImpl addressDistanceInfoService;

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
     * 查询地址经纬度信息数量
     *
     * @param addressInfo
     * @return
     */
    @Override
    public int selectAddressInfoCount(AddressInfo addressInfo)
    {
        return addressInfoMapper.selectAddressInfoCount(addressInfo);
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
        AddressInfo query = new AddressInfo();
        query.setName(addressInfo.getName());
        query.setClassId(addressInfo.getClassId());
        int addressInfos = this.selectAddressInfoCount(query);
        if (addressInfos > 0){
            return -1;
        }
        int answer = addressInfoMapper.insertAddressInfo(addressInfo);
        if (answer != 0){
            addressInfoMapper.saveAddressCode(addressInfo);
        }
        return answer;
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
        AddressInfo query = new AddressInfo();
        query.setId(addressInfo.getId());
        query.setName(addressInfo.getName());
        query.setClassId(addressInfo.getClassId());
        int addressInfos = this.selectAddressInfoCount(query);
        if (addressInfos > 0){
            return -1;
        }
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
        String idsStr = StringUtils.join(ids,",");
        AddressDistanceInfo addressDistanceInfo = new AddressDistanceInfo();
        addressDistanceInfo.setCodeXName(idsStr);
        addressDistanceInfo.setCodeYName(idsStr);
        int count = addressDistanceInfoService.selectAddressDistanceInfoCount(addressDistanceInfo);
        if (count > 0){
            return -1;
        }
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
        String idsStr = id.toString();
        AddressDistanceInfo addressDistanceInfo = new AddressDistanceInfo();
        addressDistanceInfo.setCodeXName(idsStr);
        addressDistanceInfo.setCodeYName(idsStr);
        int count = addressDistanceInfoService.selectAddressDistanceInfoCount(addressDistanceInfo);
        if (count > 0){
            return -1;
        }
        return addressInfoMapper.deleteAddressInfoById(id);
    }
}
