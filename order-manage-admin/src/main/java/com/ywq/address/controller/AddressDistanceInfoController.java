package com.ywq.address.controller;

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
import com.ywq.address.domain.AddressDistanceInfo;
import com.ywq.address.service.IAddressDistanceInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 地址间距信息Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/address/distance")
public class AddressDistanceInfoController extends BaseController
{
    @Autowired
    private IAddressDistanceInfoService addressDistanceInfoService;

    /**
     * 查询地址间距信息列表
     */
    @PreAuthorize("@ss.hasPermi('address:distance:list')")
    @GetMapping("/list")
    public TableDataInfo list(AddressDistanceInfo addressDistanceInfo)
    {
        startPage();
        List<AddressDistanceInfo> list = addressDistanceInfoService.selectAddressDistanceInfoList(addressDistanceInfo);
        return getDataTable(list);
    }

    /**
     * 导出地址间距信息列表
     */
    @PreAuthorize("@ss.hasPermi('address:distance:export')")
    @Log(title = "地址间距信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AddressDistanceInfo addressDistanceInfo)
    {
        List<AddressDistanceInfo> list = addressDistanceInfoService.selectAddressDistanceInfoList(addressDistanceInfo);
        ExcelUtil<AddressDistanceInfo> util = new ExcelUtil<AddressDistanceInfo>(AddressDistanceInfo.class);
        return util.exportExcel(list, "distance");
    }

    /**
     * 获取地址间距信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('address:distance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(addressDistanceInfoService.selectAddressDistanceInfoById(id));
    }

    /**
     * 新增地址间距信息
     */
    @PreAuthorize("@ss.hasPermi('address:distance:add')")
    @Log(title = "地址间距信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AddressDistanceInfo addressDistanceInfo)
    {
        return toAjax(addressDistanceInfoService.insertAddressDistanceInfo(addressDistanceInfo));
    }

    /**
     * 修改地址间距信息
     */
    @PreAuthorize("@ss.hasPermi('address:distance:edit')")
    @Log(title = "地址间距信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AddressDistanceInfo addressDistanceInfo)
    {
        return toAjax(addressDistanceInfoService.updateAddressDistanceInfo(addressDistanceInfo));
    }

    /**
     * 删除地址间距信息
     */
    @PreAuthorize("@ss.hasPermi('address:distance:remove')")
    @Log(title = "地址间距信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(addressDistanceInfoService.deleteAddressDistanceInfoByIds(ids));
    }
}
