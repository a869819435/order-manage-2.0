package com.ywq.skill.mapper;

import java.util.List;
import com.ywq.skill.domain.SkillerInfo;

/**
 * 技师Mapper接口
 * 
 * @author ywq
 * @date 2021-04-10
 */
public interface SkillerInfoMapper 
{
    /**
     * 查询技师
     * 
     * @param id 技师ID
     * @return 技师
     */
    public SkillerInfo selectSkillerInfoById(Long id);

    /**
     * 查询技师列表
     * 
     * @param skillerInfo 技师
     * @return 技师集合
     */
    public List<SkillerInfo> selectSkillerInfoList(SkillerInfo skillerInfo);

    /**
     * 新增技师
     * 
     * @param skillerInfo 技师
     * @return 结果
     */
    public int insertSkillerInfo(SkillerInfo skillerInfo);

    /**
     * 修改技师
     * 
     * @param skillerInfo 技师
     * @return 结果
     */
    public int updateSkillerInfo(SkillerInfo skillerInfo);

    /**
     * 删除技师
     * 
     * @param id 技师ID
     * @return 结果
     */
    public int deleteSkillerInfoById(Long id);

    /**
     * 批量删除技师
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkillerInfoByIds(Long[] ids);
}
