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
@Table(name = "construction")
@NamedQueries({
    @NamedQuery(name = "Construction.findAll", query = "SELECT c FROM Construction c"),
    @NamedQuery(name = "Construction.findByConstructionId", query = "SELECT c FROM Construction c WHERE c.constructionId = :constructionId"),
    @NamedQuery(name = "Construction.findByConstructionType", query = "SELECT c FROM Construction c WHERE c.constructionType = :constructionType")})
public class Construction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ConstructionId")
    private Integer constructionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ConstructionType")
    private String constructionType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constructionTypeId")
    private Collection<Warehouse> warehouseCollection;

    public Construction() {
    }

    public Construction(Integer constructionId) {
        this.constructionId = constructionId;
    }

    public Construction(Integer constructionId, String constructionType) {
        this.constructionId = constructionId;
        this.constructionType = constructionType;
    }

    public Integer getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Integer constructionId) {
        this.constructionId = constructionId;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    @JsonbTransient
    public Collection<Warehouse> getWarehouseCollection() {
        return warehouseCollection;
    }

    public void setWarehouseCollection(Collection<Warehouse> warehouseCollection) {
        this.warehouseCollection = warehouseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (constructionId != null ? constructionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Construction)) {
            return false;
        }
        Construction other = (Construction) object;
        if ((this.constructionId == null && other.constructionId != null) || (this.constructionId != null && !this.constructionId.equals(other.constructionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Construction[ constructionId=" + constructionId + " ]";
    }
    
}
