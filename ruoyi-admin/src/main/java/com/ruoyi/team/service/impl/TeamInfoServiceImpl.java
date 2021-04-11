package com.ruoyi.team.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.team.mapper.TeamInfoMapper;
import com.ruoyi.team.domain.TeamInfo;
import com.ruoyi.team.service.ITeamInfoService;

/**
 * 团队信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class TeamInfoServiceImpl implements ITeamInfoService 
{
    @Autowired
    private TeamInfoMapper teamInfoMapper;

    /**
     * 查询团队信息
     * 
     * @param id 团队信息ID
     * @return 团队信息
     */
    @Override
    public TeamInfo selectTeamInfoById(Long id)
    {
        return teamInfoMapper.selectTeamInfoById(id);
    }

    /**
     * 查询团队信息列表
     * 
     * @param teamInfo 团队信息
     * @return 团队信息
     */
    @Override
    public List<TeamInfo> selectTeamInfoList(TeamInfo teamInfo)
    {
        return teamInfoMapper.selectTeamInfoList(teamInfo);
    }

    /**
     * 新增团队信息
     * 
     * @param teamInfo 团队信息
     * @return 结果
     */
    @Override
    public int insertTeamInfo(TeamInfo teamInfo)
    {
        return teamInfoMapper.insertTeamInfo(teamInfo);
    }

    /**
     * 修改团队信息
     * 
     * @param teamInfo 团队信息
     * @return 结果
     */
    @Override
    public int updateTeamInfo(TeamInfo teamInfo)
    {
        return teamInfoMapper.updateTeamInfo(teamInfo);
    }

    /**
     * 批量删除团队信息
     * 
     * @param ids 需要删除的团队信息ID
     * @return 结果
     */
    @Override
    public int deleteTeamInfoByIds(Long[] ids)
    {
        return teamInfoMapper.deleteTeamInfoByIds(ids);
    }

    /**
     * 删除团队信息信息
     * 
     * @param id 团队信息ID
     * @return 结果
     */
    @Override
    public int deleteTeamInfoById(Long id)
    {
        return teamInfoMapper.deleteTeamInfoById(id);
    }
}
