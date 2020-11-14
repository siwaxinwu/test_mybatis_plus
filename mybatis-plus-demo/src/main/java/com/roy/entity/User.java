package com.roy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@TableName("mp_user")
public class User {

    @TableId("user_id")
    private Long id;
    private String name;
    private Integer age;
    private String email;
}