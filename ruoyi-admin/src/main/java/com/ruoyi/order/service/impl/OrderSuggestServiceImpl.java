package com.ruoyi.order.service.impl;

import com.ruoyi.address.domain.AddressInfo;
import com.ruoyi.order.domain.OrderSuggestInfoVO;
import com.ruoyi.order.service.IOrderIncomeInfoService;
import com.ruoyi.order.service.OrderSuggestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


@Service
public class OrderSuggestServiceImpl implements OrderSuggestService {

    @Resource
    private IOrderIncomeInfoService iOrderIncomeInfoService;

    @Override
    public List<OrderSuggestInfoVO> getOrderSuggestOfStart(AddressInfo start, BigDecimal distance, String type) {
        return null;
    }

    @Override
    public List<List<OrderSuggestInfoVO>> getOrderSuggestOfStartToEnd(AddressInfo start, AddressInfo end, String type) {
        return null;
    }
}
