package com.ruoyi.skill.mapper;

import java.util.List;
import com.ruoyi.skill.domain.SkillInfo;

/**
 * 技能Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface SkillInfoMapper 
{
    /**
     * 查询技能
     * 
     * @param id 技能ID
     * @return 技能
     */
    public SkillInfo selectSkillInfoById(Long id);

    /**
     * 查询技能列表
     * 
     * @param skillInfo 技能
     * @return 技能集合
     */
    public List<SkillInfo> selectSkillInfoList(SkillInfo skillInfo);

    /**
     * 新增技能
     * 
     * @param skillInfo 技能
     * @return 结果
     */
    public int insertSkillInfo(SkillInfo skillInfo);

    /**
     * 修改技能
     * 
     * @param skillInfo 技能
     * @return 结果
     */
    public int updateSkillInfo(SkillInfo skillInfo);

    /**
     * 删除技能
     * 
     * @param id 技能ID
     * @return 结果
     */
    public int deleteSkillInfoById(Long id);

    /**
     * 批量删除技能
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkillInfoByIds(Long[] ids);
}
