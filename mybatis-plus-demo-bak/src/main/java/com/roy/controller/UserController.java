package com.roy.controller;

import com.roy.dao.UserMapper;
import com.roy.entity.User;
import com.roy.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description：
 * author：dingyawu
 * date：created in 16:08 2020/11/14
 * history:
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserMapper mapper;

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/logicdelete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable("id") String id){
        int rows = mapper.deleteById(id);
        System.out.println("affect rows" + rows);
        return rows;
    }


    /**
     * 更新的时候逻辑位也会起作用
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> updateById(@RequestBody User user) throws Exception {
        if (user.getId() == null){
            throw new Exception("参数错误");
        }
        int rows = mapper.updateById(user);
        System.out.println("affect rows" + rows);
        return Result.success(rows);
    }

    /**
     * 查询全部数据
     * -Dspring.profiles.active=dev
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getAll(){
        List<User> users = mapper.selectList(null);
        return Result.success(users);
    }





}
