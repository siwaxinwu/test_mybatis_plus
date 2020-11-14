package com.roy;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.roy.dao.UserMapper;
import com.roy.entity.User;
import com.roy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * description： 通用service的使用方法
 * author：dingyawu
 * date：created in 14:02 2020/11/12
 * history:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userService() {
        /*User one = userService.getOne(Wrappers.<User>lambdaQuery().gt(User::getAge, 30));
        System.out.println(one);*/

        /*User user = new User();
        user.setRealName("徐丽");
        user.setAge(24);
        User user1 = new User();
        user1.setUserId(111111L);
        user1.setRealName("徐雪");
        user1.setAge(34);
        List<User> userList = Arrays.asList(user, user1);*/
        /*boolean result = userService.saveBatch(userList);
        System.out.println(result);*/
       /* boolean batch = userService.saveOrUpdateBatch(userList);
        System.out.println(batch);*/


        /*List<User> userList = userService.<User>lambdaQuery().gt(User::getAge, 20).like(User::getRealName, "雨").list();
        userList.stream().forEach(System.out:: println);*/

        boolean update = userService.<User>lambdaUpdate().eq(User::getAge, 31).
                like(User::getRealName, "雨").set(User::getAge, 30).update();
        System.out.println(update);






    }






}
