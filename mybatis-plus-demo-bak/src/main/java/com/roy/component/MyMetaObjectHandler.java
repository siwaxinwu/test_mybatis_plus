package com.roy.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

/**
 * description： 自定义插入和更新的时候如何填充
 * author：dingyawu
 * date：created in 17:50 2020/11/14
 * history:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean flag = metaObject.hasSetter("createTime");
        if (false == flag){
            return;
        }
        System.out.println("insertFill-----");
        setInsertFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime != null){
            return;
        }
        System.out.println("updateFill------");
        setUpdateFieldValByName("updateTime", new Date(),metaObject);
    }
}
