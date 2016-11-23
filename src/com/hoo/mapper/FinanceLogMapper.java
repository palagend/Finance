package com.hoo.mapper;

import com.hoo.entity.FinanceLog;
import com.hoo.utils.Page;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-26.
 */

public  interface FinanceLogMapper extends SqlMapper {
    @Insert("insert into finance_log(date_time,from_account,to_account,type,amount,currency,description) values(#{dateTime},#{from},#{to},#{type},#{amount},#{currency},#{description})")
    void save(FinanceLog log);

    @Results(value={
            @Result(column = "date_time",property = "dateTime"),
            @Result(column = "from_account",property = "from"),
            @Result(column = "to_account",property = "to"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "id",property = "id"),
            @Result(column = "type",property = "type"),
            @Result(column = "amount",property = "amount"),
            @Result(column = "currency",property = "currency")
    })
    @Select("select * from finance_log where type=#{type}")
    List<FinanceLog> queryAllByType(int type);

    List<FinanceLog> queryAllByTypeSince(@Param("type") int type, @Param("date_time") Date date);

    @Select("select * from finance_log ")
    List<FinanceLog> queryAll(Page page);
}
