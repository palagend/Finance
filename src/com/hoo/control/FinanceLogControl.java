package com.hoo.control;

import com.hoo.entity.FinanceLog;
import com.hoo.service.ReportService;
import com.hoo.utils.Page;
import com.hoo.utils.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-28.
 */
@Controller
public class FinanceLogControl {
    @Autowired
    private ReportService reportService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,false));  //true:允许输入空值，false:不能为空值
    }

    @RequestMapping("/income-cost")
    public String incomeCost( Date date, HttpServletRequest req){
        BigDecimal income = reportService.getIncome(date);
        BigDecimal cost = reportService.getCost(date);
        BigDecimal history_income = reportService.getHistoryIncome();
        BigDecimal history_cost = reportService.getHistoryCost();
        req.setAttribute("income",income);
        req.setAttribute("history_income",history_income);
        req.setAttribute("cost",cost);
        req.setAttribute("history_cost",history_cost);
        req.setAttribute("date",date);
        return UrlHelper.INCOME_COST;
    }

    @RequestMapping("/finance-log")
    public String financeLog(HttpServletRequest request){
        Page page = new Page();
        List<FinanceLog> logs = reportService.queryAllLog(page);
        request.setAttribute("pageInfo",page);
        request.setAttribute("logs",logs);
        return UrlHelper.FINANCE_LOG;
    }

    @RequestMapping("/finance-logs/{pageNo}")
    public String getLogPage(HttpServletRequest request ,@PathVariable int pageNo){
        Page page = new Page();
        page.setCurrentPage(pageNo);
        List<FinanceLog> logs =  reportService.queryAllLog(page);
        request.setAttribute("pageInfo",page);
        request.setAttribute("logs",logs);
        return UrlHelper.FINANCE_LOG;
    }
}
