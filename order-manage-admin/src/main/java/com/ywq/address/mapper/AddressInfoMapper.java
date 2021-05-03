package com.ywq.address.mapper;

import java.util.List;
import com.ywq.address.domain.AddressInfo;

/**
 * 地址经纬度信息Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface AddressInfoMapper 
{
    /**
     * 查询地址经纬度信息
     * 
     * @param id 地址经纬度信息ID
     * @return 地址经纬度信息
     */
    public AddressInfo selectAddressInfoById(Long id);

    /**
     * 查询地址经纬度信息列表
     * 
     * @param addressInfo 地址经纬度信息
     * @return 地址经纬度信息集合
     */
    public List<AddressInfo> selectAddressInfoList(AddressInfo addressInfo);

    /**
     * 新增地址经纬度信息
     * 
     * @param addressInfo 地址经纬度信息
     * @return 结果
     */
    public int insertAddressInfo(AddressInfo addressInfo);

    /**
     * 修改地址经纬度信息
     * 
     * @param addressInfo 地址经纬度信息
     * @return 结果
     */
    public int updateAddressInfo(AddressInfo addressInfo);

    /**
     * 删除地址经纬度信息
     * 
     * @param id 地址经纬度信息ID
     * @return 结果
     */
    public int deleteAddressInfoById(Long id);

    /**
     * 批量删除地址经纬度信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAddressInfoByIds(Long[] ids);
}
