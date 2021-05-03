package com.ywq.address.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ywq.common.annotation.Excel;
import com.ywq.common.core.domain.BaseEntity;

/**
 * 地址间距信息对象 address_distance_info
 * 
 * @author ywq
 * @date 2021-04-10
 */
public class AddressDistanceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 地址编码x */
//    @Excel(name = "地址编码x")
    private Long codeX;

    /** 地址编码x */
    @Excel(name = "地址编码x")
    private String codeXName;

    /** 地址编码y */
//    @Excel(name = "地址编码y")
    private Long codeY;

    /** 地址编码y */
    @Excel(name = "地址编码y")
    private String codeYName;

    /** 相差距离 */
    @Excel(name = "相差距离")
    private BigDecimal distance;

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
    private Long updateUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUserName;

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
    public void setCodeX(Long codeX) 
    {
        this.codeX = codeX;
    }

    public Long getCodeX() 
    {
        return codeX;
    }
    public void setCodeY(Long codeY) 
    {
        this.codeY = codeY;
    }

    public Long getCodeY() 
    {
        return codeY;
    }
    public void setDistance(BigDecimal distance) 
    {
        this.distance = distance;
    }

    public String getCodeXName() {
        return codeXName;
    }

    public void setCodeXName(String codeXName) {
        this.codeXName = codeXName;
    }

    public String getCodeYName() {
        return codeYName;
    }

    public void setCodeYName(String codeYName) {
        this.codeYName = codeYName;
    }

    public BigDecimal getDistance()
    {
        return distance;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateDate()
    {
        return updateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("codeX", getCodeX())
            .append("codeXName", getCodeXName())
            .append("codeY", getCodeY())
            .append("codeYName", getCodeYName())
            .append("distance", getDistance())
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
