package com.roy.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.parser.SimpleNode;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sun.misc.PerformanceLogger;

import java.util.ArrayList;

/**
 * description：
 * author：dingyawu
 * date：created in 16:13 2020/11/14
 * history:
 */
@Configuration
public class MyBatisConfiguration {
    /*@Bean
    public ISqlInjector sqlInjector(){
        return new LogicsqlInjector();
    }*/

    /**
     * 配置乐观锁的bean
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 性能分析插件
     * @return
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        PerformanceMonitorInterceptor interceptor = new PerformanceMonitorInterceptor();
        return interceptor;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor interceptor = new PaginationInterceptor();
        ArrayList<ISqlParser> list = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId(boolean select) {
                return new Expression() {
                    @Override
                    public void accept(ExpressionVisitor expressionVisitor) {

                    }

                    @Override
                    public SimpleNode getASTNode() {
                        return null;
                    }

                    @Override
                    public void setASTNode(SimpleNode simpleNode) {

                    }
                };
            }

            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }

        });
        return interceptor;
    }
}
