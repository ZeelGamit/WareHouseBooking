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
@Table(name = "provideproduct")
@NamedQueries({
    @NamedQuery(name = "Provideproduct.findAll", query = "SELECT p FROM Provideproduct p"),
    @NamedQuery(name = "Provideproduct.findByProvideProductId", query = "SELECT p FROM Provideproduct p WHERE p.provideProductId = :provideProductId"),
    @NamedQuery(name = "Provideproduct.findByServicerId", query = "SELECT p FROM Provideproduct p WHERE p.servicerId = :servicerId"),
    @NamedQuery(name = "Provideproduct.findByProductId", query = "SELECT p FROM Provideproduct p WHERE p.productId = :productId"),
    @NamedQuery(name = "Provideproduct.findByIsActive", query = "SELECT p FROM Provideproduct p WHERE p.isActive = :isActive")})
public class Provideproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProvideProductId")
    private Integer provideProductId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ServicerId")
    private int servicerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductId")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive")
    private short isActive;

    public Provideproduct() {
    }

    public Provideproduct(Integer provideProductId) {
        this.provideProductId = provideProductId;
    }

    public Provideproduct(Integer provideProductId, int servicerId, int productId, short isActive) {
        this.provideProductId = provideProductId;
        this.servicerId = servicerId;
        this.productId = productId;
        this.isActive = isActive;
    }

    public Integer getProvideProductId() {
        return provideProductId;
    }

    public void setProvideProductId(Integer provideProductId) {
        this.provideProductId = provideProductId;
    }

    public int getServicerId() {
        return servicerId;
    }

    public void setServicerId(int servicerId) {
        this.servicerId = servicerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provideProductId != null ? provideProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provideproduct)) {
            return false;
        }
        Provideproduct other = (Provideproduct) object;
        if ((this.provideProductId == null && other.provideProductId != null) || (this.provideProductId != null && !this.provideProductId.equals(other.provideProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Provideproduct[ provideProductId=" + provideProductId + " ]";
    }
    
}
