package com.ruoyi.address.controller;

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
import com.ruoyi.address.domain.AddressInfo;
import com.ruoyi.address.service.IAddressInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地址经纬度信息Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/address/info")
public class AddressInfoController extends BaseController
{
    @Autowired
    private IAddressInfoService addressInfoService;

    /**
     * 查询地址经纬度信息列表
     */
    @PreAuthorize("@ss.hasPermi('address:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(AddressInfo addressInfo)
    {
        startPage();
        List<AddressInfo> list = addressInfoService.selectAddressInfoList(addressInfo);
        return getDataTable(list);
    }

    /**
     * 导出地址经纬度信息列表
     */
    @PreAuthorize("@ss.hasPermi('address:info:export')")
    @Log(title = "地址经纬度信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AddressInfo addressInfo)
    {
        List<AddressInfo> list = addressInfoService.selectAddressInfoList(addressInfo);
        ExcelUtil<AddressInfo> util = new ExcelUtil<AddressInfo>(AddressInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取地址经纬度信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('address:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(addressInfoService.selectAddressInfoById(id));
    }

    /**
     * 新增地址经纬度信息
     */
    @PreAuthorize("@ss.hasPermi('address:info:add')")
    @Log(title = "地址经纬度信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AddressInfo addressInfo)
    {
        return toAjax(addressInfoService.insertAddressInfo(addressInfo));
    }

    /**
     * 修改地址经纬度信息
     */
    @PreAuthorize("@ss.hasPermi('address:info:edit')")
    @Log(title = "地址经纬度信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AddressInfo addressInfo)
    {
        return toAjax(addressInfoService.updateAddressInfo(addressInfo));
    }

    /**
     * 删除地址经纬度信息
     */
    @PreAuthorize("@ss.hasPermi('address:info:remove')")
    @Log(title = "地址经纬度信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(addressInfoService.deleteAddressInfoByIds(ids));
    }
}
