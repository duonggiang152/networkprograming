/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author giang
 */
@Entity
public class Room implements Serializable {

    private static final long serialVersionUID = 2L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private String descripe;
    private Boolean isDelete;

    public Room() {
    }

    // constructor and getter/setter methods omitted for brevity
    public Room(Integer id, String name, String descripe) {
        this.id = id;
        this.name = name;
        this.descripe = descripe;
        this.isDelete = false;
    }

    public Room(Integer id, String name, String descripe, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.descripe = descripe;
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

    public String getDescripe() {
        return descripe;
    }

    public void setDescripe(String descripe) {
        this.descripe = descripe;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}
