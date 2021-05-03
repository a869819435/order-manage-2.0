package com.ywq.skill.service;

import java.util.List;
import com.ywq.skill.domain.SkillUserInfo;

/**
 * 技能-技师信息Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface ISkillUserInfoService 
{
    /**
     * 查询技能-技师信息
     * 
     * @param id 技能-技师信息ID
     * @return 技能-技师信息
     */
    public SkillUserInfo selectSkillUserInfoById(Long id);

    /**
     * 查询技能-技师信息列表
     * 
     * @param skillUserInfo 技能-技师信息
     * @return 技能-技师信息集合
     */
    public List<SkillUserInfo> selectSkillUserInfoList(SkillUserInfo skillUserInfo);

    /**
     * 新增技能-技师信息
     * 
     * @param skillUserInfo 技能-技师信息
     * @return 结果
     */
    public int insertSkillUserInfo(SkillUserInfo skillUserInfo);

    /**
     * 修改技能-技师信息
     * 
     * @param skillUserInfo 技能-技师信息
     * @return 结果
     */
    public int updateSkillUserInfo(SkillUserInfo skillUserInfo);

    /**
     * 批量删除技能-技师信息
     * 
     * @param ids 需要删除的技能-技师信息ID
     * @return 结果
     */
    public int deleteSkillUserInfoByIds(Long[] ids);

    /**
     * 删除技能-技师信息信息
     * 
     * @param id 技能-技师信息ID
     * @return 结果
     */
    public int deleteSkillUserInfoById(Long id);
}
