package com.ywq.address.service;

import java.util.List;
import com.ywq.address.domain.AddressDistanceInfo;

/**
 * 地址间距信息Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface IAddressDistanceInfoService 
{
    /**
     * 查询地址间距信息
     * 
     * @param id 地址间距信息ID
     * @return 地址间距信息
     */
    public AddressDistanceInfo selectAddressDistanceInfoById(Long id);

    /**
     * 查询地址间距信息列表
     * 
     * @param addressDistanceInfo 地址间距信息
     * @return 地址间距信息集合
     */
    public List<AddressDistanceInfo> selectAddressDistanceInfoList(AddressDistanceInfo addressDistanceInfo);

    /**
     * 查询地址间距信息数量
     *
     * @param addressDistanceInfo 地址间距信息
     * @return 地址间距信息集合
     */
    int selectAddressDistanceInfoCount(AddressDistanceInfo addressDistanceInfo);

    /**
     * 新增地址间距信息
     * 
     * @param addressDistanceInfo 地址间距信息
     * @return 结果
     */
    public int insertAddressDistanceInfo(AddressDistanceInfo addressDistanceInfo);

    /**
     * 修改地址间距信息
     * 
     * @param addressDistanceInfo 地址间距信息
     * @return 结果
     */
    public int updateAddressDistanceInfo(AddressDistanceInfo addressDistanceInfo);

    /**
     * 批量删除地址间距信息
     * 
     * @param ids 需要删除的地址间距信息ID
     * @return 结果
     */
    public int deleteAddressDistanceInfoByIds(Long[] ids);

    /**
     * 删除地址间距信息信息
     * 
     * @param id 地址间距信息ID
     * @return 结果
     */
    public int deleteAddressDistanceInfoById(Long id);
}
