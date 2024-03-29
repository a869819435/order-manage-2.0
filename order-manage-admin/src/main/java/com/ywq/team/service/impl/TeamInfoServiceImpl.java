package com.ywq.team.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ywq.team.mapper.TeamPostInfoMapper;
import com.ywq.team.mapper.TeamUserInfoMapper;
import org.springframework.stereotype.Service;
import com.ywq.team.mapper.TeamInfoMapper;
import com.ywq.team.domain.TeamInfo;
import com.ywq.team.service.ITeamInfoService;

import javax.annotation.Resource;

/**
 * 团队信息Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class TeamInfoServiceImpl implements ITeamInfoService 
{
    @Resource
    private TeamInfoMapper teamInfoMapper;

    @Resource
    private TeamPostInfoMapper teamPostInfoMapper;

    @Resource
    private TeamUserInfoMapper teamUserInfoMapper;

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
     * 查询团队信息列表
     *
     * @param teamInfo 团队信息
     * @return 团队信息
     */
    @Override
    public int selectTeamInfoCount(TeamInfo teamInfo)
    {
        return teamInfoMapper.selectTeamInfoCount(teamInfo);
    }

    /**
     * 由于改变重新计算全部值
     *
     * @param id
     * @return
     */
    @Override
    public int calculateOfChange(Long id) {
        // 计算出总人数、总评价、总收入、总能力值
        TeamInfo teamInfo = teamInfoMapper.calculateOfChange(id);
        teamInfo.setId(id);
        BigDecimal number = BigDecimal.valueOf(teamInfo.getNumber());
        teamInfo.setTeamEvaluation(teamInfo.getTeamEvaluation().divide(number));
        teamInfo.setAvgPower(teamInfo.getAvgPower().divide(number));
        teamInfo.setAvgIncome(teamInfo.getAllIncome().divide(number));
        return this.updateTeamInfo(teamInfo);
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
        TeamInfo query = new TeamInfo();
        query.setCode(teamInfo.getCode());
        query.setTeamAddress(teamInfo.getTeamAddress());
        int count = this.selectTeamInfoCount(query);
        if (count > 0){
            return -1;
        }
        teamInfo.setAllIncome(BigDecimal.ZERO);
        teamInfo.setAvgIncome(BigDecimal.ZERO);
        teamInfo.setAvgPower(BigDecimal.ZERO);
        teamInfo.setTeamEvaluation(BigDecimal.ZERO);
        teamInfo.setNumber(0);
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
        TeamInfo query = new TeamInfo();
        query.setId(teamInfo.getId());
        query.setCode(teamInfo.getCode());
        query.setTeamAddress(teamInfo.getTeamAddress());
        int count = this.selectTeamInfoCount(query);
        if (count > 0){
            return -1;
        }
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
