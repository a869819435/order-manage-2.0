package com.ywq.team.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ywq.common.annotation.Log;
import com.ywq.common.core.controller.BaseController;
import com.ywq.common.core.domain.AjaxResult;
import com.ywq.common.enums.BusinessType;
import com.ywq.team.domain.TeamUserInfo;
import com.ywq.team.service.ITeamUserInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 团队成员信息Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/team/teamUser")
public class TeamUserInfoController extends BaseController
{
    @Autowired
    private ITeamUserInfoService teamUserInfoService;

    /**
     * 查询团队成员信息列表
     */
    @PreAuthorize("@ss.hasPermi('team:teamUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeamUserInfo teamUserInfo)
    {
        startPage();
        List<TeamUserInfo> list = teamUserInfoService.selectTeamUserInfoList(teamUserInfo);
        return getDataTable(list);
    }

    /**
     * 导出团队成员信息列表
     */
    @PreAuthorize("@ss.hasPermi('team:teamUser:export')")
    @Log(title = "团队成员信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeamUserInfo teamUserInfo)
    {
        List<TeamUserInfo> list = teamUserInfoService.selectTeamUserInfoList(teamUserInfo);
        ExcelUtil<TeamUserInfo> util = new ExcelUtil<TeamUserInfo>(TeamUserInfo.class);
        return util.exportExcel(list, "teamUser");
    }

    /**
     * 获取团队成员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('team:teamUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teamUserInfoService.selectTeamUserInfoById(id));
    }

    /**
     * 新增团队成员信息
     */
    @PreAuthorize("@ss.hasPermi('team:teamUser:add')")
    @Log(title = "团队成员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeamUserInfo teamUserInfo)
    {
        return toAjax(teamUserInfoService.insertTeamUserInfo(teamUserInfo));
    }

    /**
     * 修改团队成员信息
     */
    @PreAuthorize("@ss.hasPermi('team:teamUser:edit')")
    @Log(title = "团队成员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeamUserInfo teamUserInfo)
    {
        return toAjax(teamUserInfoService.updateTeamUserInfo(teamUserInfo));
    }

    /**
     * 删除团队成员信息
     */
    @PreAuthorize("@ss.hasPermi('team:teamUser:remove')")
    @Log(title = "团队成员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teamUserInfoService.deleteTeamUserInfoByIds(ids));
    }
}
