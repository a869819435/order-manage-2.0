package com.ruoyi.team.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.team.mapper.TeamUserInfoMapper;
import com.ruoyi.team.domain.TeamUserInfo;
import com.ruoyi.team.service.ITeamUserInfoService;

/**
 * 团队成员信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class TeamUserInfoServiceImpl implements ITeamUserInfoService 
{
    @Autowired
    private TeamUserInfoMapper teamUserInfoMapper;

    /**
     * 查询团队成员信息
     * 
     * @param id 团队成员信息ID
     * @return 团队成员信息
     */
    @Override
    public TeamUserInfo selectTeamUserInfoById(Long id)
    {
        return teamUserInfoMapper.selectTeamUserInfoById(id);
    }

    /**
     * 查询团队成员信息列表
     * 
     * @param teamUserInfo 团队成员信息
     * @return 团队成员信息
     */
    @Override
    public List<TeamUserInfo> selectTeamUserInfoList(TeamUserInfo teamUserInfo)
    {
        return teamUserInfoMapper.selectTeamUserInfoList(teamUserInfo);
    }

    /**
     * 新增团队成员信息
     * 
     * @param teamUserInfo 团队成员信息
     * @return 结果
     */
    @Override
    public int insertTeamUserInfo(TeamUserInfo teamUserInfo)
    {
        return teamUserInfoMapper.insertTeamUserInfo(teamUserInfo);
    }

    /**
     * 修改团队成员信息
     * 
     * @param teamUserInfo 团队成员信息
     * @return 结果
     */
    @Override
    public int updateTeamUserInfo(TeamUserInfo teamUserInfo)
    {
        return teamUserInfoMapper.updateTeamUserInfo(teamUserInfo);
    }

    /**
     * 批量删除团队成员信息
     * 
     * @param ids 需要删除的团队成员信息ID
     * @return 结果
     */
    @Override
    public int deleteTeamUserInfoByIds(Long[] ids)
    {
        return teamUserInfoMapper.deleteTeamUserInfoByIds(ids);
    }

    /**
     * 删除团队成员信息信息
     * 
     * @param id 团队成员信息ID
     * @return 结果
     */
    @Override
    public int deleteTeamUserInfoById(Long id)
    {
        return teamUserInfoMapper.deleteTeamUserInfoById(id);
    }
}
