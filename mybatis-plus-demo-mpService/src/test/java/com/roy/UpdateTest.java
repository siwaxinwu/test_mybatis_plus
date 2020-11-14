package com.roy;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.roy.entity.User;
import com.roy.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;


/**
 * description：
 * author：dingyawu
 * date：created in 14:02 2020/11/12
 * history:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void update() {
        /*User user = new User();
        user.setUserId(1327422566041722882L);
        user.setAge(34);
        user.setEmail("xuli@qq.com");
        int update = mapper.updateById(user);
        System.out.println(update);*/

        /*UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setAge(34);
        user.setEmail("liyiwei@qq.com");
        int result = mapper.update(user, wrapper);
        System.out.println("affect rows" + result);*/


       /* User user1 = new User();
        user1.setAge(34);
        user1.setRealName("李艺伟");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>(user1);
        User user = new User();
        user.setAge(35);
        user.setEmail("liyiwei35@qq.com");
        int result = mapper.update(user, wrapper);
        System.out.println("affect rows" + result);*/

       /* UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "李艺伟").eq("age", 34)
                .set("age", 30);
        int result = mapper.update(null, wrapper);
        System.out.println("affect rows" + result);*/

        /*LambdaUpdateWrapper<User> wrapper = Wrappers.<User>lambdaUpdate();
        wrapper.eq(User::getRealName, "李艺伟").eq(User::getAge, 30).set(User::getAge, 31);
        int result = mapper.update(null, wrapper);
        System.out.println("affect rows" + result);*/

        LambdaUpdateChainWrapper<User> wrapper = new LambdaUpdateChainWrapper<>(mapper);
        boolean result = wrapper.eq(User::getRealName, "李艺伟").eq(User::getAge, 31).set(User::getAge, 33).update();
        System.out.println("affect rows" + result);

    }
}
