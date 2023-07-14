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
@Table(name = "amenityincluded")
@NamedQueries({
    @NamedQuery(name = "Amenityincluded.findAll", query = "SELECT a FROM Amenityincluded a"),
    @NamedQuery(name = "Amenityincluded.findByAmenityIncludedId", query = "SELECT a FROM Amenityincluded a WHERE a.amenityIncludedId = :amenityIncludedId")})
public class Amenityincluded implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "amenityIncludedId")
    private Integer amenityIncludedId;
    @JoinColumn(name = "amenityId", referencedColumnName = "AmenityId")
    @ManyToOne(optional = false)
    private Amenity amenityId;
    @JoinColumn(name = "warehouseId", referencedColumnName = "WarehouseId")
    @ManyToOne(optional = false)
    private Warehouse warehouseId;

    public Amenityincluded() {
    }

    public Amenityincluded(Integer amenityIncludedId) {
        this.amenityIncludedId = amenityIncludedId;
    }

    public Integer getAmenityIncludedId() {
        return amenityIncludedId;
    }

    public void setAmenityIncludedId(Integer amenityIncludedId) {
        this.amenityIncludedId = amenityIncludedId;
    }

    public Amenity getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Amenity amenityId) {
        this.amenityId = amenityId;
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
        hash += (amenityIncludedId != null ? amenityIncludedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amenityincluded)) {
            return false;
        }
        Amenityincluded other = (Amenityincluded) object;
        if ((this.amenityIncludedId == null && other.amenityIncludedId != null) || (this.amenityIncludedId != null && !this.amenityIncludedId.equals(other.amenityIncludedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Amenityincluded[ amenityIncludedId=" + amenityIncludedId + " ]";
    }
    
}
