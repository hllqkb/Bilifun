package com.test.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(description = "分页结果")
@Data
public class PageDto<T> {
    @ApiModelProperty("总记录数")
    private long total;
    @ApiModelProperty("总页数")
    private long pages;
    @ApiModelProperty("当前页集合")
    private List<T> list;
}
