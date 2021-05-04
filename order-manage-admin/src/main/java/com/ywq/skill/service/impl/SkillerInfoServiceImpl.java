package com.ywq.skill.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ywq.system.domain.SysUserRole;
import com.ywq.system.mapper.SysUserRoleMapper;
import com.ywq.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywq.skill.mapper.SkillerInfoMapper;
import com.ywq.skill.domain.SkillerInfo;
import com.ywq.skill.service.ISkillerInfoService;

import javax.annotation.Resource;

/**
 * 技师Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class SkillerInfoServiceImpl implements ISkillerInfoService 
{
    @Resource
    private SkillerInfoMapper skillerInfoMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询技师
     * 
     * @param id 技师ID
     * @return 技师
     */
    @Override
    public SkillerInfo selectSkillerInfoById(Long id)
    {
        SkillerInfo skillerInfo = skillerInfoMapper.selectSkillerInfoById(id);
        if (skillerInfo.getEvaluation() == null){
            skillerInfo.setEvaluation(BigDecimal.ZERO);
        }
        if (skillerInfo.getPower() == null){
            skillerInfo.setPower(BigDecimal.ZERO);
        }
        return skillerInfo;
    }

    /**
     * 查询技师列表
     * 
     * @param skillerInfo 技师
     * @return 技师
     */
    @Override
    public List<SkillerInfo> selectSkillerInfoList(SkillerInfo skillerInfo)
    {
        return skillerInfoMapper.selectSkillerInfoList(skillerInfo);
    }

    /**
     * 新增技师
     * 
     * @param skillerInfo 技师
     * @return 结果
     */
    @Override
    public int insertSkillerInfo(SkillerInfo skillerInfo)
    {
        Long userId = skillerInfo.getUserId();
        List<SysUserRole> userRoles = new ArrayList<>(1);
        SysUserRole sysUserRole = new SysUserRole();
        // 技师角色编号为2
        sysUserRole.setRoleId(2L);
        sysUserRole.setUserId(userId);
        userRoles.add(sysUserRole);
        int answer = sysUserRoleMapper.batchUserRole(userRoles);
        if (answer <= 0){
            return answer;
        }
        return skillerInfoMapper.insertSkillerInfo(skillerInfo);
    }

    /**
     * 修改技师
     * 
     * @param skillerInfo 技师
     * @return 结果
     */
    @Override
    public int updateSkillerInfo(SkillerInfo skillerInfo)
    {
        return skillerInfoMapper.updateSkillerInfo(skillerInfo);
    }

    /**
     * 批量删除技师
     * 
     * @param ids 需要删除的技师ID
     * @return 结果
     */
    @Override
    public int deleteSkillerInfoByIds(Long[] ids)
    {
        sysUserRoleMapper.deleteUserRoleInfos(2L,ids);
        return skillerInfoMapper.deleteSkillerInfoByIds(ids);
    }

    /**
     * 删除技师信息
     * 
     * @param id 技师ID
     * @return 结果
     */
    @Override
    public int deleteSkillerInfoById(Long id)
    {
        sysUserRoleMapper.deleteUserRoleInfos(2L,new Long[]{id});
        return skillerInfoMapper.deleteSkillerInfoById(id);
    }
}
