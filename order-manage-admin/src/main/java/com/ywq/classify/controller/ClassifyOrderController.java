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
import com.ywq.classify.domain.ClassifyOrder;
import com.ywq.classify.service.IClassifyOrderService;
import com.ywq.common.utils.poi.ExcelUtil;

/**
 * 工单分类Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/classify/order")
public class ClassifyOrderController extends BaseController
{
    @Autowired
    private IClassifyOrderService classifyOrderService;

    /**
     * 查询工单分类列表
     */
    @PreAuthorize("@ss.hasPermi('classify:order:list')")
    @GetMapping("/list")
    public AjaxResult list(ClassifyOrder classifyOrder)
    {
        List<ClassifyOrder> list = classifyOrderService.selectClassifyOrderList(classifyOrder);
        return AjaxResult.success(list);
    }

    /**
     * 导出工单分类列表
     */
    @PreAuthorize("@ss.hasPermi('classify:order:export')")
    @Log(title = "工单分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ClassifyOrder classifyOrder)
    {
        List<ClassifyOrder> list = classifyOrderService.selectClassifyOrderList(classifyOrder);
        ExcelUtil<ClassifyOrder> util = new ExcelUtil<ClassifyOrder>(ClassifyOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取工单分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('classify:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(classifyOrderService.selectClassifyOrderById(id));
    }

    /**
     * 新增工单分类
     */
    @PreAuthorize("@ss.hasPermi('classify:order:add')")
    @Log(title = "工单分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassifyOrder classifyOrder)
    {
        return toAjax(classifyOrderService.insertClassifyOrder(classifyOrder));
    }

    /**
     * 修改工单分类
     */
    @PreAuthorize("@ss.hasPermi('classify:order:edit')")
    @Log(title = "工单分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassifyOrder classifyOrder)
    {
        return toAjax(classifyOrderService.updateClassifyOrder(classifyOrder));
    }

    /**
     * 删除工单分类
     */
    @PreAuthorize("@ss.hasPermi('classify:order:remove')")
    @Log(title = "工单分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classifyOrderService.deleteClassifyOrderByIds(ids));
    }
}
