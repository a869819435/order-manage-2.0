package com.ruoyi.classify.service;

import java.util.List;
import com.ruoyi.classify.domain.ClassifyAddress;

/**
 * 地址分类Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface IClassifyAddressService 
{
    /**
     * 查询地址分类
     * 
     * @param id 地址分类ID
     * @return 地址分类
     */
    public ClassifyAddress selectClassifyAddressById(Long id);

    /**
     * 查询地址分类列表
     * 
     * @param classifyAddress 地址分类
     * @return 地址分类集合
     */
    public List<ClassifyAddress> selectClassifyAddressList(ClassifyAddress classifyAddress);

    /**
     * 新增地址分类
     * 
     * @param classifyAddress 地址分类
     * @return 结果
     */
    public int insertClassifyAddress(ClassifyAddress classifyAddress);

    /**
     * 修改地址分类
     * 
     * @param classifyAddress 地址分类
     * @return 结果
     */
    public int updateClassifyAddress(ClassifyAddress classifyAddress);

    /**
     * 批量删除地址分类
     * 
     * @param ids 需要删除的地址分类ID
     * @return 结果
     */
    public int deleteClassifyAddressByIds(Long[] ids);

    /**
     * 删除地址分类信息
     * 
     * @param id 地址分类ID
     * @return 结果
     */
    public int deleteClassifyAddressById(Long id);
}
