package com.ywq.order.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ywq.common.annotation.Excel;
import com.ywq.common.core.domain.BaseEntity;

/**
 * 工单信息对象 order_info
 * 
 * @author ywq
 * @date 2021-04-10
 */
public class OrderInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 工单编码 */
    @Excel(name = "工单编码")
    private String code;

    /** 工单名称 */
    @Excel(name = "工单名称")
    private String name;

    /** 工单分类id */
    @Excel(name = "工单分类id")
    private Long classId;

    /** 成本 */
    @Excel(name = "成本")
    private BigDecimal cost;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 雇主打赏 */
    @Excel(name = "雇主打赏")
    private BigDecimal exceptional;

    /** 收益 */
    @Excel(name = "收益")
    private BigDecimal profits;

    /** 收益详情描述 */
    @Excel(name = "收益详情描述")
    private String profitsDetail;

    /** 预计使用时长 */
    @Excel(name = "预计使用时长")
    private Integer useTime;

    /** 需要技能 */
    @Excel(name = "需要技能")
    private String needSkills;

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
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setExceptional(BigDecimal exceptional) 
    {
        this.exceptional = exceptional;
    }

    public BigDecimal getExceptional() 
    {
        return exceptional;
    }
    public void setProfits(BigDecimal profits) 
    {
        this.profits = profits;
    }

    public BigDecimal getProfits() 
    {
        return profits;
    }
    public void setProfitsDetail(String profitsDetail) 
    {
        this.profitsDetail = profitsDetail;
    }

    public String getProfitsDetail() 
    {
        return profitsDetail;
    }
    public void setUseTime(Integer useTime) 
    {
        this.useTime = useTime;
    }

    public Integer getUseTime() 
    {
        return useTime;
    }
    public void setNeedSkills(String needSkills) 
    {
        this.needSkills = needSkills;
    }

    public String getNeedSkills() 
    {
        return needSkills;
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
            .append("code", getCode())
            .append("name", getName())
            .append("classId", getClassId())
            .append("cost", getCost())
            .append("price", getPrice())
            .append("exceptional", getExceptional())
            .append("profits", getProfits())
            .append("profitsDetail", getProfitsDetail())
            .append("useTime", getUseTime())
            .append("needSkills", getNeedSkills())
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
