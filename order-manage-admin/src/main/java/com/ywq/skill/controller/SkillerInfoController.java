package com.ywq.skill.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ywq.common.core.domain.model.LoginUser;
import com.ywq.common.utils.ServletUtils;
import com.ywq.common.utils.spring.SpringUtils;
import com.ywq.framework.web.service.TokenService;
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
import com.ywq.skill.domain.SkillerInfo;
import com.ywq.skill.service.ISkillerInfoService;
import com.ywq.common.utils.poi.ExcelUtil;
import com.ywq.common.core.page.TableDataInfo;

/**
 * 技师Controller
 * 
 * @author ywq
 * @date 2021-04-10
 */
@RestController
@RequestMapping("/skill/skiller")
public class SkillerInfoController extends BaseController
{
    @Autowired
    private ISkillerInfoService skillerInfoService;

    /**
     * 查询技师列表
     */
    @PreAuthorize("@ss.hasPermi('skill:skiller:list')")
    @GetMapping("/list")
    public TableDataInfo list(SkillerInfo skillerInfo)
    {
        startPage();
        List<SkillerInfo> list = skillerInfoService.selectSkillerInfoList(skillerInfo);
        return getDataTable(list);
    }

    /**
     * 导出技师列表
     */
    @PreAuthorize("@ss.hasPermi('skill:skiller:export')")
    @Log(title = "技师", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SkillerInfo skillerInfo)
    {
        List<SkillerInfo> list = skillerInfoService.selectSkillerInfoList(skillerInfo);
        ExcelUtil<SkillerInfo> util = new ExcelUtil<SkillerInfo>(SkillerInfo.class);
        return util.exportExcel(list, "skiller");
    }

    /**
     * 获取技师详细信息
     */
    @PreAuthorize("@ss.hasPermi('skill:skiller:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(skillerInfoService.selectSkillerInfoById(id));
    }

    /**
     * 新增技师
     */
    @PreAuthorize("@ss.hasPermi('skill:skiller:add')")
    @Log(title = "技师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkillerInfo skillerInfo)
    {
        return toAjax(skillerInfoService.insertSkillerInfo(skillerInfo));
    }

    /**
     * 申请技师角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:addSkillerRole')")
    @Log(title = "申请技师角色", businessType = BusinessType.INSERT)
    @PostMapping("/addSkillerRole")
    public AjaxResult applySkiller(Long addressId,String remark){
        LoginUser loginUser = SpringUtils.getBean(TokenService.class).getLoginUser(ServletUtils.getRequest());
        SkillerInfo skillerInfo = new SkillerInfo();
        skillerInfo.setAddressId(addressId);
        skillerInfo.setRemark(remark);
        skillerInfo.setUserId(loginUser.getUser().getUserId());
        skillerInfo.setEvaluation(BigDecimal.ZERO);
        skillerInfo.setPower(BigDecimal.ZERO);
        return toAjax(skillerInfoService.insertSkillerInfo(skillerInfo));
    }

    /**
     * 修改技师
     */
    @PreAuthorize("@ss.hasPermi('skill:skiller:edit')")
    @Log(title = "技师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkillerInfo skillerInfo)
    {
        return toAjax(skillerInfoService.updateSkillerInfo(skillerInfo));
    }

    /**
     * 删除技师
     */
    @PreAuthorize("@ss.hasPermi('skill:skiller:remove')")
    @Log(title = "技师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(skillerInfoService.deleteSkillerInfoByIds(ids));
    }
}
