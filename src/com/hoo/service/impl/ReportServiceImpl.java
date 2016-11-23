package com.hoo.service.impl;

import com.hoo.entity.FinanceLog;
import com.hoo.mapper.FinanceLogMapper;
import com.hoo.service.ReportService;
import com.hoo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-28.
 */
@Service
public class ReportServiceImpl implements ReportService{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    FinanceLogMapper logMapper;

    @Override
    public BigDecimal getIncome(Date since) {
        int type= FinanceLog.FinanceLogType.SALARY;
        List<FinanceLog> logs = logMapper.queryAllByTypeSince(type,since);
        BigDecimal sum = new BigDecimal(0);
        for (FinanceLog log:
             logs) {
            sum.add(log.getAmount());
        }
        return sum;
    }

    @Override
    public BigDecimal getCost(Date since) {

        int type= FinanceLog.FinanceLogType.CONSUMPTION;
        List<FinanceLog> logs = logMapper.queryAllByTypeSince(type,since);
        BigDecimal sum = new BigDecimal(0);
        for (FinanceLog log:
                logs) {
            sum.add(log.getAmount());
        }
        return sum;
    }

    @Override
    public BigDecimal getHistoryIncome() {

        int type= FinanceLog.FinanceLogType.SALARY;
        List<FinanceLog> logs = logMapper.queryAllByType(type);
        BigDecimal sum = new BigDecimal(0);
        for (FinanceLog log:
                logs) {
            sum=sum.add(log.getAmount());
        }
        return sum;
    }

    @Override
    public BigDecimal getHistoryCost() {
        int type= FinanceLog.FinanceLogType.CONSUMPTION;
        List<FinanceLog> logs = logMapper.queryAllByType(type);
        BigDecimal sum = new BigDecimal(0);
        for (FinanceLog log:
                logs) {
            sum=sum.add(log.getAmount());
        }
        return sum;
    }

    @Override
    public List<FinanceLog> queryAllLog(Page page) {
        return logMapper.queryAll(page);
    }
}
