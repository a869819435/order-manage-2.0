package com.ywq.order.service;

import com.ywq.address.domain.AddressInfo;
import com.ywq.order.domain.OrderSuggestInfoVO;

import java.math.BigDecimal;
import java.util.List;

public interface OrderSuggestService {

    List<OrderSuggestInfoVO> getOrderSuggestOfStart(AddressInfo start, BigDecimal distance, String type);

    List<List<OrderSuggestInfoVO>> getOrderSuggestOfStartToEnd(AddressInfo start,AddressInfo end,String type);
}
