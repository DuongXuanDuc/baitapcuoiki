/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlidaotao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author os
 */
public class SVModify {
    public static String DB = "jdbc:mysql://localhost:3306/quanlidaihoc?serverTimezone=UTC";
    public static String user = "root";
    public static String pass = "";
    
    public List<SinhVien> findAll() {
        List<SinhVien> svList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "SELECT * FROM SinhVien";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                SinhVien sv = new SinhVien(resultSet.getInt("id"), resultSet.getString("hoTen"), resultSet.getString("gioiTinh"), resultSet.getString("ngaySinh"), resultSet.getString("email"), resultSet.getString("khoa"), resultSet.getString("namNhapHoc"));
                svList.add(sv);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        // Kết thức
        return svList;
    }
 
    public static void insert(SinhVien sv){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "INSERT INTO SinhVien(hoTen, gioiTinh, ngaySinh, email, khoa, namNhapHoc) VALUES(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, sv.getHoTen());
            statement.setString(2, sv.getGioiTinh());
            statement.setString(3, sv.getNgaySinh());
            statement.setString(4, sv.getEmail());
            statement.setString(5, sv.getKhoa());
            statement.setString(6, sv.getNamNhapHoc());
            
            statement.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public static void update(GiangVien gv){
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "UPDATE GiangVien SET hoTen=?, gioiTinh=?, ngaySinh=?, email=?, khoa=? WHERE id=?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, gv.getHoTen());
            statement.setString(2, gv.getGioiTinh());
            statement.setString(3, gv.getNgaySinh());
            statement.setString(4, gv.getEmail());
            statement.setString(5, gv.getKhoa());
            statement.setInt(6, gv.getID());
            
            statement.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(GVModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(GVModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
      public static void delete(SinhVien sv){
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "DELETE FROM SinhVien WHERE ID=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, sv.getID());
            
            statement.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
        public List<SinhVien> findByTen(String hoTen) {
        List<SinhVien> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "SELECT * FROM `sinhvien` WHERE hoTen like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+hoTen+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                SinhVien sv = new SinhVien(resultSet.getInt("ID"), resultSet.getString("hoTen"), resultSet.getString("gioiTinh"), resultSet.getString("ngaySinh"), resultSet.getString("email"), resultSet.getString("khoa"), resultSet.getString("namNhapHoc"));
                studentList.add(sv);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        // Kết thức
        return studentList;
    }
        
    public List<Diem> findDiembyID(SinhVien sv){
        List<Diem> diemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            String sql = "SELECT * FROM Diem WHERE idSV = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, sv.getID());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Diem diem = new Diem(resultSet.getString("mon"), resultSet.getInt("diem"), resultSet.getInt("idSV"));
                diemList.add(diem);
            }
        } catch (SQLException e) {
            Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(SVModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
        return diemList;
    }    
}
