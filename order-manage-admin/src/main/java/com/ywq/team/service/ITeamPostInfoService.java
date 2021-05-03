package com.ywq.team.service;

import java.util.List;
import com.ywq.team.domain.TeamPostInfo;

/**
 * 团队职务信息Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface ITeamPostInfoService 
{
    /**
     * 查询团队职务信息
     * 
     * @param id 团队职务信息ID
     * @return 团队职务信息
     */
    public TeamPostInfo selectTeamPostInfoById(Long id);

    /**
     * 查询团队职务信息列表
     * 
     * @param teamPostInfo 团队职务信息
     * @return 团队职务信息集合
     */
    public List<TeamPostInfo> selectTeamPostInfoList(TeamPostInfo teamPostInfo);

    /**
     * 新增团队职务信息
     * 
     * @param teamPostInfo 团队职务信息
     * @return 结果
     */
    public int insertTeamPostInfo(TeamPostInfo teamPostInfo);

    /**
     * 修改团队职务信息
     * 
     * @param teamPostInfo 团队职务信息
     * @return 结果
     */
    public int updateTeamPostInfo(TeamPostInfo teamPostInfo);

    /**
     * 批量删除团队职务信息
     * 
     * @param ids 需要删除的团队职务信息ID
     * @return 结果
     */
    public int deleteTeamPostInfoByIds(Long[] ids);

    /**
     * 删除团队职务信息信息
     * 
     * @param id 团队职务信息ID
     * @return 结果
     */
    public int deleteTeamPostInfoById(Long id);
}
