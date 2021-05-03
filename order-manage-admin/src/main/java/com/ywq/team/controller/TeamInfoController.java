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
import com.ywq.team.domain.TeamInfo;
import com.ywq.team.service.ITeamInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 团队信息Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/team/info")
public class TeamInfoController extends BaseController
{
    @Autowired
    private ITeamInfoService teamInfoService;

    /**
     * 查询团队信息列表
     */
    @PreAuthorize("@ss.hasPermi('team:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeamInfo teamInfo)
    {
        startPage();
        List<TeamInfo> list = teamInfoService.selectTeamInfoList(teamInfo);
        return getDataTable(list);
    }

    /**
     * 导出团队信息列表
     */
    @PreAuthorize("@ss.hasPermi('team:info:export')")
    @Log(title = "团队信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeamInfo teamInfo)
    {
        List<TeamInfo> list = teamInfoService.selectTeamInfoList(teamInfo);
        ExcelUtil<TeamInfo> util = new ExcelUtil<TeamInfo>(TeamInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取团队信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('team:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teamInfoService.selectTeamInfoById(id));
    }

    /**
     * 新增团队信息
     */
    @PreAuthorize("@ss.hasPermi('team:info:add')")
    @Log(title = "团队信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeamInfo teamInfo)
    {
        return toAjax(teamInfoService.insertTeamInfo(teamInfo));
    }

    /**
     * 修改团队信息
     */
    @PreAuthorize("@ss.hasPermi('team:info:edit')")
    @Log(title = "团队信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeamInfo teamInfo)
    {
        return toAjax(teamInfoService.updateTeamInfo(teamInfo));
    }

    /**
     * 删除团队信息
     */
    @PreAuthorize("@ss.hasPermi('team:info:remove')")
    @Log(title = "团队信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teamInfoService.deleteTeamInfoByIds(ids));
    }
}
