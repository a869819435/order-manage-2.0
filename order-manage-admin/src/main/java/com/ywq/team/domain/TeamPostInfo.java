package com.ywq.team.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ywq.common.annotation.Excel;
import com.ywq.common.core.domain.BaseEntity;

/**
 * 团队职务信息对象 team_post_info
 * 
 * @author ywq
 * @date 2021-04-10
 */
public class TeamPostInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 团队编号 */
    private String code;

    /** 团队信息 */
    @Excel(name = "团队信息")
    private String codeInfo;

    /** 团队职务 */
    @Excel(name = "团队职务")
    private String post;

    /** 职务等级 */
    @Excel(name = "职务等级")
    private Integer postLevel;

    /** 职务薪资 */
    @Excel(name = "职务薪资")
    private BigDecimal salary;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDeleted;

    /** 创建人id */
    private Long createUser;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUserName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改人id */
    private Long updateUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUserName;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(Integer postLevel) {
        this.postLevel = postLevel;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("post", getPost())
            .append("postLevel", getPostLevel())
            .append("salary", getSalary())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("isDeleted", getIsDeleted())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
