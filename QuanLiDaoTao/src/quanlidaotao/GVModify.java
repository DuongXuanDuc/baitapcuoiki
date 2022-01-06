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
public class GVModify {
    public static String DB = "jdbc:mysql://localhost:3306/quanlidaihoc?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    public static String user = "root";
    public static String pass = "";
    
    public List<GiangVien> findAll() {
        List<GiangVien> gvList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "SELECT * FROM GiangVien";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                GiangVien gv = new GiangVien(resultSet.getInt("id"), resultSet.getString("hoTen"), resultSet.getString("gioiTinh"), resultSet.getString("ngaySinh"), resultSet.getString("email"), resultSet.getString("khoa"));
                gvList.add(gv);
            }
            
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
        // Kết thức
        return gvList;
    }
 
    public static void insert(GiangVien gv){
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "INSERT INTO GiangVien(hoTen, gioiTinh, ngaySinh, email, khoa) VALUES(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, gv.getHoTen());
            statement.setString(2, gv.getGioiTinh());
            statement.setString(3, gv.getNgaySinh());
            statement.setString(4, gv.getEmail());
            statement.setString(5, gv.getKhoa());
            
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
    
      public static void delete(GiangVien gv){
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "DELETE FROM GiangVien WHERE ID=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, gv.getID());
            
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
    
        public List<GiangVien> findByTen(String hoTen) {
        List<GiangVien> teacherList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "SELECT * FROM `giangvien` WHERE hoTen like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+hoTen+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                GiangVien gv = new GiangVien(resultSet.getInt("ID"), resultSet.getString("hoTen"), resultSet.getString("gioiTinh"), resultSet.getString("ngaySinh"), resultSet.getString("email"), resultSet.getString("khoa"));
                teacherList.add(gv);
            }
            
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
        // Kết thức
        return teacherList;
    }
 
    
      
}
