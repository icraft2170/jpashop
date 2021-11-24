package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "item_id")
    private Long itemId;

    private int orderPrice;
    private int count;
}
