package com.javaweb.service.model;

import com.javaweb.entity.AdvantageEntity;

import java.util.List;

public class AccomTypeDTO {

    private String type;
    private String[] adCode;
    private String[] adDes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getAdCode() {
        return adCode;
    }

    public void setAdCode(String[] adCode) {
        this.adCode = adCode;
    }

    public String[] getAdDes() {
        return adDes;
    }

    public void setAdDes(String[] adDes) {
        this.adDes = adDes;
    }
}
