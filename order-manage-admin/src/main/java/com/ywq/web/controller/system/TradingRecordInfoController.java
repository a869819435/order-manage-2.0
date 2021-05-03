package com.ywq.web.controller.system;

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
import com.ywq.system.domain.TradingRecordInfo;
import com.ywq.system.service.ITradingRecordInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 交易记录Controller
 * 
 * @author ywq
 * @date 2021-04-11
 */
@RestController
@RequestMapping("/system/trading")
public class TradingRecordInfoController extends BaseController
{
    @Autowired
    private ITradingRecordInfoService tradingRecordInfoService;

    /**
     * 查询交易记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:trading:list')")
    @GetMapping("/list")
    public TableDataInfo list(TradingRecordInfo tradingRecordInfo)
    {
        startPage();
        List<TradingRecordInfo> list = tradingRecordInfoService.selectTradingRecordInfoList(tradingRecordInfo);
        return getDataTable(list);
    }

    /**
     * 导出交易记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:trading:export')")
    @Log(title = "交易记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TradingRecordInfo tradingRecordInfo)
    {
        List<TradingRecordInfo> list = tradingRecordInfoService.selectTradingRecordInfoList(tradingRecordInfo);
        ExcelUtil<TradingRecordInfo> util = new ExcelUtil<TradingRecordInfo>(TradingRecordInfo.class);
        return util.exportExcel(list, "trading");
    }

    /**
     * 获取交易记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:trading:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tradingRecordInfoService.selectTradingRecordInfoById(id));
    }

    /**
     * 新增交易记录
     */
    @PreAuthorize("@ss.hasPermi('system:trading:add')")
    @Log(title = "交易记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TradingRecordInfo tradingRecordInfo)
    {
        return toAjax(tradingRecordInfoService.insertTradingRecordInfo(tradingRecordInfo));
    }

    /**
     * 修改交易记录
     */
    @PreAuthorize("@ss.hasPermi('system:trading:edit')")
    @Log(title = "交易记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TradingRecordInfo tradingRecordInfo)
    {
        return toAjax(tradingRecordInfoService.updateTradingRecordInfo(tradingRecordInfo));
    }

    /**
     * 删除交易记录
     */
    @PreAuthorize("@ss.hasPermi('system:trading:remove')")
    @Log(title = "交易记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tradingRecordInfoService.deleteTradingRecordInfoByIds(ids));
    }
}
