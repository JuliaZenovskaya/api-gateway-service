package com.microservices.apigateway.service.impl;

import com.microservices.apigateway.feign.OrdersFeignClient;
import com.microservices.apigateway.feign.PaymentsFeignClient;
import com.microservices.apigateway.model.Order;
import com.microservices.apigateway.model.Payment;
import com.microservices.apigateway.service.ApiGatewayService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApiGatewayServiceImpl implements ApiGatewayService {
    @Autowired
    OrdersFeignClient ordersFeignClient;

    @Autowired
    PaymentsFeignClient paymentsFeignClient;

    @Override
    public Order getOrder(int orderId) {
        return ordersFeignClient.getOrder(orderId);
    }

    @Override
    public ArrayList<Payment> getPayments(int orderId) {
        return paymentsFeignClient.getPayments(orderId);
    }
}
