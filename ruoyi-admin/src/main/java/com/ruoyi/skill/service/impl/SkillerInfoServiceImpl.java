package com.ruoyi.skill.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.skill.mapper.SkillerInfoMapper;
import com.ruoyi.skill.domain.SkillerInfo;
import com.ruoyi.skill.service.ISkillerInfoService;

/**
 * 技师Service业务层处理
 * 
 * @author ywq
 * @date 2021-04-10
 */
@Service
public class SkillerInfoServiceImpl implements ISkillerInfoService 
{
    @Autowired
    private SkillerInfoMapper skillerInfoMapper;

    /**
     * 查询技师
     * 
     * @param id 技师ID
     * @return 技师
     */
    @Override
    public SkillerInfo selectSkillerInfoById(Long id)
    {
        return skillerInfoMapper.selectSkillerInfoById(id);
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
        return skillerInfoMapper.deleteSkillerInfoById(id);
    }
}
