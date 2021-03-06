package com.tsofen.agsenceapp.entities;

import java.io.Serializable;
import java.util.List;

public class Account extends User implements Serializable {

    private boolean faulty;

    private List<Devices> devices;
    private Integer faultyDevices;
    private Boolean faultyAccount;
    private Integer numberOfDevices;
    private String CompanyName;

    public Account(){
        super();
    }

    public Account(int id, String username, String email, boolean isFaulty) {
        super(id, username, email);
        this.faulty = isFaulty;

    }
    public Account(String email, String phoneNumber){
        super(email);
        this.phoneNumber = phoneNumber;
    }

    public Account(boolean faulty, int accountid, List<Devices> devices, Integer faultyDevices, String phoneNumber, Boolean faultyAccount, Integer numberOfDevices) {
        this.faulty = faulty;

        this.devices = devices;
        this.faultyDevices = faultyDevices;
        this.phoneNumber = phoneNumber;
        this.faultyAccount = faultyAccount;
        this.numberOfDevices = numberOfDevices;
    }

    public Account(int id, String username, String email, boolean faulty, int accountid, List<Devices> devices, Integer faultyDevices, String phoneNumber, Boolean faultyAccount, Integer numberOfDevices) {
        super(id, username, email);
        this.faulty = faulty;
        this.devices = devices;
        this.faultyDevices = faultyDevices;
        this.phoneNumber = phoneNumber;
        this.faultyAccount = faultyAccount;
        this.numberOfDevices = numberOfDevices;
    }

    public boolean isFaulty() {
        return faulty;
    }

    public void setFaulty(boolean faulty) {
        this.faulty = faulty;
    }





    public List<Devices> getDevices() {
        return devices;
    }

    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }

    public Integer getFaultyDevices() {
        return faultyDevices;
    }

    public void setFaultyDevices(Integer faultyDevices) {
        this.faultyDevices = faultyDevices;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getFaultyAccount() {
        return faultyAccount;
    }

    public void setFaultyAccount(Boolean faultyAccount) {
        this.faultyAccount = faultyAccount;
    }

    public Integer getNumberOfDevices() {
        return numberOfDevices;
    }

    public void setNumberOfDevices(Integer numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "isFaulty=" + faulty +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", Company name='" + CompanyName + '\'' +
                '}';
    }
}
