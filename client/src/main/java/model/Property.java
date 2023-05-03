/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author giang
 */

public class Property implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String type;
    private Integer roomId;
    private Double price;
    private Boolean isDelete;

    public Property(Integer id, String name, String type, Integer roomId, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.roomId = roomId;
        this.price = price;
        this.isDelete = false;
    }

    public Property(Integer id, String name, String type, Integer roomId, Double price, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.roomId = roomId;
        this.price = price;
        this.isDelete = isDelete;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    
}
