package com.jydev.covidapp.network.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class Item {
    @Element(name = "careCnt")
    private int careCnt;
    @Element(name = "clearCnt")
    private int clearCnt;
    @Element(name = "deathCnt")
    private int deathCnt;
    @Element(name = "decideCnt")
    private int decideCnt;
    @Element(name = "examCnt")
    private int examCnt;

    public int getCareCnt() {
        return careCnt;
    }

    public void setCareCnt(int careCnt) {
        this.careCnt = careCnt;
    }

    public int getClearCnt() {
        return clearCnt;
    }

    public void setClearCnt(int clearCnt) {
        this.clearCnt = clearCnt;
    }

    public int getDeathCnt() {
        return deathCnt;
    }

    public void setDeathCnt(int deathCnt) {
        this.deathCnt = deathCnt;
    }

    public int getDecideCnt() {
        return decideCnt;
    }

    public void setDecideCnt(int decideCnt) {
        this.decideCnt = decideCnt;
    }

    public int getExamCnt() {
        return examCnt;
    }

    public void setExamCnt(int examCnt) {
        this.examCnt = examCnt;
    }
}
