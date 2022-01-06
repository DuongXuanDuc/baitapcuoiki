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
public class LopHoc {
    private int id;
    private String maLop;
    private String monHoc;
    private String giangVienPhuTrach;
    private String maDangNhap;

    public LopHoc() {
    }

    public LopHoc(String maLop, String monHoc, String giangVienPhuTrach, String maDangNhap) {
        this.maLop = maLop;
        this.monHoc = monHoc;
        this.giangVienPhuTrach = giangVienPhuTrach;
        this.maDangNhap = maDangNhap;
    }

    public LopHoc(int id, String maLop, String monHoc, String giangVienPhuTrach, String maDangNhap) {
        this.id = id;
        this.maLop = maLop;
        this.monHoc = monHoc;
        this.giangVienPhuTrach = giangVienPhuTrach;
        this.maDangNhap = maDangNhap;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getGiangVienPhuTrach() {
        return giangVienPhuTrach;
    }

    public void setGiangVienPhuTrach(String giangVienPhuTrach) {
        this.giangVienPhuTrach = giangVienPhuTrach;
    }

    public String getMaDangNhap() {
        return maDangNhap;
    }

    public void setMaDangNhap(String maDangNhap) {
        this.maDangNhap = maDangNhap;
    }
      
}
