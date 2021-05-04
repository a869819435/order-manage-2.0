package com.ywq.skill.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ywq.common.annotation.Excel;
import com.ywq.common.core.domain.BaseEntity;

/**
 * 技师对象 skiller_info
 * 
 * @author ywq
 * @date 2021-04-10
 */
public class SkillerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 关联的用户账号 */
    private Long userId;

    /** 关联的用户账号 */
    @Excel(name = "关联的用户账号")
    private String userInfo;

    /** 技师能力值 */
    @Excel(name = "技师能力值")
    private BigDecimal power;

    /** 技师评价星级 */
    @Excel(name = "技师评价星级")
    private BigDecimal evaluation;

    /** 地址id */
    private Long addressId;

    /** 所在地址 */
    @Excel(name = "所在地址")
    private String addressInfo;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public BigDecimal getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(BigDecimal evaluation) {
        this.evaluation = evaluation;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
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
            .append("userId", getUserId())
            .append("power", getPower())
            .append("evaluation", getEvaluation())
            .append("addressId", getAddressId())
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
