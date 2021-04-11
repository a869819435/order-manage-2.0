package com.ruoyi.address.mapper;

import java.util.List;
import com.ruoyi.address.domain.AddressDistanceInfo;

/**
 * 地址间距信息Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface AddressDistanceInfoMapper 
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
     * 删除地址间距信息
     * 
     * @param id 地址间距信息ID
     * @return 结果
     */
    public int deleteAddressDistanceInfoById(Long id);

    /**
     * 批量删除地址间距信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAddressDistanceInfoByIds(Long[] ids);
}
