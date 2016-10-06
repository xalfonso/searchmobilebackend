/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package com.eas.admin.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "core.profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, length = 11, insertable = false, updatable = false)
    private long id;
    
    @Column(length = 255, nullable = false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProfilePrivilege> profilePrivileges;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfilePrivilege> getProfilePrivileges() {
        return profilePrivileges;
    }

    public void setProfilePrivileges(List<ProfilePrivilege> profilePrivileges) {
        this.profilePrivileges = profilePrivileges;
    }

    public long[] getPrivilegesIds() {
        long[] pri = new long[this.profilePrivileges.size()];

        for (int i = 0; i < this.profilePrivileges.size(); i++) {
            pri[i] = this.profilePrivileges.get(i).getPrivilege().getId();
        }

        return pri;
    }

    public List<Privilege> getPrivileges() {
        List<Privilege> privileges = new ArrayList();

        for (ProfilePrivilege profilePrivilege : this.profilePrivileges) {
            privileges.add(profilePrivilege.getPrivilege());
        }

        return privileges;
    }

    public Privilege getPrivilegeGenerator(Iterator<ProfilePrivilege> it) {
        return it.next().getPrivilege();

    }

}
