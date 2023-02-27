package com.example.smarthome.Database;

import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Model extends LitePalSupport {
    private int model;//模式
    private int curtain_model;
    private int light_model;
    private int lock_model;
    private int heater_model;

    private List<Device> deviceList;

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getCurtain_model() {
        return curtain_model;
    }

    public void setCurtain_model(int curtain_model) {
        this.curtain_model = curtain_model;
    }

    public int getLight_model() {
        return light_model;
    }

    public void setLight_model(int light_model) {
        this.light_model = light_model;
    }

    public int getLock_model() {
        return lock_model;
    }

    public void setLock_model(int lock_model) {
        this.lock_model = lock_model;
    }

    public int getHeater_model() {
        return heater_model;
    }

    public void setHeater_model(int heater_model) {
        this.heater_model = heater_model;
    }

    public Model(int model, int curtain_model, int light_model, int lock_model, int heater_model) {
        this.model = model;
        this.curtain_model = curtain_model;
        this.light_model = light_model;
        this.lock_model = lock_model;
        this.heater_model = heater_model;
    }

    public Model(int model, int curtain_model, int light_model, int lock_model) {
        this.model = model;
        this.curtain_model = curtain_model;
        this.light_model = light_model;
        this.lock_model = lock_model;
    }

    public Model() {
    }
}
