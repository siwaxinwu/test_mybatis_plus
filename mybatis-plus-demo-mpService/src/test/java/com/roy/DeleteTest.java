package com.roy;


import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.roy.dao.UserMapper;
import com.roy.entity.User;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * description： delete demo 类似于delete
 * author：dingyawu
 * date：created in 14:02 2020/11/12
 * history:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void update() {
        /*int result = mapper.deleteById(111111L);
        System.out.println(result);*/

    }
}
