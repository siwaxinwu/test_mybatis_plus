package com.roy;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.roy.dao.UserMapper;
import com.roy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


/**
 * description：
 * author：dingyawu
 * date：created in 14:02 2020/11/12
 * history:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void arTest() {
        User user = new User();
        user.setAge(23);
        user.setRealName("刘强东");
        user.setEmail("siwaxinwu@sian.com");
        user.setManagerId(1326863455185072129L);
        user.setCreateTime(new Date());
        boolean insert = user.insert();
        System.out.println(insert);
    }

    @Test
    public void arTest1() {
        /*User user = new User();
        User user1 = user.selectById(1327258383375437825L);
        System.out.println(user1);*/

        /*User user = new User();
        user.setUserId(1327258383375437825L);
        User user1 = user.selectById();
        System.out.println(user1);*/

        /*User user = new User();
        user.setUserId(1327258383375437825L);
        user.setRealName("张强东");
        boolean result = user.updateById();
        System.out.println(result);*/

        /*看你带不带userId了，带了先做查询，有记录就更新，没记录还是插入*/
        User user = new User();
        user.setAge(23);
        user.setRealName("张强男");
        user.setEmail("dingyawu@qq.com");
        user.setManagerId(1326864134331031553L);
        boolean result = user.insertOrUpdate();
        System.out.println(result);

    }



}
