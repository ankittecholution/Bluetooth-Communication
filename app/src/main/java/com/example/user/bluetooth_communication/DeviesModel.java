package com.example.user.bluetooth_communication;

public class DeviesModel {

    String devies_name;
    String devies_mac;

    public DeviesModel(String devies_name, String devies_mac) {
        this.devies_name = devies_name;
        this.devies_mac = devies_mac;
    }

    public String getDevies_name() {
        return devies_name;
    }

    public void setDevies_name(String devies_name) {
        this.devies_name = devies_name;
    }

    public String getDevies_mac() {
        return devies_mac;
    }

    public void setDevies_mac(String devies_mac) {
        this.devies_mac = devies_mac;
    }
}
