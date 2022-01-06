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
import static quanlidaotao.SVModify.DB;
import static quanlidaotao.SVModify.pass;
import static quanlidaotao.SVModify.user;

/**
 *
 * @author os
 */
public class LopHocModify {
    public static String DB = "jdbc:mysql://localhost:3306/quanlidaihoc?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    public static String user = "root";
    public static String pass = "";
    
    public List<LopHoc> findAll(){
        List<LopHoc> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "SELECT * FROM LopHoc";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                LopHoc lh = new LopHoc(resultSet.getString("maLop"), resultSet.getString("monHoc"), resultSet.getString("giangVienPhuTrach"), resultSet.getString("maDangNhap"));
                list.add(lh);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
        return list;
    }
    
    public static void delete(LopHoc lh){
        Connection connection = null;
        PreparedStatement statement = null;
        //lấy tất cả danh sách sinh viên
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "DELETE FROM LopHoc WHERE ID=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, lh.getId());
            
            statement.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public static void insert(LopHoc lh){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            //query
            String sql = "INSERT INTO LopHoc(maLop, monHoc, giangVienPhuTrach, maDangNhap) VALUES(?, ?, ?, ?)";
            
            statement = connection.prepareCall(sql);
            
            statement.setString(1, lh.getMaLop());
            statement.setString(2, lh.getMonHoc());
            statement.setString(3, lh.getGiangVienPhuTrach());
            statement.setString(4, lh.getMaDangNhap());

            
            statement.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    public List<LopHoc> findDiembyMon(String mon){
        List<LopHoc> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(DB, user, pass);
            
            String sql = "SELECT * FROM LopHoc WHERE monHoc like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, mon);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                LopHoc lophoc = new LopHoc(resultSet.getInt("id"), resultSet.getString("maLop"), resultSet.getString("monHoc"), resultSet.getString("giangVienPhuTrach"), resultSet.getString("maDangNhap"));
                list.add(lophoc);
            }
        } catch (SQLException e) {
            Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(LopHocModify.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
        return list;
    }
}
