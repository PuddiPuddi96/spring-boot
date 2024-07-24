package it.davide.course.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work: adding an account");
    }
}
