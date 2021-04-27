package com.parkingworld.parker.account;

import java.util.Date;

public abstract class Account {
  private int id;
  private String name;
  private AccountStatus status;
  private String password;
  private Date timeOfLogin;
  private Date timeOfLogout;

  void resetPassword(String password) {
    this.password = password;
  }

  void login(){}

  void logout(){}

  Account viewAccount(){
    return this;
  }

  Account updateAccount(){//accept parameters
    //return after update
    return this;
  }

  private enum AccountStatus {
    ACTIVE, SUSPENDED, NONACTIVE
  }
}
