package com.ywq.team.mapper;

import java.util.List;
import com.ywq.team.domain.TeamInfo;

/**
 * 团队信息Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface TeamInfoMapper 
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
     * 查询团队信息数量
     *
     * @param teamInfo 团队信息
     * @return 团队信息集合
     */
    int selectTeamInfoCount(TeamInfo teamInfo);

    /**
     * 由于改变重新计算全部值
     *
     * @param id
     * @return
     */
    TeamInfo calculateOfChange(Long id);

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
     * 删除团队信息
     * 
     * @param id 团队信息ID
     * @return 结果
     */
    public int deleteTeamInfoById(Long id);

    /**
     * 批量删除团队信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTeamInfoByIds(Long[] ids);
}
