package com.Dao;

import com.Entity.User;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static  String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static  String url = "jdbc:mysql://localhost:3306/firstmonthproject?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static  String username = "root";
    private static  String password = "root";
    /**
     * 创建连接
     * @return 连接对象
     */
    public Connection getConnection (){
        try {
            //获取连接对象
            Class.forName(DRIVER_CLASS);
            //返回值
            return DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 关闭资源数据
     * @param c conn
     * @param p pre
     * @param r res
     */
    public void closeAll(Connection c, ResultSet r,PreparedStatement p){
        try{
            if(c != null)c.close();
            if(p != null)p.close();
            if(r != null)r.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证用户信息
     * @return
     */
    public User Verification(String username, String password){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        conn = getConnection();
        String sql = "SELECT * FROM USER WHERE username = ? AND PASSWORD = ?";

        try {
            pra = conn.prepareStatement(sql);
            pra.setString(1,username);
            pra.setString(2,password);
            rs = pra.executeQuery();

            if(rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String userName = rs.getString("username");
                    String pasw = rs.getString("password");
                    int sex = rs.getInt("sex");
                    String hobbys = rs.getString("hobbys");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String addrs = rs.getString("addrs");
                    int flag = rs.getInt("flag");

                    User user = new User(id, userName, pasw, sex, hobbys, phone, email, addrs);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册用户信息
     * @return
     */
    public User register(String username, String password, int sex, String hobbys,
                         String phone, String email, String addrs){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        conn = getConnection();

        String sql = "INSERT INTO USER(username,PASSWORD,sex,hobbys,phone,email,addrs) VALUES (?,?,?,?,?,?,?)";

        try {
            pra = conn.prepareStatement(sql);
            pra.setString(1,username);
            pra.setString(2,password);
            pra.setInt(3,sex);
            pra.setString(4,hobbys);
            pra.setString(5,phone);
            pra.setString(6,email);
            pra.setString(7,addrs);

            int result = pra.executeUpdate();

            if(result > 0){
                User user = new User(username,password);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
