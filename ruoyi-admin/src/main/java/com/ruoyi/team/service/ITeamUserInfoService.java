package com.ruoyi.team.service;

import java.util.List;
import com.ruoyi.team.domain.TeamUserInfo;

/**
 * 团队成员信息Service接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface ITeamUserInfoService 
{
    /**
     * 查询团队成员信息
     * 
     * @param id 团队成员信息ID
     * @return 团队成员信息
     */
    public TeamUserInfo selectTeamUserInfoById(Long id);

    /**
     * 查询团队成员信息列表
     * 
     * @param teamUserInfo 团队成员信息
     * @return 团队成员信息集合
     */
    public List<TeamUserInfo> selectTeamUserInfoList(TeamUserInfo teamUserInfo);

    /**
     * 新增团队成员信息
     * 
     * @param teamUserInfo 团队成员信息
     * @return 结果
     */
    public int insertTeamUserInfo(TeamUserInfo teamUserInfo);

    /**
     * 修改团队成员信息
     * 
     * @param teamUserInfo 团队成员信息
     * @return 结果
     */
    public int updateTeamUserInfo(TeamUserInfo teamUserInfo);

    /**
     * 批量删除团队成员信息
     * 
     * @param ids 需要删除的团队成员信息ID
     * @return 结果
     */
    public int deleteTeamUserInfoByIds(Long[] ids);

    /**
     * 删除团队成员信息信息
     * 
     * @param id 团队成员信息ID
     * @return 结果
     */
    public int deleteTeamUserInfoById(Long id);
}
