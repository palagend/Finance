package com.hoo.service;

import com.hoo.entity.FinanceLog;
import com.hoo.utils.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-28.
 */
public interface ReportService {
    /**
     * 获取date月份的收入
     * @param date
     * @return
     */
    BigDecimal getIncome(Date date);

    /**
     * 获取date月份的支出
     * @param date
     * @return
     */
    BigDecimal getCost(Date date);

    /**
     * 获取历史总收入
     * @return
     */
    BigDecimal getHistoryIncome();

    /**
     * 获取历史总支出
     * @return
     */
    BigDecimal getHistoryCost();

    /**
     * 财务日志
     * @return
     */
    List<FinanceLog> queryAllLog(Page page);
}
