package com.datastructure.immutableClass;

public class BankDetails {
    private String bankName;
    private int sortCode;
    private int account;

    public BankDetails(String bankName, int sortCode, int account) {
        this.bankName = bankName;
        this.sortCode = sortCode;
        this.account = account;
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "bankName='" + bankName + '\'' +
                ", sortCode=" + sortCode +
                ", account=" + account +
                '}';
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
