package it.davide.course.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work: adding a membership account\n\n");
    }

    @Override
    public void addSimpleAccount() {
        System.out.println(getClass() + ": Doing my db work: adding a simple account\n\n");
    }

    @Override
    public Boolean addBooleanAccount() {
        System.out.println(getClass() + ": Doing my db work: adding a boolean account\n\n");
        return true;
    }

    @Override
    public Boolean goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep\n\n");
        return true;
    }
}
