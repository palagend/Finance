package com.hoo.intercept;

import cn.org.rapid_framework.jdbc.dialect.Dialect;
import cn.org.rapid_framework.jdbc.dialect.MySQLDialect;
import com.sun.rowset.internal.Row;
import com.szy.common.utils.ReflectHelper;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;
import org.hibernate.validator.util.ReflectionHelper;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by pal on 16-11-27.
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class DialectStatementHandlerInterceptor implements Interceptor {
    private static final java.lang.String DIALECT = "com.mysql.jdbc.Driver";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler routingStatementHandler = (RoutingStatementHandler) invocation.getTarget();
        PreparedStatementHandler preparedStatementHandler = (PreparedStatementHandler) ReflectHelper.getValueByFieldName(routingStatementHandler, "delegate");
        RowBounds rowBounds = (RowBounds) ReflectHelper.getValueByFieldName(preparedStatementHandler, "rowBounds");
        if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
            BoundSql boundSql = preparedStatementHandler.getBoundSql();
            String sql = boundSql.getSql();
            MySQLDialect dialect =(MySQLDialect)Class.forName(DIALECT).newInstance();
            sql = dialect.getLimitString(sql,rowBounds.getOffset(),rowBounds.getLimit());
            ReflectHelper.setValueByFieldName(boundSql,"sql",sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
