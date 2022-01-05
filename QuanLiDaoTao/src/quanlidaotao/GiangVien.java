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
public class GiangVien extends Person{
    String khoa;

    public GiangVien(String hoTen, String gioiTinh, String ngaySinh, String email, String khoa) {
        super(hoTen, gioiTinh, ngaySinh, email);
        this.khoa = khoa;
    }

    public GiangVien(int ID, String hoTen, String gioiTinh, String ngaySinh, String email, String khoa) {
        super(ID, hoTen, gioiTinh, ngaySinh, email);
        this.khoa = khoa;
    }


    

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }


    
    
}
