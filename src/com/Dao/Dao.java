package com.Dao;

import java.sql.*;

public class Dao {
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
    public void closeAll(Connection c, ResultSet r, PreparedStatement p){
        try{
            if(c != null)c.close();
            if(p != null)p.close();
            if(r != null)r.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
