package com.hoo.intercept;

import com.szy.common.utils.ReflectHelper;
import org.apache.ibatis.executor.resultset.FastResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;

/**
 * Created by pal on 16-11-27.
 */
@Intercepts({@Signature(
        type = ResultSetHandler.class,
        method = "handleResultSets",
        args = {Statement.class}
)})
public class DialectResultSetHandlerInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        FastResultSetHandler resultSetHandler = (FastResultSetHandler) invocation.getTarget();
        RowBounds rowBounds = (RowBounds) ReflectHelper.getValueByFieldName(resultSetHandler, "rowBounds");
        if(rowBounds.getLimit()>0&&rowBounds.getLimit()<RowBounds.NO_ROW_LIMIT){
            ReflectHelper.setValueByFieldName(resultSetHandler,"rowBounds",new RowBounds());
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
