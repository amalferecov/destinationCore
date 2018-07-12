/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crag.destinationCore.db.domains;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author heisenberg
 */
@Entity
@Table(name = "GroupUsers")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "GroupUsers.findAll", query = "SELECT g FROM GroupUsers g")
//    , @NamedQuery(name = "GroupUsers.findByIdGroupUser", query = "SELECT g FROM GroupUsers g WHERE g.idGroupUser = :idGroupUser")
//    , @NamedQuery(name = "GroupUsers.findByIsActive", query = "SELECT g FROM GroupUsers g WHERE g.isActive = :isActive")})
public class GroupUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroupUser")
    private Integer idGroupUser;
    @Column(name = "isActive")
    private Integer isActive;
    @OneToMany(mappedBy = "idGroupUser")
    private List<GroupLogs> groupLogsList;
    @JoinColumn(name = "idGroup", referencedColumnName = "idGroup")
    @ManyToOne(optional = false)
    private Group1 idGroup;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private UsersDetails idUser;

    public GroupUsers() {
    }

    public GroupUsers(Integer idGroupUser) {
        this.idGroupUser = idGroupUser;
    }

    public Integer getIdGroupUser() {
        return idGroupUser;
    }

    public void setIdGroupUser(Integer idGroupUser) {
        this.idGroupUser = idGroupUser;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<GroupLogs> getGroupLogsList() {
        return groupLogsList;
    }

    public void setGroupLogsList(List<GroupLogs> groupLogsList) {
        this.groupLogsList = groupLogsList;
    }

    public Group1 getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Group1 idGroup) {
        this.idGroup = idGroup;
    }

    public UsersDetails getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersDetails idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupUser != null ? idGroupUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupUsers)) {
            return false;
        }
        GroupUsers other = (GroupUsers) object;
        if ((this.idGroupUser == null && other.idGroupUser != null) || (this.idGroupUser != null && !this.idGroupUser.equals(other.idGroupUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crag.destinationCore.db.domains.GroupUsers[ idGroupUser=" + idGroupUser + " ]";
    }
    
}
