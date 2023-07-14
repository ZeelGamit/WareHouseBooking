/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
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

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "compliencesincluded")
@NamedQueries({
    @NamedQuery(name = "Compliencesincluded.findAll", query = "SELECT c FROM Compliencesincluded c"),
    @NamedQuery(name = "Compliencesincluded.findByCompliencesincludedId", query = "SELECT c FROM Compliencesincluded c WHERE c.compliencesincludedId = :compliencesincludedId")})
public class Compliencesincluded implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "compliencesincludedId")
    private Integer compliencesincludedId;
    @JoinColumn(name = "compliencesId", referencedColumnName = "CompliancesId")
    @ManyToOne(optional = false)
    private Compliances compliencesId;
    @JoinColumn(name = "warehouseId", referencedColumnName = "WarehouseId")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;

    public Compliencesincluded() {
    }

    public Compliencesincluded(Integer compliencesincludedId) {
        this.compliencesincludedId = compliencesincludedId;
    }

    public Integer getCompliencesincludedId() {
        return compliencesincludedId;
    }

    public void setCompliencesincludedId(Integer compliencesincludedId) {
        this.compliencesincludedId = compliencesincludedId;
    }

    public Compliances getCompliencesId() {
        return compliencesId;
    }

    public void setCompliencesId(Compliances compliencesId) {
        this.compliencesId = compliencesId;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compliencesincludedId != null ? compliencesincludedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compliencesincluded)) {
            return false;
        }
        Compliencesincluded other = (Compliencesincluded) object;
        if ((this.compliencesincludedId == null && other.compliencesincludedId != null) || (this.compliencesincludedId != null && !this.compliencesincludedId.equals(other.compliencesincludedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Compliencesincluded[ compliencesincludedId=" + compliencesincludedId + " ]";
    }
    
}
