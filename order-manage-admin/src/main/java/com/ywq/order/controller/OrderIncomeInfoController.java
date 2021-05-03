package com.ywq.order.controller;

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
import com.ywq.order.domain.OrderIncomeInfo;
import com.ywq.order.service.IOrderIncomeInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 工单评价Controller
 * 
 * @author ywq
 * @date 2021-04-11
 */
@RestController
@RequestMapping("/order/income")
public class OrderIncomeInfoController extends BaseController
{
    @Autowired
    private IOrderIncomeInfoService orderIncomeInfoService;

    /**
     * 查询工单评价列表
     */
    @PreAuthorize("@ss.hasPermi('order:income:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderIncomeInfo orderIncomeInfo)
    {
        startPage();
        List<OrderIncomeInfo> list = orderIncomeInfoService.selectOrderIncomeInfoList(orderIncomeInfo);
        return getDataTable(list);
    }

    /**
     * 导出工单评价列表
     */
    @PreAuthorize("@ss.hasPermi('order:income:export')")
    @Log(title = "工单评价", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OrderIncomeInfo orderIncomeInfo)
    {
        List<OrderIncomeInfo> list = orderIncomeInfoService.selectOrderIncomeInfoList(orderIncomeInfo);
        ExcelUtil<OrderIncomeInfo> util = new ExcelUtil<OrderIncomeInfo>(OrderIncomeInfo.class);
        return util.exportExcel(list, "income");
    }

    /**
     * 获取工单评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:income:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(orderIncomeInfoService.selectOrderIncomeInfoById(id));
    }

    /**
     * 新增工单评价
     */
    @PreAuthorize("@ss.hasPermi('order:income:add')")
    @Log(title = "工单评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderIncomeInfo orderIncomeInfo)
    {
        return toAjax(orderIncomeInfoService.insertOrderIncomeInfo(orderIncomeInfo));
    }

    /**
     * 修改工单评价
     */
    @PreAuthorize("@ss.hasPermi('order:income:edit')")
    @Log(title = "工单评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderIncomeInfo orderIncomeInfo)
    {
        return toAjax(orderIncomeInfoService.updateOrderIncomeInfo(orderIncomeInfo));
    }

    /**
     * 删除工单评价
     */
    @PreAuthorize("@ss.hasPermi('order:income:remove')")
    @Log(title = "工单评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderIncomeInfoService.deleteOrderIncomeInfoByIds(ids));
    }
}
