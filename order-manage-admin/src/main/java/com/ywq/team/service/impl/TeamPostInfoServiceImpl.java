package com.ywq.team.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ywq.team.domain.TeamInfo;
import com.ywq.team.mapper.TeamInfoMapper;
import org.springframework.stereotype.Service;
import com.ywq.team.mapper.TeamPostInfoMapper;
import com.ywq.team.domain.TeamPostInfo;
import com.ywq.team.service.ITeamPostInfoService;

import javax.annotation.Resource;

/**
 * 团队职务信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class TeamPostInfoServiceImpl implements ITeamPostInfoService 
{
    @Resource
    private TeamPostInfoMapper teamPostInfoMapper;

    @Resource
    private TeamInfoServiceImpl teamInfoService;

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
     * 查询团队职务信息数量
     *
     * @param teamPostInfo 团队职务信息
     * @return 团队职务信息
     */
    @Override
    public int selectTeamPostInfoCount(TeamPostInfo teamPostInfo)
    {
        return teamPostInfoMapper.selectTeamPostInfoCount(teamPostInfo);
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
        TeamPostInfo query = new TeamPostInfo();
        query.setCode(teamPostInfo.getCode());
        query.setPost(teamPostInfo.getPost());
        int count = teamPostInfoMapper.selectTeamPostInfoCount(query);
        if (count > 0){
            return -1;
        }
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
        TeamPostInfo query = new TeamPostInfo();
        query.setId(teamPostInfo.getId());
        query.setCode(teamPostInfo.getCode());
        query.setPost(teamPostInfo.getPost());
        int count = teamPostInfoMapper.selectTeamPostInfoCount(query);
        if (count > 0){
            return -1;
        }
        int answer = teamPostInfoMapper.updateTeamPostInfo(teamPostInfo);
        if (answer > 0){
            teamInfoService.calculateOfChange(Long.valueOf(teamPostInfo.getCode()));
        }
        return answer;
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
