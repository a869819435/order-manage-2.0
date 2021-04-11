package com.ruoyi.team.controller;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.team.domain.TeamPostInfo;
import com.ruoyi.team.service.ITeamPostInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 团队职务信息Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/team/post")
public class TeamPostInfoController extends BaseController
{
    @Autowired
    private ITeamPostInfoService teamPostInfoService;

    /**
     * 查询团队职务信息列表
     */
    @PreAuthorize("@ss.hasPermi('team:post:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeamPostInfo teamPostInfo)
    {
        startPage();
        List<TeamPostInfo> list = teamPostInfoService.selectTeamPostInfoList(teamPostInfo);
        return getDataTable(list);
    }

    /**
     * 导出团队职务信息列表
     */
    @PreAuthorize("@ss.hasPermi('team:post:export')")
    @Log(title = "团队职务信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TeamPostInfo teamPostInfo)
    {
        List<TeamPostInfo> list = teamPostInfoService.selectTeamPostInfoList(teamPostInfo);
        ExcelUtil<TeamPostInfo> util = new ExcelUtil<TeamPostInfo>(TeamPostInfo.class);
        return util.exportExcel(list, "post");
    }

    /**
     * 获取团队职务信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('team:post:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teamPostInfoService.selectTeamPostInfoById(id));
    }

    /**
     * 新增团队职务信息
     */
    @PreAuthorize("@ss.hasPermi('team:post:add')")
    @Log(title = "团队职务信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeamPostInfo teamPostInfo)
    {
        return toAjax(teamPostInfoService.insertTeamPostInfo(teamPostInfo));
    }

    /**
     * 修改团队职务信息
     */
    @PreAuthorize("@ss.hasPermi('team:post:edit')")
    @Log(title = "团队职务信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeamPostInfo teamPostInfo)
    {
        return toAjax(teamPostInfoService.updateTeamPostInfo(teamPostInfo));
    }

    /**
     * 删除团队职务信息
     */
    @PreAuthorize("@ss.hasPermi('team:post:remove')")
    @Log(title = "团队职务信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teamPostInfoService.deleteTeamPostInfoByIds(ids));
    }
}
