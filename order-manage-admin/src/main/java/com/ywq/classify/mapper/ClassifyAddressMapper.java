package com.ywq.classify.mapper;

import java.util.List;
import com.ywq.classify.domain.ClassifyAddress;

/**
 * 地址分类Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface ClassifyAddressMapper 
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
     * 删除地址分类
     * 
     * @param id 地址分类ID
     * @return 结果
     */
    public int deleteClassifyAddressById(Long id);

    /**
     * 批量删除地址分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClassifyAddressByIds(Long[] ids);
}
