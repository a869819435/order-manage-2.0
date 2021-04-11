package com.ruoyi.classify.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.classify.mapper.ClassifySkiilMapper;
import com.ruoyi.classify.domain.ClassifySkiil;
import com.ruoyi.classify.service.IClassifySkiilService;

/**
 * 技能分类Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class ClassifySkiilServiceImpl implements IClassifySkiilService 
{
    @Autowired
    private ClassifySkiilMapper classifySkiilMapper;

    /**
     * 查询技能分类
     * 
     * @param id 技能分类ID
     * @return 技能分类
     */
    @Override
    public ClassifySkiil selectClassifySkiilById(Long id)
    {
        return classifySkiilMapper.selectClassifySkiilById(id);
    }

    /**
     * 查询技能分类列表
     * 
     * @param classifySkiil 技能分类
     * @return 技能分类
     */
    @Override
    public List<ClassifySkiil> selectClassifySkiilList(ClassifySkiil classifySkiil)
    {
        return classifySkiilMapper.selectClassifySkiilList(classifySkiil);
    }

    /**
     * 新增技能分类
     * 
     * @param classifySkiil 技能分类
     * @return 结果
     */
    @Override
    public int insertClassifySkiil(ClassifySkiil classifySkiil)
    {
        return classifySkiilMapper.insertClassifySkiil(classifySkiil);
    }

    /**
     * 修改技能分类
     * 
     * @param classifySkiil 技能分类
     * @return 结果
     */
    @Override
    public int updateClassifySkiil(ClassifySkiil classifySkiil)
    {
        return classifySkiilMapper.updateClassifySkiil(classifySkiil);
    }

    /**
     * 批量删除技能分类
     * 
     * @param ids 需要删除的技能分类ID
     * @return 结果
     */
    @Override
    public int deleteClassifySkiilByIds(Long[] ids)
    {
        return classifySkiilMapper.deleteClassifySkiilByIds(ids);
    }

    /**
     * 删除技能分类信息
     * 
     * @param id 技能分类ID
     * @return 结果
     */
    @Override
    public int deleteClassifySkiilById(Long id)
    {
        return classifySkiilMapper.deleteClassifySkiilById(id);
    }
}
