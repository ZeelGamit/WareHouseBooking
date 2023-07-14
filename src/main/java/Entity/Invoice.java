/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceId", query = "SELECT i FROM Invoice i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoice.findByCurrentTime", query = "SELECT i FROM Invoice i WHERE i.currentTime = :currentTime"),
    @NamedQuery(name = "Invoice.findByInvoiceAmount", query = "SELECT i FROM Invoice i WHERE i.invoiceAmount = :invoiceAmount"),
    @NamedQuery(name = "Invoice.findByPaymentId", query = "SELECT i FROM Invoice i WHERE i.paymentId = :paymentId"),
    @NamedQuery(name = "Invoice.findByPaymentStatus", query = "SELECT i FROM Invoice i WHERE i.paymentStatus = :paymentStatus"),
    @NamedQuery(name = "Invoice.findByPaymentType", query = "SELECT i FROM Invoice i WHERE i.paymentType = :paymentType")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InvoiceId")
    private Integer invoiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CurrentTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceAmount")
    private double invoiceAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PaymentId")
    private String paymentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PaymentStatus")
    private short paymentStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PaymentType")
    private String paymentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceId")
    private Collection<Invoiceitem> invoiceitemCollection;
    @JoinColumn(name = "BookingId", referencedColumnName = "BookingId")
    @ManyToOne(optional = false)
    private Booking bookingId;

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice(Integer invoiceId, Date currentTime, double invoiceAmount, String paymentId, short paymentStatus, String paymentType) {
        this.invoiceId = invoiceId;
        this.currentTime = currentTime;
        this.invoiceAmount = invoiceAmount;
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public short getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(short paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @JsonbTransient
    public Collection<Invoiceitem> getInvoiceitemCollection() {
        return invoiceitemCollection;
    }

    public void setInvoiceitemCollection(Collection<Invoiceitem> invoiceitemCollection) {
        this.invoiceitemCollection = invoiceitemCollection;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}
