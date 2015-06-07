package com.speedbook.model;



/**
 * Upload entity. @author MyEclipse Persistence Tools
 */

public class Upload  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String uri;


    // Constructors

    /** default constructor */
    public Upload() {
    }

    
    /** full constructor */
    public Upload(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return this.uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
   








}