package com.Dao;

import com.Entity.Goodsinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsinfoDao {
    //调用Dao类 以达到使用连接方法
    Dao dao = new Dao();

    Connection connection = null;
    PreparedStatement pra = null;
    ResultSet rs = null;

    /**
     * 执行增删改操作方法
     * @param sql  传入的sql语句
     * @param list  传入的占位符
     * @return
     */
    public int executeUpdate (String sql, List<Object> list){
        try {
            //获取连接
            connection = dao.getConnection();
            //获得语句集
            pra = connection.prepareStatement(sql);
            //判断list集合内是否有占位符
            if(list != null && list.size() > 0){
                //添加占位符
                for(int i = 0; i < list.size(); i++){
                    pra.setObject(i+1 , list.get(i));
                }
            }
            //判断受影响的行数数
            int result = pra.executeUpdate();

            dao.closeAll(connection,rs,pra);
            //返回 受影响的行数
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //增加
    public int addGoods(Goodsinfo goodsinfo){
        String sql = "INSERT INTO goodsinfo(goodsInfo_name,goodsInfo_pic,goodsInfo_price,goodsInfo_description,goods_stock,flag) VALUES (?,?,?,?,?,?)";

        List list = new ArrayList();
        list.add(goodsinfo.getGoodsinfoName());
        list.add(goodsinfo.getGoodsinfoPic());
        list.add(goodsinfo.getGoodsinfoPrice());
        list.add(goodsinfo.getGoodsinfoDescrip());
        list.add(goodsinfo.getGoodsStock());
        list.add(goodsinfo.getFlas());
        //传入操作方法
        return executeUpdate(sql , list);
    }
    //删除
    public int removeGoods(Goodsinfo goodsinfo){
        String sql = "DELETE FROM goodsinfo WHERE id = ?;";

        List list = new ArrayList();
        list.add(goodsinfo.getId());
        //传入操作方法
        return executeUpdate(sql , list);
    }
    //修改
    public int reviseGoods(Goodsinfo goodsinfo){
        String sql = "UPDATE goodsinfo SET goodsInfo_name=?,goodsInfo_pic=?,goodsInfo_price=?,goodsInfo_description=?,goods_stock=? WHERE id=?";

        List list = new ArrayList();
        list.add(goodsinfo.getGoodsinfoName());
        list.add(goodsinfo.getGoodsinfoPic());
        list.add(goodsinfo.getGoodsinfoPrice());
        list.add(goodsinfo.getGoodsinfoDescrip());
        list.add(goodsinfo.getGoodsStock());
        list.add(goodsinfo.getId());
        //传入操作方法
        return executeUpdate(sql , list);
    }
    /**
     * 查看数据库的中产品信息 （激活状态不显示）
     * @return 信息对象 Goodssinfo
     */
    public List<Goodsinfo> watchGoods(){
        try {
            //获取连接
            connection = dao.getConnection();
            //创建查看sql
            String sql = "SELECT * FROM goodsinfo ";

            pra = connection.prepareStatement(sql);

            rs = pra.executeQuery();

            if(rs != null){
                List<Goodsinfo> list = new ArrayList<>();
                while (rs.next()){
                    Goodsinfo goodsinfo = new Goodsinfo();
                    goodsinfo.setId(rs.getInt("id"));
                    goodsinfo.setGoodsinfoName(rs.getString("goodsInfo_name"));
                    goodsinfo.setGoodsinfoPic(rs.getString("goodsInfo_pic"));
                    goodsinfo.setGoodsinfoPrice(rs.getInt("goodsInfo_price"));
                    goodsinfo.setGoodsinfoDescrip(rs.getString("goodsInfo_description"));
                    goodsinfo.setGoodsStock(rs.getInt("goods_stock"));
                    goodsinfo.setFlas(rs.getInt("flag"));
                    list.add(goodsinfo);
                }
                dao.closeAll(connection,rs,pra);
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Goodsinfo fantGoodsbyID(String id){
        try {
            //获取连接
            connection = dao.getConnection();
            //创建查看sql
            String sql = "SELECT * FROM goodsinfo where id = ?";

            pra = connection.prepareStatement(sql);

            int ID = Integer.parseInt(id);
            pra.setInt(1,ID);

            rs = pra.executeQuery();

            if(rs != null){
                if (rs.next()){
                    Goodsinfo goodsinfo = new Goodsinfo();
                    goodsinfo.setId(rs.getInt("id"));
                    goodsinfo.setGoodsinfoName(rs.getString("goodsInfo_name"));
                    goodsinfo.setGoodsinfoPic(rs.getString("goodsInfo_pic"));
                    goodsinfo.setGoodsinfoPrice(rs.getInt("goodsInfo_price"));
                    goodsinfo.setGoodsinfoDescrip(rs.getString("goodsInfo_description"));
                    goodsinfo.setGoodsStock(rs.getInt("goods_stock"));
                    goodsinfo.setFlas(rs.getInt("flag"));
                    return goodsinfo;
                }
                dao.closeAll(connection,rs,pra);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
