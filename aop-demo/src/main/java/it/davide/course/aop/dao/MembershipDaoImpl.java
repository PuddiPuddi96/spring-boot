package it.davide.course.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work: adding a membership account");
    }
}
