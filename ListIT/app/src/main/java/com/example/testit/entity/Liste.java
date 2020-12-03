package com.example.testit.entity;

public class Liste {
int id,idList,idProduct;
    public Liste(int id, int idList, int idProduct) {
        this.id = id;
        this.idList = idList;
        this.idProduct = idProduct;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdList() {
        return idList;
    }
    public void setIdList(int idList) {
        this.idList = idList;
    }
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
