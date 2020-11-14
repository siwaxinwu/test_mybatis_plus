package com.roy.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * description：
 * @TableName()：直接指定这个实体所对应的表名
 * 如果主键不是id的话，一定要加@TableId注解
 * 排除非表字段的3种方式: 字段用transient修饰， 用static修饰，用注解@TableField(exist = false)修饰
 * @TableField(condition = "%s&lt;#{%s}")  传对象的时候可以通过condition属性来指定约束条件，默认==
 * author：dingyawu
 * date：created in 13:08 2020/11/12
 * history:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("mp_user")
public class User {

    @TableId("user_id")
    private Long userId;

    @TableField(value = "name", condition = SqlCondition.LIKE)
    private String realName;

    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;
    @TableField
    private String email;

    private Long managerId;

    private Date createTime;

    //exist表示非数据库字段
    @TableField(exist = false)
    private String ignoreColumn = "ignoreColumn";

    @TableField(exist = false)
    private Integer count;

    @TableField(exist = false)
    private String remark;

}