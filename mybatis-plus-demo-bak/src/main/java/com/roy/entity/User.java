package com.roy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * description：
 * author：dingyawu
 * date：created in 13:08 2020/11/12
 * history:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("plus_user")
public class User {

    @TableId("user_id")
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Version
    private Integer version;

    @TableLogic
    //查询的时候不显示
    @TableField(select = false)
    private Integer deleted;


}


