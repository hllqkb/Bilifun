package com.Books.entity.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("书籍VO实体")
public class Book {
@ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "书籍类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "书籍名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "书籍描述")
    @TableField("description")
    private String description;
}
