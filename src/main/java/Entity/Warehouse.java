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
@Table(name = "warehouse")
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByWarehouseId", query = "SELECT w FROM Warehouse w WHERE w.warehouseId = :warehouseId"),
    @NamedQuery(name = "Warehouse.findByArea", query = "SELECT w FROM Warehouse w WHERE w.area = :area")})
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WarehouseId")
    private Integer warehouseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Area")
    private double area;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseId")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "ConstructionTypeId", referencedColumnName = "ConstructionId")
    @ManyToOne(optional = false)
    private Construction constructionTypeId;
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId")
    @ManyToOne(optional = false)
    private Location locationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseId")
    private Collection<Producttypeincluded> producttypeincludedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseId")
    private Collection<Serviceincluded> serviceincludedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseId")
    private Collection<Amenityincluded> amenityincludedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseId")
    private Collection<Compliencesincluded> compliencesincludedCollection;

    public Warehouse() {
    }

    public Warehouse(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Warehouse(Integer warehouseId, double area) {
        this.warehouseId = warehouseId;
        this.area = area;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @JsonbTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Construction getConstructionTypeId() {
        return constructionTypeId;
    }

    public void setConstructionTypeId(Construction constructionTypeId) {
        this.constructionTypeId = constructionTypeId;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    @JsonbTransient
    public Collection<Producttypeincluded> getProducttypeincludedCollection() {
        return producttypeincludedCollection;
    }

    public void setProducttypeincludedCollection(Collection<Producttypeincluded> producttypeincludedCollection) {
        this.producttypeincludedCollection = producttypeincludedCollection;
    }

    @JsonbTransient
    public Collection<Serviceincluded> getServiceincludedCollection() {
        return serviceincludedCollection;
    }

    public void setServiceincludedCollection(Collection<Serviceincluded> serviceincludedCollection) {
        this.serviceincludedCollection = serviceincludedCollection;
    }

    @JsonbTransient
    public Collection<Amenityincluded> getAmenityincludedCollection() {
        return amenityincludedCollection;
    }

    public void setAmenityincludedCollection(Collection<Amenityincluded> amenityincludedCollection) {
        this.amenityincludedCollection = amenityincludedCollection;
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
        hash += (warehouseId != null ? warehouseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.warehouseId == null && other.warehouseId != null) || (this.warehouseId != null && !this.warehouseId.equals(other.warehouseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Warehouse[ warehouseId=" + warehouseId + " ]";
    }
    
}
