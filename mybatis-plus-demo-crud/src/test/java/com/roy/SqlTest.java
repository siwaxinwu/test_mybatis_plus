package com.roy;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.roy.entity.User;
import com.roy.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * description：
 * author：dingyawu
 * date：created in 14:02 2020/11/12
 * history:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void sqlTest() {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        wrapper.likeRight(User::getRealName, "王").and(qry -> qry.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<User> users = mapper.selectAll(wrapper);
        users.stream().forEach(System.out::println);
    }



}
