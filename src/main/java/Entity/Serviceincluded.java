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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "serviceincluded")
@NamedQueries({
    @NamedQuery(name = "Serviceincluded.findAll", query = "SELECT s FROM Serviceincluded s"),
    @NamedQuery(name = "Serviceincluded.findByServiceIncludedId", query = "SELECT s FROM Serviceincluded s WHERE s.serviceIncludedId = :serviceIncludedId"),
    @NamedQuery(name = "Serviceincluded.findByPrice", query = "SELECT s FROM Serviceincluded s WHERE s.price = :price")})
public class Serviceincluded implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ServiceIncludedId")
    private Integer serviceIncludedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceIncludedId")
    private Collection<Invoiceitem> invoiceitemCollection;
    @JoinColumn(name = "ProvideServiceId", referencedColumnName = "ProvideServiceId")
    @ManyToOne(optional = false)
    private Provideservice provideServiceId;
    @JoinColumn(name = "CurrentStatusId", referencedColumnName = "StatusId")
    @ManyToOne(optional = false)
    private Status currentStatusId;
    @JoinColumn(name = "WarehouseId", referencedColumnName = "WarehouseId")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;

    public Serviceincluded() {
    }

    public Serviceincluded(Integer serviceIncludedId) {
        this.serviceIncludedId = serviceIncludedId;
    }

    public Serviceincluded(Integer serviceIncludedId, double price) {
        this.serviceIncludedId = serviceIncludedId;
        this.price = price;
    }

    public Integer getServiceIncludedId() {
        return serviceIncludedId;
    }

    public void setServiceIncludedId(Integer serviceIncludedId) {
        this.serviceIncludedId = serviceIncludedId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonbTransient
    public Collection<Invoiceitem> getInvoiceitemCollection() {
        return invoiceitemCollection;
    }

    public void setInvoiceitemCollection(Collection<Invoiceitem> invoiceitemCollection) {
        this.invoiceitemCollection = invoiceitemCollection;
    }

    public Provideservice getProvideServiceId() {
        return provideServiceId;
    }

    public void setProvideServiceId(Provideservice provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public Status getCurrentStatusId() {
        return currentStatusId;
    }

    public void setCurrentStatusId(Status currentStatusId) {
        this.currentStatusId = currentStatusId;
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
        hash += (serviceIncludedId != null ? serviceIncludedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceincluded)) {
            return false;
        }
        Serviceincluded other = (Serviceincluded) object;
        if ((this.serviceIncludedId == null && other.serviceIncludedId != null) || (this.serviceIncludedId != null && !this.serviceIncludedId.equals(other.serviceIncludedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Serviceincluded[ serviceIncludedId=" + serviceIncludedId + " ]";
    }
    
}
