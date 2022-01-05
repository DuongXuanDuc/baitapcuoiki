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
public class SinhVien extends Person{
    String khoa;
    String namNhapHoc;

    public SinhVien() {
    }

    public SinhVien(int ID, String hoTen, String gioiTinh, String ngaySinh, String email, String khoa, String namNhapHoc) {
        super(ID, hoTen, gioiTinh, ngaySinh, email);
        this.khoa = khoa;
        this.namNhapHoc = namNhapHoc;
    }

    public SinhVien(String hoTen, String gioiTinh, String ngaySinh, String email, String khoa, String namNhapHoc) {
        super(hoTen, gioiTinh, ngaySinh, email);
        this.khoa = khoa;
        this.namNhapHoc = namNhapHoc;
    }


    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(String namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }


}
