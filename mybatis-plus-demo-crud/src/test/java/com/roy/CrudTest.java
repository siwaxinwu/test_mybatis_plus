package com.roy;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.*;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
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
public class CrudTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void aInsert() {
        User user = new User();
        user.setRealName("wuyueyue");
        user.setAge(22);
        user.setEmail("wuyueyue@mp.com");
        user.setManagerId(1087982257332887553L);
        user.setCreateTime(new Date());
        user.setRemark("i am remark");
        // 成功直接拿会写的 ID
        int result = mapper.insert(user);
        System.out.println("影响记录数" + result);
    }


    @Test
    public void bDelete() {
        //是可以为空的
        int result1 = mapper.deleteById(null);
        System.out.println(result1);
        int result2 = mapper.delete(new QueryWrapper<User>().lambda().eq(User::getRealName, "Sandy"));
        System.out.println(result2);
    }


    @Test
    public void cUpdate() {
        int result = mapper.updateById(new User().setUserId(1L).setEmail("ab@c.c"));
        System.out.println(result);

        /*int result2 = mapper.update(new User().setRealName("mp"),
                Wrappers.<User>lambdaUpdate().set(User::getAge, 3).eq(User::getUserId, 2));
        System.out.println(result2);

        User user = mapper.selectById(2);
        System.out.println(user);

        mapper.update(null, Wrappers.<User>lambdaUpdate().set(User::getEmail, null).eq(User::getUserId, 2));
        String email = mapper.selectById(1).getEmail();
        user = mapper.selectById(2);

        mapper.update(
                new User().setEmail("miemie@baomidou.com"),
                new QueryWrapper<User>().lambda().eq(User::getUserId, 2)
        );
        user = mapper.selectById(2);


        mapper.update(
                new User().setEmail("miemie2@baomidou.com"),
                Wrappers.<User>lambdaUpdate()
                        .set(User::getAge, null)
                        .eq(User::getUserId, 2)
        );*/

    }


    @Test
    public void select() {
        User user = mapper.selectById(1087982257332887553L);
        System.out.println(user);

        List<Long> list = Arrays.asList(1087982257332887553L, 1326857474757632002L, 1326861806727098370L);
        List<User> users = mapper.selectBatchIds(list);
        users.stream().forEach(System.out::println);


        /*Map<String, Object> map = new HashMap<>();
        map.put("name","dingyawu");
        map.put("age", 22);
        //where name = “dingyawu” and age = 22， key是列名
        List<User> userList = mapper.selectByMap(map);
        userList.stream().forEach(System.out::println);*/

        //名字中包含雨并且年龄小于40
        /*QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "雨").lt("age", 40);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.stream().forEach(System.out::println);*/

        //名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.like("name", "雨").between("age", 20, 40).isNotNull("email");
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.likeRight("name", "王").or().gt("age", 25).orderByDesc("age").orderByAsc("user_id");
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //创建日期为2019年2月14日并且直属上级为名字为王姓
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.apply("date_format(create_time,'%Y-%m-%d') = {0}", "2019-02-14").inSql("manager_id", "select user_id from mp_user where name like '王%'");
        //这样会有sql注入的风险
        //query.apply("date_format(create_time,'%Y-%m-%d') = '2019-02-14' or true or true").inSql("manager_id", "select user_id from mp_user where name like '王%'");
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //名字为王姓并且（年龄小于40或邮箱不为空）
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/


        /*//名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
        QueryWrapper<User> query = Wrappers.<User>query();
        query.likeRight("name", "王").or(qry -> qry.between("age", 20, 40).isNotNull("email") );
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //（年龄小于40或邮箱不为空）并且名字为王姓  ，or的优先级是小于and的
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.nested(qry -> qry.lt("age", 40).or().isNotNull("email")).likeRight("name", "王");
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/


        //年龄为30、31、34、35
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.in("age", Arrays.asList(30, 31, 34, 35));
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //只返回满足条件的其中一条语句即可
        /*QueryWrapper<User> query = Wrappers.<User>query();
        query.in("age", Arrays.asList(30, 31, 34, 35)).last("limit 1");
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/


        //名字中包含雨并且年龄小于40
        /*QueryWrapper<User> query = Wrappers.<User>query();
        //query.select("user_id","name", "age", "email").like("name", "雨").lt("age", 40);
        query.select(User.class, info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id")).like("name", "雨").lt("age", 40);
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //名字中包含雨并且年龄小于40
        //condition("王", "");

        //实体传参
        /*User user = new User();
        user.setRealName("刘红雨");
        user.setAge(32);
        QueryWrapper<User> query = new QueryWrapper<>(user);
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/


        /*QueryWrapper<User> query = new QueryWrapper<>();
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", "王天风");
        params.put("age", 32);
        //传false会忽略null的值
        //query.allEq(params, false);
        //query.allEq(params);
        query.allEq((key, value) -> !"name".equals(key), params);
        List<User> userList = mapper.selectList(query);
        userList.stream().forEach(System.out::println);*/

        //返回实体不够优雅，只需要返回部分字段
        /*QueryWrapper<User> query = new QueryWrapper<>();
        query.select("user_id", "name").like("name",  "雨").lt("age", 40);
        List<Map<String, Object>> maps = mapper.selectMaps(query);
        maps.stream().forEach(System.out::println);*/

        //按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄。并且只取年龄总和小于500的组
       /* QueryWrapper<User> query = new QueryWrapper<>();
        query.select("avg(age) avg_age", "min(age) as min_age", "max(age) max_age").groupBy("manager_id").having("sum(age) < {0}", 500);
        List<Map<String, Object>> maps = mapper.selectMaps(query);
        maps.stream().forEach(System.out::println);*/




       //按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄。并且只取年龄总和小于500的组,第二列被全部舍弃
        /*QueryWrapper<User> query = new QueryWrapper<>();
        query.select("avg(age) avg_age", "min(age) as min_age", "max(age) max_age").groupBy("manager_id").having("sum(age) < {0}", 500);
        List<Object> results = mapper.selectObjs(query);
        results.stream().forEach(System.out::println);*/

        //统计总记录数
        /*QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name",  "雨").lt("age", 40);
        Integer count = mapper.selectCount(query);
        System.out.println(count);*/

        //selectOne,只能返回一条，返回两条报错
        /*QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name",  "雨").lt("age", 40);
        User user = mapper.selectOne(query);
        System.out.println(user);*/

        //lambda条件构造器
        /*LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>();*/
        /*LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getRealName, "雨").lt(User::getAge, 40);
        List<User> users = mapper.selectList(lambdaQuery);
        users.stream().forEach(System.out::println);*/


        //lambda条件构造器、姓王并且（年龄小于40或邮箱不为空）
        /*LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getRealName,"王").and(qry -> qry.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<User> users = mapper.selectList(lambdaQuery);
        users.stream().forEach(System.out::println);*/

        /*LambdaQueryChainWrapper<User> wrapper = new LambdaQueryChainWrapper<>(mapper);
        List<User> users = wrapper.like(User::getRealName, "雨").gt(User::getAge, 20).list();
        users.stream().forEach(System.out::println);*/

    }
}
