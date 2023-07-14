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
@Table(name = "producttypeincluded")
@NamedQueries({
    @NamedQuery(name = "Producttypeincluded.findAll", query = "SELECT p FROM Producttypeincluded p"),
    @NamedQuery(name = "Producttypeincluded.findByProductTypeIncludedId", query = "SELECT p FROM Producttypeincluded p WHERE p.productTypeIncludedId = :productTypeIncludedId")})
public class Producttypeincluded implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productTypeIncludedId")
    private Integer productTypeIncludedId;
    @JoinColumn(name = "productTypeId", referencedColumnName = "ProductTypeId")
    @ManyToOne(optional = false)
    private Producttype productTypeId;
    @JoinColumn(name = "warehouseId", referencedColumnName = "WarehouseId")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;

    public Producttypeincluded() {
    }

    public Producttypeincluded(Integer productTypeIncludedId) {
        this.productTypeIncludedId = productTypeIncludedId;
    }

    public Integer getProductTypeIncludedId() {
        return productTypeIncludedId;
    }

    public void setProductTypeIncludedId(Integer productTypeIncludedId) {
        this.productTypeIncludedId = productTypeIncludedId;
    }

    public Producttype getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Producttype productTypeId) {
        this.productTypeId = productTypeId;
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
        hash += (productTypeIncludedId != null ? productTypeIncludedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producttypeincluded)) {
            return false;
        }
        Producttypeincluded other = (Producttypeincluded) object;
        if ((this.productTypeIncludedId == null && other.productTypeIncludedId != null) || (this.productTypeIncludedId != null && !this.productTypeIncludedId.equals(other.productTypeIncludedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Producttypeincluded[ productTypeIncludedId=" + productTypeIncludedId + " ]";
    }
    
}
