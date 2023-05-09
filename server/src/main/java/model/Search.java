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
public class Search implements Serializable{
    private static final long serialVersionUID = 3L;
    
    private Integer roomId;
    private Double priceGte;
    private Double priceLte;

    public Search() {
    }

    public Search(Integer roomId, Double priceGte, Double priceLte) {
        this.roomId = roomId;
        this.priceGte = priceGte;
        this.priceLte = priceLte;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Double getPriceGte() {
        return priceGte;
    }

    public void setPriceGte(Double priceGte) {
        this.priceGte = priceGte;
    }

    public Double getPriceLte() {
        return priceLte;
    }

    public void setPriceLte(Double priceLte) {
        this.priceLte = priceLte;
    }

    

    
}
