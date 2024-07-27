package it.davide.course.aop.dao;

import it.davide.course.aop.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work: adding an account\n\n");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + ": Doing my db work: adding an account: "+ account + "\n\n");
    }

    @Override
    public void addAccount(Account account, Boolean isVip) {
        System.out.println(getClass() + ": Doing my db work: adding an account vip: "+ account + " " + isVip + "\n\n");
    }

    @Override
    public Boolean doWork() {
        System.out.println(getClass() + ": doWork()\n\n");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()\n\n");
        return name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCOde()\n\n");
        return serviceCode;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()\n\n");
        this.name = name;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()\n\n");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(
                new Account("Davide", "Strianese"),
                new Account("Luca", "Strianese"),
                new Account("Gerardina", "Cortese")
        );
    }
}
