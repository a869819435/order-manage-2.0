package com.ruoyi.classify.service;

import java.util.List;
import com.ruoyi.classify.domain.ClassifySkiil;

/**
 * 技能分类Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface IClassifySkiilService 
{
    /**
     * 查询技能分类
     * 
     * @param id 技能分类ID
     * @return 技能分类
     */
    public ClassifySkiil selectClassifySkiilById(Long id);

    /**
     * 查询技能分类列表
     * 
     * @param classifySkiil 技能分类
     * @return 技能分类集合
     */
    public List<ClassifySkiil> selectClassifySkiilList(ClassifySkiil classifySkiil);

    /**
     * 新增技能分类
     * 
     * @param classifySkiil 技能分类
     * @return 结果
     */
    public int insertClassifySkiil(ClassifySkiil classifySkiil);

    /**
     * 修改技能分类
     * 
     * @param classifySkiil 技能分类
     * @return 结果
     */
    public int updateClassifySkiil(ClassifySkiil classifySkiil);

    /**
     * 批量删除技能分类
     * 
     * @param ids 需要删除的技能分类ID
     * @return 结果
     */
    public int deleteClassifySkiilByIds(Long[] ids);

    /**
     * 删除技能分类信息
     * 
     * @param id 技能分类ID
     * @return 结果
     */
    public int deleteClassifySkiilById(Long id);
}
