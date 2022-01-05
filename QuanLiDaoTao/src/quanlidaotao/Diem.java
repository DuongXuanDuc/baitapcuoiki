/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlidaotao;

/**
 *
 * @author os
 */
public class Diem {
    private String mon;
    private int diem;
    private int idSV;

    public Diem(String mon, int diem, int idSV) {
        this.mon = mon;
        this.diem = diem;
        this.idSV = idSV;
    }

    public Diem() {
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }
    
}
