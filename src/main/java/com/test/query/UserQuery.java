package com.test.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "用户查询条件实体")
@Data
public class UserQuery extends PageQuery{

    @ApiModelProperty("用户名关键词")
    private String name;
    @ApiModelProperty("用户状态")
    private Integer status;
    @ApiModelProperty("用户余额最小值")
    private Integer minBalance;
    @ApiModelProperty("用户余额最大值")
    private Integer maxBalance;
}
