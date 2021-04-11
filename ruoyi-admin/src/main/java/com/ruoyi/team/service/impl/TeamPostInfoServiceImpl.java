package com.ruoyi.team.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.team.mapper.TeamPostInfoMapper;
import com.ruoyi.team.domain.TeamPostInfo;
import com.ruoyi.team.service.ITeamPostInfoService;

/**
 * 团队职务信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class TeamPostInfoServiceImpl implements ITeamPostInfoService 
{
    @Autowired
    private TeamPostInfoMapper teamPostInfoMapper;

    /**
     * 查询团队职务信息
     * 
     * @param id 团队职务信息ID
     * @return 团队职务信息
     */
    @Override
    public TeamPostInfo selectTeamPostInfoById(Long id)
    {
        return teamPostInfoMapper.selectTeamPostInfoById(id);
    }

    /**
     * 查询团队职务信息列表
     * 
     * @param teamPostInfo 团队职务信息
     * @return 团队职务信息
     */
    @Override
    public List<TeamPostInfo> selectTeamPostInfoList(TeamPostInfo teamPostInfo)
    {
        return teamPostInfoMapper.selectTeamPostInfoList(teamPostInfo);
    }

    /**
     * 新增团队职务信息
     * 
     * @param teamPostInfo 团队职务信息
     * @return 结果
     */
    @Override
    public int insertTeamPostInfo(TeamPostInfo teamPostInfo)
    {
        return teamPostInfoMapper.insertTeamPostInfo(teamPostInfo);
    }

    /**
     * 修改团队职务信息
     * 
     * @param teamPostInfo 团队职务信息
     * @return 结果
     */
    @Override
    public int updateTeamPostInfo(TeamPostInfo teamPostInfo)
    {
        return teamPostInfoMapper.updateTeamPostInfo(teamPostInfo);
    }

    /**
     * 批量删除团队职务信息
     * 
     * @param ids 需要删除的团队职务信息ID
     * @return 结果
     */
    @Override
    public int deleteTeamPostInfoByIds(Long[] ids)
    {
        return teamPostInfoMapper.deleteTeamPostInfoByIds(ids);
    }

    /**
     * 删除团队职务信息信息
     * 
     * @param id 团队职务信息ID
     * @return 结果
     */
    @Override
    public int deleteTeamPostInfoById(Long id)
    {
        return teamPostInfoMapper.deleteTeamPostInfoById(id);
    }
}
