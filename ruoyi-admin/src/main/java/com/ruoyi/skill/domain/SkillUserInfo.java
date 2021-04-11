package com.ruoyi.skill.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 技能-技师信息对象 skill_user_info
 * 
 * @author ywq
 * @date 2021-04-10
 */
public class SkillUserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 技能主键 */
    @Excel(name = "技能主键")
    private Long skillId;

    /** 技能名称 */
    @Excel(name = "技能名称")
    private String skillName;

    /** 技能熟练度 */
    @Excel(name = "技能熟练度")
    private Integer skillLevel;

    /** 技能拥有人 */
    @Excel(name = "技能拥有人")
    private Long skillerId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDeleted;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateUser;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSkillId(Long skillId) 
    {
        this.skillId = skillId;
    }

    public Long getSkillId() 
    {
        return skillId;
    }
    public void setSkillName(String skillName) 
    {
        this.skillName = skillName;
    }

    public String getSkillName() 
    {
        return skillName;
    }
    public void setSkillLevel(Integer skillLevel) 
    {
        this.skillLevel = skillLevel;
    }

    public Integer getSkillLevel() 
    {
        return skillLevel;
    }
    public void setSkillerId(Long skillerId) 
    {
        this.skillerId = skillerId;
    }

    public Long getSkillerId() 
    {
        return skillerId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }
    public void setCreateUser(Long createUser) 
    {
        this.createUser = createUser;
    }

    public Long getCreateUser() 
    {
        return createUser;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateUser(Long updateUser) 
    {
        this.updateUser = updateUser;
    }

    public Long getUpdateUser() 
    {
        return updateUser;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("skillId", getSkillId())
            .append("skillName", getSkillName())
            .append("skillLevel", getSkillLevel())
            .append("skillerId", getSkillerId())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("isDeleted", getIsDeleted())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}