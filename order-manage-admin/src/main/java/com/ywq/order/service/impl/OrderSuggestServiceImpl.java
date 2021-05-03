package com.ywq.order.service.impl;

import com.ywq.address.domain.AddressInfo;
import com.ywq.order.domain.OrderSuggestInfoVO;
import com.ywq.order.service.IOrderIncomeInfoService;
import com.ywq.order.service.OrderSuggestService;
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
