package com.ywq.skill.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.skill.mapper.SkillUserInfoMapper;
import com.ywq.skill.domain.SkillUserInfo;
import com.ywq.skill.service.ISkillUserInfoService;

import javax.annotation.Resource;

/**
 * 技能-技师信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class SkillUserInfoServiceImpl implements ISkillUserInfoService 
{
    @Resource
    private SkillUserInfoMapper skillUserInfoMapper;

    /**
     * 查询技能-技师信息
     * 
     * @param id 技能-技师信息ID
     * @return 技能-技师信息
     */
    @Override
    public SkillUserInfo selectSkillUserInfoById(Long id)
    {
        return skillUserInfoMapper.selectSkillUserInfoById(id);
    }

    /**
     * 查询技能-技师信息列表
     * 
     * @param skillUserInfo 技能-技师信息
     * @return 技能-技师信息
     */
    @Override
    public List<SkillUserInfo> selectSkillUserInfoList(SkillUserInfo skillUserInfo)
    {
        return skillUserInfoMapper.selectSkillUserInfoList(skillUserInfo);
    }

    @Override
    public int selectSkillUserInfoCount(SkillUserInfo skillUserInfo) {
        return skillUserInfoMapper.selectSkillUserInfoCount(skillUserInfo);
    }

    /**
     * 新增技能-技师信息
     * 
     * @param skillUserInfo 技能-技师信息
     * @return 结果
     */
    @Override
    public int insertSkillUserInfo(SkillUserInfo skillUserInfo)
    {
        return skillUserInfoMapper.insertSkillUserInfo(skillUserInfo);
    }

    /**
     * 修改技能-技师信息
     * 
     * @param skillUserInfo 技能-技师信息
     * @return 结果
     */
    @Override
    public int updateSkillUserInfo(SkillUserInfo skillUserInfo)
    {
        return skillUserInfoMapper.updateSkillUserInfo(skillUserInfo);
    }

    /**
     * 批量删除技能-技师信息
     * 
     * @param ids 需要删除的技能-技师信息ID
     * @return 结果
     */
    @Override
    public int deleteSkillUserInfoByIds(Long[] ids)
    {
        return skillUserInfoMapper.deleteSkillUserInfoByIds(ids);
    }

    /**
     * 删除技能-技师信息信息
     * 
     * @param id 技能-技师信息ID
     * @return 结果
     */
    @Override
    public int deleteSkillUserInfoById(Long id)
    {
        return skillUserInfoMapper.deleteSkillUserInfoById(id);
    }
}
