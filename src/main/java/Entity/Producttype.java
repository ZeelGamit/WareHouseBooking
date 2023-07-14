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
@Table(name = "producttype")
@NamedQueries({
    @NamedQuery(name = "Producttype.findAll", query = "SELECT p FROM Producttype p"),
    @NamedQuery(name = "Producttype.findByProductTypeId", query = "SELECT p FROM Producttype p WHERE p.productTypeId = :productTypeId"),
    @NamedQuery(name = "Producttype.findByProductType", query = "SELECT p FROM Producttype p WHERE p.productType = :productType")})
public class Producttype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductTypeId")
    private Integer productTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ProductType")
    private String productType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productTypeId")
    private Collection<Producttypeincluded> producttypeincludedCollection;

    public Producttype() {
    }

    public Producttype(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Producttype(Integer productTypeId, String productType) {
        this.productTypeId = productTypeId;
        this.productType = productType;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonbTransient
    public Collection<Producttypeincluded> getProducttypeincludedCollection() {
        return producttypeincludedCollection;
    }

    public void setProducttypeincludedCollection(Collection<Producttypeincluded> producttypeincludedCollection) {
        this.producttypeincludedCollection = producttypeincludedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productTypeId != null ? productTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producttype)) {
            return false;
        }
        Producttype other = (Producttype) object;
        if ((this.productTypeId == null && other.productTypeId != null) || (this.productTypeId != null && !this.productTypeId.equals(other.productTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Producttype[ productTypeId=" + productTypeId + " ]";
    }
    
}
