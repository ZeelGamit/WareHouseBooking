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
@Table(name = "participate")
@NamedQueries({
    @NamedQuery(name = "Participate.findAll", query = "SELECT p FROM Participate p"),
    @NamedQuery(name = "Participate.All", query = "SELECT p FROM Participate p ORDER BY p.username"),
    @NamedQuery(name = "Participate.findByParticipateId", query = "SELECT p FROM Participate p WHERE p.participateId = :participateId"),
    @NamedQuery(name = "Participate.findByPassword", query = "SELECT p FROM Participate p WHERE p.password = :password"),
    @NamedQuery(name = "Participate.findByUsername", query = "SELECT p FROM Participate p WHERE p.username = :username")})
public class Participate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ParticipateId")
    private Integer participateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1080)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Username")
    private String username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participateId")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicerId")
    private Collection<Provideservice> provideserviceCollection;

    public Participate() {
    }

    public Participate(Integer participateId) {
        this.participateId = participateId;
    }

    public Participate(Integer participateId, String password, String username) {
        this.participateId = participateId;
        this.password = password;
        this.username = username;
    }

    public Integer getParticipateId() {
        return participateId;
    }

    public void setParticipateId(Integer participateId) {
        this.participateId = participateId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonbTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @JsonbTransient
    public Collection<Provideservice> getProvideserviceCollection() {
        return provideserviceCollection;
    }

    public void setProvideserviceCollection(Collection<Provideservice> provideserviceCollection) {
        this.provideserviceCollection = provideserviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participateId != null ? participateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participate)) {
            return false;
        }
        Participate other = (Participate) object;
        if ((this.participateId == null && other.participateId != null) || (this.participateId != null && !this.participateId.equals(other.participateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Participate[ participateId=" + participateId + " ]";
    }
    
}
