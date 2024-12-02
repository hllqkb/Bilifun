package com.test.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "分页查询条件实体")
public class PageQuery {
    @ApiModelProperty("页码")
    private Integer pageNo;
    @ApiModelProperty("每页条数")
    private Integer pageSize;
    @ApiModelProperty("排序字段")
    private String orderBy;
    @ApiModelProperty("排序方式")
    private String order;

}
