package io.github.kingschan1204.istock.module.maindata.ctrl;

import com.alibaba.fastjson.JSONObject;
import io.github.kingschan1204.istock.module.maindata.po.Stock;
import io.github.kingschan1204.istock.module.maindata.services.StockInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenguoxiang
 * @create 2018-11-02 15:49
 **/
@Controller
public class StockInfoCtl {
    private Logger log = LoggerFactory.getLogger(StockInfoCtl.class);
    @Autowired
    private StockInfoService stockInfoService;

    @RequestMapping("/stock/info/{code}")
    public String stockInfo(@PathVariable String code, Model model) {
        JSONObject json= stockInfoService.getStockInfo(code);
        model.addAttribute("data",json.toJSONString());
        return "/stock/info/stock_info";
    }
}
