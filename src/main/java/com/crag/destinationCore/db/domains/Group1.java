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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Group")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Group1.findAll", query = "SELECT g FROM Group g")
//    , @NamedQuery(name = "Group1.findByIdGroup", query = "SELECT g FROM Group g WHERE g.idGroup = :idGroup")
//    , @NamedQuery(name = "Group1.findByGroupName", query = "SELECT g FROM Group g WHERE g.groupName = :groupName")
//    , @NamedQuery(name = "Group1.findByPassword", query = "SELECT g FROM Group g WHERE g.password = :password")
//    , @NamedQuery(name = "Group1.findByCreatedDate", query = "SELECT g FROM Group g WHERE g.createdDate = :createdDate")
//    , @NamedQuery(name = "Group1.findByIsActive", query = "SELECT g FROM Group g WHERE g.isActive = :isActive")})
public class Group1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroup")
    private Integer idGroup;
    @Column(name = "GroupName")
    private String groupName;
    @Column(name = "Password")
    private String password;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "isActive")
    private Integer isActive;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne
    private UsersDetails idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroup")
    private List<GroupDetails> groupDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroup")
    private List<GroupUsers> groupUsersList;

    public Group1() {
    }

    public Group1(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public UsersDetails getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersDetails idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<GroupDetails> getGroupDetailsList() {
        return groupDetailsList;
    }

    public void setGroupDetailsList(List<GroupDetails> groupDetailsList) {
        this.groupDetailsList = groupDetailsList;
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
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group1)) {
            return false;
        }
        Group1 other = (Group1) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crag.destinationCore.db.domains.GroupsRepo[ idGroup=" + idGroup + " ]";
    }
    
}
