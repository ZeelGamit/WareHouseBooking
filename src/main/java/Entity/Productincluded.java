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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "productincluded")
@NamedQueries({
    @NamedQuery(name = "Productincluded.findAll", query = "SELECT p FROM Productincluded p"),
    @NamedQuery(name = "Productincluded.findByProductIncludedId", query = "SELECT p FROM Productincluded p WHERE p.productIncludedId = :productIncludedId"),
    @NamedQuery(name = "Productincluded.findByWarehouseId", query = "SELECT p FROM Productincluded p WHERE p.warehouseId = :warehouseId"),
    @NamedQuery(name = "Productincluded.findByProductProvidedId", query = "SELECT p FROM Productincluded p WHERE p.productProvidedId = :productProvidedId"),
    @NamedQuery(name = "Productincluded.findByPrice", query = "SELECT p FROM Productincluded p WHERE p.price = :price"),
    @NamedQuery(name = "Productincluded.findByStatusId", query = "SELECT p FROM Productincluded p WHERE p.statusId = :statusId")})
public class Productincluded implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductIncludedId")
    private Integer productIncludedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WarehouseId")
    private int warehouseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductProvidedId")
    private int productProvidedId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatusId")
    private int statusId;

    public Productincluded() {
    }

    public Productincluded(Integer productIncludedId) {
        this.productIncludedId = productIncludedId;
    }

    public Productincluded(Integer productIncludedId, int warehouseId, int productProvidedId, int statusId) {
        this.productIncludedId = productIncludedId;
        this.warehouseId = warehouseId;
        this.productProvidedId = productProvidedId;
        this.statusId = statusId;
    }

    public Integer getProductIncludedId() {
        return productIncludedId;
    }

    public void setProductIncludedId(Integer productIncludedId) {
        this.productIncludedId = productIncludedId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductProvidedId() {
        return productProvidedId;
    }

    public void setProductProvidedId(int productProvidedId) {
        this.productProvidedId = productProvidedId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productIncludedId != null ? productIncludedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productincluded)) {
            return false;
        }
        Productincluded other = (Productincluded) object;
        if ((this.productIncludedId == null && other.productIncludedId != null) || (this.productIncludedId != null && !this.productIncludedId.equals(other.productIncludedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productincluded[ productIncludedId=" + productIncludedId + " ]";
    }
    
}
