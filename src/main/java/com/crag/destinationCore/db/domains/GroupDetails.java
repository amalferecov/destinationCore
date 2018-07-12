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
@Table(name = "GroupDetails")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "GroupDetails.findAll", query = "SELECT g FROM GroupDetails g")
//    , @NamedQuery(name = "GroupDetails.findByIdGroupDetails", query = "SELECT g FROM GroupDetails g WHERE g.idGroupDetails = :idGroupDetails")
//    , @NamedQuery(name = "GroupDetails.findByNameOfAction", query = "SELECT g FROM GroupDetails g WHERE g.nameOfAction = :nameOfAction")
//    , @NamedQuery(name = "GroupDetails.findByMinimumTarget", query = "SELECT g FROM GroupDetails g WHERE g.minimumTarget = :minimumTarget")
//    , @NamedQuery(name = "GroupDetails.findByIsActive", query = "SELECT g FROM GroupDetails g WHERE g.isActive = :isActive")})
public class GroupDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroupDetails")
    private Integer idGroupDetails;
    @Column(name = "NameOfAction")
    private String nameOfAction;
    @Column(name = "MinimumTarget")
    private Integer minimumTarget;
    @Column(name = "isActive")
    private Integer isActive;
    @JoinColumn(name = "idGroup", referencedColumnName = "idGroup")
    @ManyToOne(optional = false)
    private Group1 idGroup;
    @OneToMany(mappedBy = "idGroupDetail")
    private List<GroupLogs> groupLogsList;

    public GroupDetails() {
    }

    public GroupDetails(Integer idGroupDetails) {
        this.idGroupDetails = idGroupDetails;
    }

    public Integer getIdGroupDetails() {
        return idGroupDetails;
    }

    public void setIdGroupDetails(Integer idGroupDetails) {
        this.idGroupDetails = idGroupDetails;
    }

    public String getNameOfAction() {
        return nameOfAction;
    }

    public void setNameOfAction(String nameOfAction) {
        this.nameOfAction = nameOfAction;
    }

    public Integer getMinimumTarget() {
        return minimumTarget;
    }

    public void setMinimumTarget(Integer minimumTarget) {
        this.minimumTarget = minimumTarget;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Group1 getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Group1 idGroup) {
        this.idGroup = idGroup;
    }

    @XmlTransient
    public List<GroupLogs> getGroupLogsList() {
        return groupLogsList;
    }

    public void setGroupLogsList(List<GroupLogs> groupLogsList) {
        this.groupLogsList = groupLogsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupDetails != null ? idGroupDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupDetails)) {
            return false;
        }
        GroupDetails other = (GroupDetails) object;
        if ((this.idGroupDetails == null && other.idGroupDetails != null) || (this.idGroupDetails != null && !this.idGroupDetails.equals(other.idGroupDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crag.destinationCore.db.domains.GroupDetails[ idGroupDetails=" + idGroupDetails + " ]";
    }
    
}
