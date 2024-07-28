package it.davide.course.aop.dao;

import it.davide.course.aop.model.Account;

import java.util.List;

public interface AccountDao {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account, Boolean isVip);
    Boolean doWork();
    String getName();
    String getServiceCode();
    void setName(String name);
    void setServiceCode(String serviceCode);
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
}
