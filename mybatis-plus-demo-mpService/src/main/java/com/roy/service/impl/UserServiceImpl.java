package com.roy.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roy.dao.UserMapper;
import com.roy.entity.User;
import com.roy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * description：
 * author：dingyawu
 * date：created in 9:02 2020/11/14
 * history:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
