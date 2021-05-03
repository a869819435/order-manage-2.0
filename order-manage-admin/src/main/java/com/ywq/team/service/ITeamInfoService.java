package com.ywq.team.service;

import java.util.List;
import com.ywq.team.domain.TeamInfo;

/**
 * 团队信息Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface ITeamInfoService 
{
    /**
     * 查询团队信息
     * 
     * @param id 团队信息ID
     * @return 团队信息
     */
    public TeamInfo selectTeamInfoById(Long id);

    /**
     * 查询团队信息列表
     * 
     * @param teamInfo 团队信息
     * @return 团队信息集合
     */
    public List<TeamInfo> selectTeamInfoList(TeamInfo teamInfo);

    /**
     * 新增团队信息
     * 
     * @param teamInfo 团队信息
     * @return 结果
     */
    public int insertTeamInfo(TeamInfo teamInfo);

    /**
     * 修改团队信息
     * 
     * @param teamInfo 团队信息
     * @return 结果
     */
    public int updateTeamInfo(TeamInfo teamInfo);

    /**
     * 批量删除团队信息
     * 
     * @param ids 需要删除的团队信息ID
     * @return 结果
     */
    public int deleteTeamInfoByIds(Long[] ids);

    /**
     * 删除团队信息信息
     * 
     * @param id 团队信息ID
     * @return 结果
     */
    public int deleteTeamInfoById(Long id);
}
