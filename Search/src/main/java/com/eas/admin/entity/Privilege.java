/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package com.eas.admin.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "core.privilege")
public class Privilege {
    
    /*The position is important do not change if the app is current in production*/
    public static final String /*1*/PRIV_INIT_PRIVILES = "INIT_PRIVILEGES"; 
    public static final String /*2*/PRIV_LISTAR_PRIVILES = "LISTAR_PRIVILEGES"; 
    
    public static final String /*3*/PRIV_INSERTAR_PROFILE = "INSERTAR_PROFILE";
    public static final String /*4*/PRIV_LISTAR_PROFILE = "LISTAR_PROFILE";
    public static final String /*5*/PRIV_EDITAR_PROFILE = "EDITAR_PROFILE";
    
    public static final String /*6*/PRIV_INSERTAR_USUARIO = "INSERTAR_USUARIO";
    public static final String /*7*/PRIV_LISTAR_USUARIO = "LISTAR_USUARIO";
    public static final String /*8*/PRIV_EDITAR_USUARIO = "EDITAR_USUARIO";
    public static final String /*9*/PRIV_VER_USUARIO = "VER_USUARIO";
    public static final String /*10*/PRIV_VER_MY_USUARIO = "VER_MY_USUARIO";
      
    
//    public static final String PRIV_INSERTAR_SERVER_DRAGON = "INSERTAR_SERVER_DRAGON";
//    public static final String PRIV_LISTAR_SERVER_DRAGON = "LISTAR_SERVER_DRAGON";
//    public static final String PRIV_EDITAR_SERVER_DRAGON = "EDITAR_SERVER_DRAGON";
    
    
           
    @Id    
    @Column(nullable = false, unique = true, length = 11)
    private long id;
    
    @Column(length = 255, nullable = false)
    private String name;
    
    public Long getId() {
        return id;
    }
    
    public Privilege() {
    }
    
    public Privilege(String name, long id) {
        this.name = name;
        this.id = id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    /*@Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof Privilege)
        {
            sameSame = (this.name == null ? ((Privilege) object).name == null : this.name.equals(((Privilege) object).name));
        }

        return sameSame;
    }*/

   
    
    
    public static List<Privilege> getAllPrivileges() throws Exception {
        
        List<Privilege> privileges = new ArrayList();        
       
        long i = 1;
        for (Field fi : Privilege.class.getFields()) {
            if (fi.getName().contains("PRIV")) {
                privileges.add(new Privilege((String) fi.get(new String()), i));
                i++;
            }
        }
        
        return privileges;
        
    }
}
