package org.apache.shardingsphere.example.shadow.spring.boot.starter.mybatis.service;

import org.apache.shardingsphere.example.shadow.spring.boot.starter.mybatis.entity.Order;
import org.apache.shardingsphere.example.shadow.spring.boot.starter.mybatis.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: CY.Ma
 * @date: 2024/5/23 17:07
 * @description:
 */
@Service
public class TestService {

    @Autowired
    private OrderRepository orderRepository;

    public void test() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setOrderType(i % 2);
            order.setAddressId(i);
            order.setStatus("INSERT_TEST");
            orderRepository.insert(order);
        }
    }
}
