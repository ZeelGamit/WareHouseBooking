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
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "provideservice")
@NamedQueries({
    @NamedQuery(name = "Provideservice.findAll", query = "SELECT p FROM Provideservice p"),
    @NamedQuery(name = "Provideservice.findByProvideServiceId", query = "SELECT p FROM Provideservice p WHERE p.provideServiceId = :provideServiceId"),
    @NamedQuery(name = "Provideservice.findByIsActive", query = "SELECT p FROM Provideservice p WHERE p.isActive = :isActive")})
public class Provideservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProvideServiceId")
    private Integer provideServiceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "isActive")
    private String isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provideServiceId")
    private Collection<Serviceincluded> serviceincludedCollection;
    @JoinColumn(name = "ServicerId", referencedColumnName = "ParticipateId")
    @ManyToOne(optional = false)
    private Participate servicerId;
    @JoinColumn(name = "ServiceId", referencedColumnName = "ServiceId")
    @ManyToOne(optional = false)
    private Service serviceId;

    public Provideservice() {
    }

    public Provideservice(Integer provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public Provideservice(Integer provideServiceId, String isActive) {
        this.provideServiceId = provideServiceId;
        this.isActive = isActive;
    }

    public Integer getProvideServiceId() {
        return provideServiceId;
    }

    public void setProvideServiceId(Integer provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @JsonbTransient
    public Collection<Serviceincluded> getServiceincludedCollection() {
        return serviceincludedCollection;
    }

    public void setServiceincludedCollection(Collection<Serviceincluded> serviceincludedCollection) {
        this.serviceincludedCollection = serviceincludedCollection;
    }

    public Participate getServicerId() {
        return servicerId;
    }

    public void setServicerId(Participate servicerId) {
        this.servicerId = servicerId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provideServiceId != null ? provideServiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provideservice)) {
            return false;
        }
        Provideservice other = (Provideservice) object;
        if ((this.provideServiceId == null && other.provideServiceId != null) || (this.provideServiceId != null && !this.provideServiceId.equals(other.provideServiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Provideservice[ provideServiceId=" + provideServiceId + " ]";
    }
    
}
