package com.Entity;

public class Goodsinfo {
    private int id;
    private String goodsinfoName;
    private String goodsinfoPic;
    //int
    private int goodsinfoPrice;
    private String goodsinfoDescrip;
    //int
    private int goodsStock;
    //int
    private int flas;
    //不传入id和当前属性的构造方法
    public Goodsinfo(String goodsinfoName, String goodsinfoPic, int goodsinfoPrice, String goodsinfoDescrip, int goodsStock) {
        this.goodsinfoName = goodsinfoName;
        this.goodsinfoPic = goodsinfoPic;
        this.goodsinfoPrice = goodsinfoPrice;
        this.goodsinfoDescrip = goodsinfoDescrip;
        this.goodsStock = goodsStock;
    }
    //全属性构造方法
    public Goodsinfo(int id, String goodsinfoName, String goodsinfoPic, int goodsinfoPrice, String goodsinfoDescrip, int goodsStock, int flas) {
        this.id = id;
        this.goodsinfoName = goodsinfoName;
        this.goodsinfoPic = goodsinfoPic;
        this.goodsinfoPrice = goodsinfoPrice;
        this.goodsinfoDescrip = goodsinfoDescrip;
        this.goodsStock = goodsStock;
        this.flas = flas;
    }
    public Goodsinfo(int id, String goodsinfoName, String goodsinfoPic, int goodsinfoPrice, String goodsinfoDescrip, int goodsStock) {
        this.id = id;
        this.goodsinfoName = goodsinfoName;
        this.goodsinfoPic = goodsinfoPic;
        this.goodsinfoPrice = goodsinfoPrice;
        this.goodsinfoDescrip = goodsinfoDescrip;
        this.goodsStock = goodsStock;
    }
    //无参构造方法
    public Goodsinfo() {
    }

    public Goodsinfo(int id){
        this.id = id;
    }

    public String getGoodsinfoName() {
        return goodsinfoName;
    }

    public void setGoodsinfoName(String goodsinfoName) {
        this.goodsinfoName = goodsinfoName;
    }

    public String getGoodsinfoPic() {
        return goodsinfoPic;
    }

    public void setGoodsinfoPic(String goodsinfoPic) {
        this.goodsinfoPic = goodsinfoPic;
    }

    public int getGoodsinfoPrice() {
        return goodsinfoPrice;
    }

    public void setGoodsinfoPrice(int goodsinfoPrice) {
        this.goodsinfoPrice = goodsinfoPrice;
    }

    public String getGoodsinfoDescrip() {
        return goodsinfoDescrip;
    }

    public void setGoodsinfoDescrip(String goodsinfoDescrip) {
        this.goodsinfoDescrip = goodsinfoDescrip;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public int getFlas() {
        return flas;
    }

    public void setFlas(int flas) {
        this.flas = flas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
