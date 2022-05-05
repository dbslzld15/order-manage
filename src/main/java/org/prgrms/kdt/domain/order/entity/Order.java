package org.prgrms.kdt.domain.order.entity;

import lombok.Builder;
import lombok.Getter;
import org.prgrms.kdt.domain.user.vo.Address;
import org.prgrms.kdt.global.model.BaseEntity;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
public class Order extends BaseEntity {
    private Long orderId;
    private Address address;
    private OrderStatus orderStatus;
    private LocalDateTime orderDateTime;
    private long userId;

    @Builder
    public Order(Long orderId, Address address, OrderStatus orderStatus,
                 LocalDateTime orderDateTime, long userId) {
        super(now(), now());
        this.orderId = orderId;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderDateTime = orderDateTime;
        this.userId = userId;
    }
}
