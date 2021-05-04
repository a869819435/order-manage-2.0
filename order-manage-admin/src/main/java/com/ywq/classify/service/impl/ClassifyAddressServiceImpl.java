package com.ywq.classify.service.impl;

import java.util.List;

import com.ywq.common.core.domain.TreeEntity;
import com.ywq.common.utils.algorithm.TreeBuildUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.classify.mapper.ClassifyAddressMapper;
import com.ywq.classify.domain.ClassifyAddress;
import com.ywq.classify.service.IClassifyAddressService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * 地址分类Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class ClassifyAddressServiceImpl implements IClassifyAddressService 
{
    @Resource
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
        List<ClassifyAddress> list = classifyAddressMapper.selectClassifyAddressList(classifyAddress);
        if (!CollectionUtils.isEmpty(list)){
            list = TreeBuildUtils.buildTree(list);
            list.forEach(address -> address.setParentName("(0)地址分类"));
        }
        return list;
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
        if (classifyAddress.getParentId() == null){
            classifyAddress.setParentId(0L);
        }
        ClassifyAddress parentInfo = classifyAddressMapper.selectClassifyAddressById(classifyAddress.getParentId());
        classifyAddress.setLevel(parentInfo.getLevel() + 1);
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
