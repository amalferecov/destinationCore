/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crag.destinationCore.db.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author heisenberg
 */
@Entity
@Table(name = "User")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
//    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")
//    , @NamedQuery(name = "User.findByNickName", query = "SELECT u FROM User u WHERE u.nickName = :nickName")
//    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
//    , @NamedQuery(name = "User.findByCreatedDate", query = "SELECT u FROM User u WHERE u.createdDate = :createdDate")})
public class UsersDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "NickName")
    private Integer nickName;
    @Column(name = "Password")
    private String password;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(mappedBy = "idUser")
    private List<Group1> group1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<GroupUsers> groupUsersList;

    public UsersDetails() {
    }

    public UsersDetails(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getNickName() {
        return nickName;
    }

    public void setNickName(Integer nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public List<Group1> getGroup1List() {
        return group1List;
    }

    public void setGroup1List(List<Group1> group1List) {
        this.group1List = group1List;
    }

    @XmlTransient
    public List<GroupUsers> getGroupUsersList() {
        return groupUsersList;
    }

    public void setGroupUsersList(List<GroupUsers> groupUsersList) {
        this.groupUsersList = groupUsersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersDetails)) {
            return false;
        }
        UsersDetails other = (UsersDetails) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crag.destinationCore.db.domains.UsersDetails[ idUser=" + idUser + " ]";
    }
    
}
