package com.ruoyi.order.service;

import com.ruoyi.address.domain.AddressInfo;
import com.ruoyi.order.domain.OrderSuggestInfoVO;

import java.math.BigDecimal;
import java.util.List;

public interface OrderSuggestService {

    List<OrderSuggestInfoVO> getOrderSuggestOfStart(AddressInfo start, BigDecimal distance, String type);

    List<List<OrderSuggestInfoVO>> getOrderSuggestOfStartToEnd(AddressInfo start,AddressInfo end,String type);
}
