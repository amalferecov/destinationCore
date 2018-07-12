/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crag.destinationCore.db.domains;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author heisenberg
 */
@Entity
@Table(name = "GroupLogsRepo")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "GroupLogs.findAll", query = "SELECT g FROM GroupLogs g")
//    , @NamedQuery(name = "GroupLogs.findByIdGroupLogs", query = "SELECT g FROM GroupLogs g WHERE g.idGroupLogs = :idGroupLogs")
//    , @NamedQuery(name = "GroupLogs.findByValue", query = "SELECT g FROM GroupLogs g WHERE g.value = :value")
//    , @NamedQuery(name = "GroupLogs.findByDate", query = "SELECT g FROM GroupLogs g WHERE g.date = :date")})
public class GroupLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroupLogs")
    private Integer idGroupLogs;
    @Column(name = "Value")
    private Integer value;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idGroupDetail", referencedColumnName = "idGroupDetails")
    @ManyToOne
    private GroupDetails idGroupDetail;
    @JoinColumn(name = "idGroupUser", referencedColumnName = "idGroupUser")
    @ManyToOne
    private GroupUsers idGroupUser;

    public GroupLogs() {
    }

    public GroupLogs(Integer idGroupLogs) {
        this.idGroupLogs = idGroupLogs;
    }

    public Integer getIdGroupLogs() {
        return idGroupLogs;
    }

    public void setIdGroupLogs(Integer idGroupLogs) {
        this.idGroupLogs = idGroupLogs;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GroupDetails getIdGroupDetail() {
        return idGroupDetail;
    }

    public void setIdGroupDetail(GroupDetails idGroupDetail) {
        this.idGroupDetail = idGroupDetail;
    }

    public GroupUsers getIdGroupUser() {
        return idGroupUser;
    }

    public void setIdGroupUser(GroupUsers idGroupUser) {
        this.idGroupUser = idGroupUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupLogs != null ? idGroupLogs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupLogs)) {
            return false;
        }
        GroupLogs other = (GroupLogs) object;
        if ((this.idGroupLogs == null && other.idGroupLogs != null) || (this.idGroupLogs != null && !this.idGroupLogs.equals(other.idGroupLogs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crag.destinationCore.db.domains.GroupLogsRepo[ idGroupLogs=" + idGroupLogs + " ]";
    }
    
}
