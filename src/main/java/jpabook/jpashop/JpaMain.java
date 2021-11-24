package jpabook.jpashop;


import jpabook.jpashop.domain.Member;

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
//
            Member memberA = new Member(null,"손현호","서울","대조로","209-34");
//            Member memberB = new Member(200L, "memberB");


            System.out.println("========= Before ===========");
            em.persist(memberA);
//            em.persist(memberB);
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getName() = " + findMember.getName());
//            findMember.setName("MemberModify");
            System.out.println("========= After ===========");


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
