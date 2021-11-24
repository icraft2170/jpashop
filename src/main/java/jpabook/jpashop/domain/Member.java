package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @NoArgsConstructor
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @Builder
    public Member(Long id, String name, String city, String street, String zipcode) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
