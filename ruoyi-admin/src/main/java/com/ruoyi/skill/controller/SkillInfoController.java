package com.ruoyi.skill.controller;

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
import com.ruoyi.skill.domain.SkillInfo;
import com.ruoyi.skill.service.ISkillInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 技能Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/skill/info")
public class SkillInfoController extends BaseController
{
    @Autowired
    private ISkillInfoService skillInfoService;

    /**
     * 查询技能列表
     */
    @PreAuthorize("@ss.hasPermi('skill:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(SkillInfo skillInfo)
    {
        startPage();
        List<SkillInfo> list = skillInfoService.selectSkillInfoList(skillInfo);
        return getDataTable(list);
    }

    /**
     * 导出技能列表
     */
    @PreAuthorize("@ss.hasPermi('skill:info:export')")
    @Log(title = "技能", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SkillInfo skillInfo)
    {
        List<SkillInfo> list = skillInfoService.selectSkillInfoList(skillInfo);
        ExcelUtil<SkillInfo> util = new ExcelUtil<SkillInfo>(SkillInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取技能详细信息
     */
    @PreAuthorize("@ss.hasPermi('skill:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(skillInfoService.selectSkillInfoById(id));
    }

    /**
     * 新增技能
     */
    @PreAuthorize("@ss.hasPermi('skill:info:add')")
    @Log(title = "技能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkillInfo skillInfo)
    {
        return toAjax(skillInfoService.insertSkillInfo(skillInfo));
    }

    /**
     * 修改技能
     */
    @PreAuthorize("@ss.hasPermi('skill:info:edit')")
    @Log(title = "技能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkillInfo skillInfo)
    {
        return toAjax(skillInfoService.updateSkillInfo(skillInfo));
    }

    /**
     * 删除技能
     */
    @PreAuthorize("@ss.hasPermi('skill:info:remove')")
    @Log(title = "技能", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(skillInfoService.deleteSkillInfoByIds(ids));
    }
}
