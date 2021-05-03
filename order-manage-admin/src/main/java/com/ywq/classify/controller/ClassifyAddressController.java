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
import com.ywq.classify.domain.ClassifyAddress;
import com.ywq.classify.service.IClassifyAddressService;
import com.ywq.common.utils.poi.ExcelUtil;

/**
 * 地址分类Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/classify/address")
public class ClassifyAddressController extends BaseController
{
    @Autowired
    private IClassifyAddressService classifyAddressService;

    /**
     * 查询地址分类列表
     */
    @PreAuthorize("@ss.hasPermi('classify:address:list')")
    @GetMapping("/list")
    public AjaxResult list(ClassifyAddress classifyAddress)
    {
        List<ClassifyAddress> list = classifyAddressService.selectClassifyAddressList(classifyAddress);
        return AjaxResult.success(list);
    }

    /**
     * 导出地址分类列表
     */
    @PreAuthorize("@ss.hasPermi('classify:address:export')")
    @Log(title = "地址分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ClassifyAddress classifyAddress)
    {
        List<ClassifyAddress> list = classifyAddressService.selectClassifyAddressList(classifyAddress);
        ExcelUtil<ClassifyAddress> util = new ExcelUtil<ClassifyAddress>(ClassifyAddress.class);
        return util.exportExcel(list, "address");
    }

    /**
     * 获取地址分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('classify:address:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(classifyAddressService.selectClassifyAddressById(id));
    }

    /**
     * 新增地址分类
     */
    @PreAuthorize("@ss.hasPermi('classify:address:add')")
    @Log(title = "地址分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassifyAddress classifyAddress)
    {
        return toAjax(classifyAddressService.insertClassifyAddress(classifyAddress));
    }

    /**
     * 修改地址分类
     */
    @PreAuthorize("@ss.hasPermi('classify:address:edit')")
    @Log(title = "地址分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassifyAddress classifyAddress)
    {
        return toAjax(classifyAddressService.updateClassifyAddress(classifyAddress));
    }

    /**
     * 删除地址分类
     */
    @PreAuthorize("@ss.hasPermi('classify:address:remove')")
    @Log(title = "地址分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classifyAddressService.deleteClassifyAddressByIds(ids));
    }
}
