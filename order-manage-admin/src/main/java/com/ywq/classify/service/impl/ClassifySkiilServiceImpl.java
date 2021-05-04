package com.ywq.classify.service.impl;

import java.util.List;

import com.ywq.common.utils.algorithm.TreeBuildUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.classify.mapper.ClassifySkiilMapper;
import com.ywq.classify.domain.ClassifySkiil;
import com.ywq.classify.service.IClassifySkiilService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * 技能分类Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class ClassifySkiilServiceImpl implements IClassifySkiilService 
{
    @Resource
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
        List<ClassifySkiil> list = classifySkiilMapper.selectClassifySkiilList(classifySkiil);
        if (!CollectionUtils.isEmpty(list)){
            list = TreeBuildUtils.buildTree(list);
            list.forEach(skill -> skill.setParentName("(0)技能分类"));
        }
        return list;
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
        if (classifySkiil.getParentId() == null){
            classifySkiil.setParentId(0L);
        }
        ClassifySkiil parentInfo = classifySkiilMapper.selectClassifySkiilById(classifySkiil.getParentId());
        classifySkiil.setLevel(parentInfo.getLevel() + 1);
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
