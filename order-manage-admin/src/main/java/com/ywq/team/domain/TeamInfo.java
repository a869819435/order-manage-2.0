package com.ywq.team.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ywq.common.annotation.Excel;
import com.ywq.common.core.domain.BaseEntity;

/**
 * 团队信息对象 team_info
 * 
 * @author ywq
 * @date 2021-04-10
 */
public class TeamInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 团队编码 */
    @Excel(name = "团队编码")
    private String code;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String name;

    /** 团队客服联系电话 */
    @Excel(name = "团队客服联系电话")
    private String phone;

    /** 团队客服联系邮箱 */
    @Excel(name = "团队客服联系邮箱")
    private String mail;

    /** 团队人数 */
    @Excel(name = "团队人数")
    private Integer number;

    /** 团队平均水平 */
    @Excel(name = "团队平均水平")
    private BigDecimal avgPower;

    /** 团队人均收益 */
    @Excel(name = "团队人均收益")
    private BigDecimal avgIncome;

    /** 团队总收益 */
    @Excel(name = "团队总收益")
    private BigDecimal allIncome;

    /** 团队总评 */
    @Excel(name = "团队总评")
    private BigDecimal teamEvaluation;

    /** 团队地址 */
    private String teamAddress;

    /** 团队地址 */
    @Excel(name = "团队地址")
    private String teamAddressInfo;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getAvgPower() {
        return avgPower;
    }

    public void setAvgPower(BigDecimal avgPower) {
        this.avgPower = avgPower;
    }

    public BigDecimal getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(BigDecimal avgIncome) {
        this.avgIncome = avgIncome;
    }

    public BigDecimal getAllIncome() {
        return allIncome;
    }

    public void setAllIncome(BigDecimal allIncome) {
        this.allIncome = allIncome;
    }

    public BigDecimal getTeamEvaluation() {
        return teamEvaluation;
    }

    public void setTeamEvaluation(BigDecimal teamEvaluation) {
        this.teamEvaluation = teamEvaluation;
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
    }

    public String getTeamAddressInfo() {
        return teamAddressInfo;
    }

    public void setTeamAddressInfo(String teamAddressInfo) {
        this.teamAddressInfo = teamAddressInfo;
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
            .append("name", getName())
            .append("phone", getPhone())
            .append("mail", getMail())
            .append("number", getNumber())
            .append("avgPower", getAvgPower())
            .append("avgIncome", getAvgIncome())
            .append("allIncome", getAllIncome())
            .append("teamEvaluation", getTeamEvaluation())
            .append("teamAddress", getTeamAddress())
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
