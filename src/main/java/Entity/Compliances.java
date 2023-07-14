/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "compliances")
@NamedQueries({
    @NamedQuery(name = "Compliances.findAll", query = "SELECT c FROM Compliances c"),
    @NamedQuery(name = "Compliances.findByCompliancesId", query = "SELECT c FROM Compliances c WHERE c.compliancesId = :compliancesId"),
    @NamedQuery(name = "Compliances.findByCompliancName", query = "SELECT c FROM Compliances c WHERE c.compliancName = :compliancName")})
public class Compliances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompliancesId")
    private Integer compliancesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CompliancName")
    private String compliancName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compliencesId")
    private Collection<Compliencesincluded> compliencesincludedCollection;

    public Compliances() {
    }

    public Compliances(Integer compliancesId) {
        this.compliancesId = compliancesId;
    }

    public Compliances(Integer compliancesId, String compliancName) {
        this.compliancesId = compliancesId;
        this.compliancName = compliancName;
    }

    public Integer getCompliancesId() {
        return compliancesId;
    }

    public void setCompliancesId(Integer compliancesId) {
        this.compliancesId = compliancesId;
    }

    public String getCompliancName() {
        return compliancName;
    }

    public void setCompliancName(String compliancName) {
        this.compliancName = compliancName;
    }

    @JsonbTransient
    public Collection<Compliencesincluded> getCompliencesincludedCollection() {
        return compliencesincludedCollection;
    }

    public void setCompliencesincludedCollection(Collection<Compliencesincluded> compliencesincludedCollection) {
        this.compliencesincludedCollection = compliencesincludedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compliancesId != null ? compliancesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compliances)) {
            return false;
        }
        Compliances other = (Compliances) object;
        if ((this.compliancesId == null && other.compliancesId != null) || (this.compliancesId != null && !this.compliancesId.equals(other.compliancesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Compliances[ compliancesId=" + compliancesId + " ]";
    }
    
}
