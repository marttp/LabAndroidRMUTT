package com.example.imagelistview;

import java.util.ArrayList;
import java.util.List;

public class Hardware {

    private List<Hardware> hardwareList = new ArrayList<>();
    private String category;
    private String description;
    private int resId;

    public Hardware(int resId, String category, String description) {
        this.category = category;
        this.description = description;
        this.resId = resId;
    }

    public List<Hardware> getHardwareList() {
        return hardwareList;
    }

    public void setHardwareList(List<Hardware> hardwareList) {
        this.hardwareList = hardwareList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }


}
