package com.ywq.skill.controller;

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
import com.ywq.skill.domain.SkillUserInfo;
import com.ywq.skill.service.ISkillUserInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 技能-技师信息Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/skill/skiiUser")
public class SkillUserInfoController extends BaseController
{
    @Autowired
    private ISkillUserInfoService skillUserInfoService;

    /**
     * 查询技能-技师信息列表
     */
    @PreAuthorize("@ss.hasPermi('skill:skiiUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(SkillUserInfo skillUserInfo)
    {
        startPage();
        List<SkillUserInfo> list = skillUserInfoService.selectSkillUserInfoList(skillUserInfo);
        return getDataTable(list);
    }

    /**
     * 导出技能-技师信息列表
     */
    @PreAuthorize("@ss.hasPermi('skill:skiiUser:export')")
    @Log(title = "技能-技师信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SkillUserInfo skillUserInfo)
    {
        List<SkillUserInfo> list = skillUserInfoService.selectSkillUserInfoList(skillUserInfo);
        ExcelUtil<SkillUserInfo> util = new ExcelUtil<SkillUserInfo>(SkillUserInfo.class);
        return util.exportExcel(list, "skiiUser");
    }

    /**
     * 获取技能-技师信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('skill:skiiUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(skillUserInfoService.selectSkillUserInfoById(id));
    }

    /**
     * 新增技能-技师信息
     */
    @PreAuthorize("@ss.hasPermi('skill:skiiUser:add')")
    @Log(title = "技能-技师信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkillUserInfo skillUserInfo)
    {
        return toAjax(skillUserInfoService.insertSkillUserInfo(skillUserInfo));
    }

    /**
     * 修改技能-技师信息
     */
    @PreAuthorize("@ss.hasPermi('skill:skiiUser:edit')")
    @Log(title = "技能-技师信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkillUserInfo skillUserInfo)
    {
        return toAjax(skillUserInfoService.updateSkillUserInfo(skillUserInfo));
    }

    /**
     * 删除技能-技师信息
     */
    @PreAuthorize("@ss.hasPermi('skill:skiiUser:remove')")
    @Log(title = "技能-技师信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(skillUserInfoService.deleteSkillUserInfoByIds(ids));
    }
}
