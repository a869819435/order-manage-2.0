package com.ruoyi.skill.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.skill.mapper.SkillInfoMapper;
import com.ruoyi.skill.domain.SkillInfo;
import com.ruoyi.skill.service.ISkillInfoService;

/**
 * 技能Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class SkillInfoServiceImpl implements ISkillInfoService 
{
    @Autowired
    private SkillInfoMapper skillInfoMapper;

    /**
     * 查询技能
     * 
     * @param id 技能ID
     * @return 技能
     */
    @Override
    public SkillInfo selectSkillInfoById(Long id)
    {
        return skillInfoMapper.selectSkillInfoById(id);
    }

    /**
     * 查询技能列表
     * 
     * @param skillInfo 技能
     * @return 技能
     */
    @Override
    public List<SkillInfo> selectSkillInfoList(SkillInfo skillInfo)
    {
        return skillInfoMapper.selectSkillInfoList(skillInfo);
    }

    /**
     * 新增技能
     * 
     * @param skillInfo 技能
     * @return 结果
     */
    @Override
    public int insertSkillInfo(SkillInfo skillInfo)
    {
        return skillInfoMapper.insertSkillInfo(skillInfo);
    }

    /**
     * 修改技能
     * 
     * @param skillInfo 技能
     * @return 结果
     */
    @Override
    public int updateSkillInfo(SkillInfo skillInfo)
    {
        return skillInfoMapper.updateSkillInfo(skillInfo);
    }

    /**
     * 批量删除技能
     * 
     * @param ids 需要删除的技能ID
     * @return 结果
     */
    @Override
    public int deleteSkillInfoByIds(Long[] ids)
    {
        return skillInfoMapper.deleteSkillInfoByIds(ids);
    }

    /**
     * 删除技能信息
     * 
     * @param id 技能ID
     * @return 结果
     */
    @Override
    public int deleteSkillInfoById(Long id)
    {
        return skillInfoMapper.deleteSkillInfoById(id);
    }
}
