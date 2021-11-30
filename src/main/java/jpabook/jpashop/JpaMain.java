package jpabook.jpashop;


import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = Member.builder()
                    .name("현호")
                    .address(new Address("서울시", "은평구 대조로", "209-34"))
                    .build();
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            System.out.println(findMember.getAddress().fullAddress());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}

//drop table ORDERITEM;
//drop table orders;
//drop table member;
//drop table item;
//drop table delivery;
//drop table category_Item;
//drop table category;