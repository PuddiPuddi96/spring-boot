package it.davide.course.aop.dao;

import it.davide.course.aop.model.Account;

public interface AccountDao {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account, Boolean isVip);
    Boolean doWork();
}
