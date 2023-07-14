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
@Table(name = "amenity")
@NamedQueries({
    @NamedQuery(name = "Amenity.findAll", query = "SELECT a FROM Amenity a"),
    @NamedQuery(name = "Amenity.findByAmenityId", query = "SELECT a FROM Amenity a WHERE a.amenityId = :amenityId"),
    @NamedQuery(name = "Amenity.findByAmenityName", query = "SELECT a FROM Amenity a WHERE a.amenityName = :amenityName")})
public class Amenity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AmenityId")
    private Integer amenityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AmenityName")
    private String amenityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amenityId")
    private Collection<Amenityincluded> amenityincludedCollection;

    public Amenity() {
    }

    public Amenity(Integer amenityId) {
        this.amenityId = amenityId;
    }

    public Amenity(Integer amenityId, String amenityName) {
        this.amenityId = amenityId;
        this.amenityName = amenityName;
    }

    public Integer getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Integer amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    @JsonbTransient
    public Collection<Amenityincluded> getAmenityincludedCollection() {
        return amenityincludedCollection;
    }

    public void setAmenityincludedCollection(Collection<Amenityincluded> amenityincludedCollection) {
        this.amenityincludedCollection = amenityincludedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amenityId != null ? amenityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amenity)) {
            return false;
        }
        Amenity other = (Amenity) object;
        if ((this.amenityId == null && other.amenityId != null) || (this.amenityId != null && !this.amenityId.equals(other.amenityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Amenity[ amenityId=" + amenityId + " ]";
    }
    
}
