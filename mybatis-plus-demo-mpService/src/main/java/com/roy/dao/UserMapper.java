package com.roy.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.roy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * description：
 * author：dingyawu
 * date：created in 13:09 2020/11/12
 * history:
 */
public interface UserMapper extends BaseMapper<User> {
    /*@Select("select * from mp_user ${ew.customSqlSegment}")*/
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

}