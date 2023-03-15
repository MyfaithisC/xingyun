package com.lframework.xingyun.api.bo.basedata.storecenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lframework.common.constants.StringPool;
import com.lframework.starter.mybatis.service.IUserService;
import com.lframework.starter.web.bo.BaseBo;
import com.lframework.starter.web.dto.UserDto;
import com.lframework.starter.web.utils.ApplicationUtil;
import com.lframework.xingyun.basedata.entity.StoreCenter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class QueryStoreCenterBo extends BaseBo<StoreCenter> {

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;

    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Boolean available;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String description;

    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = StringPool.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    @ApiModelProperty("修改人ID")
    private String updateBy;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = StringPool.DATE_TIME_PATTERN)
    private LocalDateTime updateTime;

    public QueryStoreCenterBo() {

    }

    public QueryStoreCenterBo(StoreCenter dto) {

        super(dto);
    }

    @Override
    protected void afterInit(StoreCenter dto) {

        IUserService userService = ApplicationUtil.getBean(IUserService.class);

//        UserDto createBy = userService.findById(this.getCreateBy());
//        UserDto updateBy = userService.findById(this.getUpdateBy());
        UserDto createBy = userService.findById("1");
        UserDto updateBy = userService.findById("1");
        this.setCreateBy(createBy.getName());
        this.setUpdateBy(updateBy.getName());
    }
}
