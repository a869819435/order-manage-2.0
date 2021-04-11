package com.ruoyi.classify.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.classify.mapper.ClassifyAddressMapper;
import com.ruoyi.classify.domain.ClassifyAddress;
import com.ruoyi.classify.service.IClassifyAddressService;

/**
 * 地址分类Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class ClassifyAddressServiceImpl implements IClassifyAddressService 
{
    @Autowired
    private ClassifyAddressMapper classifyAddressMapper;

    /**
     * 查询地址分类
     * 
     * @param id 地址分类ID
     * @return 地址分类
     */
    @Override
    public ClassifyAddress selectClassifyAddressById(Long id)
    {
        return classifyAddressMapper.selectClassifyAddressById(id);
    }

    /**
     * 查询地址分类列表
     * 
     * @param classifyAddress 地址分类
     * @return 地址分类
     */
    @Override
    public List<ClassifyAddress> selectClassifyAddressList(ClassifyAddress classifyAddress)
    {
        return classifyAddressMapper.selectClassifyAddressList(classifyAddress);
    }

    /**
     * 新增地址分类
     * 
     * @param classifyAddress 地址分类
     * @return 结果
     */
    @Override
    public int insertClassifyAddress(ClassifyAddress classifyAddress)
    {
        return classifyAddressMapper.insertClassifyAddress(classifyAddress);
    }

    /**
     * 修改地址分类
     * 
     * @param classifyAddress 地址分类
     * @return 结果
     */
    @Override
    public int updateClassifyAddress(ClassifyAddress classifyAddress)
    {
        return classifyAddressMapper.updateClassifyAddress(classifyAddress);
    }

    /**
     * 批量删除地址分类
     * 
     * @param ids 需要删除的地址分类ID
     * @return 结果
     */
    @Override
    public int deleteClassifyAddressByIds(Long[] ids)
    {
        return classifyAddressMapper.deleteClassifyAddressByIds(ids);
    }

    /**
     * 删除地址分类信息
     * 
     * @param id 地址分类ID
     * @return 结果
     */
    @Override
    public int deleteClassifyAddressById(Long id)
    {
        return classifyAddressMapper.deleteClassifyAddressById(id);
    }
}
