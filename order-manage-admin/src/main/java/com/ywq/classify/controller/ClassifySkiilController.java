package com.ywq.classify.controller;

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
import com.ywq.classify.domain.ClassifySkiil;
import com.ywq.classify.service.IClassifySkiilService;
import com.ywq.common.utils.poi.ExcelUtil;

/**
 * 技能分类Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/classify/skiil")
public class ClassifySkiilController extends BaseController
{
    @Autowired
    private IClassifySkiilService classifySkiilService;

    /**
     * 查询技能分类列表
     */
    @PreAuthorize("@ss.hasPermi('classify:skiil:list')")
    @GetMapping("/list")
    public AjaxResult list(ClassifySkiil classifySkiil)
    {
        List<ClassifySkiil> list = classifySkiilService.selectClassifySkiilList(classifySkiil);
        return AjaxResult.success(list);
    }

    /**
     * 导出技能分类列表
     */
    @PreAuthorize("@ss.hasPermi('classify:skiil:export')")
    @Log(title = "技能分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ClassifySkiil classifySkiil)
    {
        List<ClassifySkiil> list = classifySkiilService.selectClassifySkiilList(classifySkiil);
        ExcelUtil<ClassifySkiil> util = new ExcelUtil<ClassifySkiil>(ClassifySkiil.class);
        return util.exportExcel(list, "skiil");
    }

    /**
     * 获取技能分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('classify:skiil:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(classifySkiilService.selectClassifySkiilById(id));
    }

    /**
     * 新增技能分类
     */
    @PreAuthorize("@ss.hasPermi('classify:skiil:add')")
    @Log(title = "技能分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassifySkiil classifySkiil)
    {
        return toAjax(classifySkiilService.insertClassifySkiil(classifySkiil));
    }

    /**
     * 修改技能分类
     */
    @PreAuthorize("@ss.hasPermi('classify:skiil:edit')")
    @Log(title = "技能分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassifySkiil classifySkiil)
    {
        return toAjax(classifySkiilService.updateClassifySkiil(classifySkiil));
    }

    /**
     * 删除技能分类
     */
    @PreAuthorize("@ss.hasPermi('classify:skiil:remove')")
    @Log(title = "技能分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classifySkiilService.deleteClassifySkiilByIds(ids));
    }
}
