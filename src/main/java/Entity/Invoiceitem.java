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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "invoiceitem")
@NamedQueries({
    @NamedQuery(name = "Invoiceitem.findAll", query = "SELECT i FROM Invoiceitem i"),
    @NamedQuery(name = "Invoiceitem.findByInvoiceItemId", query = "SELECT i FROM Invoiceitem i WHERE i.invoiceItemId = :invoiceItemId"),
    @NamedQuery(name = "Invoiceitem.findByItemName", query = "SELECT i FROM Invoiceitem i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Invoiceitem.findByItemPrice", query = "SELECT i FROM Invoiceitem i WHERE i.itemPrice = :itemPrice")})
public class Invoiceitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InvoiceItemId")
    private Integer invoiceItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ItemName")
    private String itemName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Item_Price")
    private double itemPrice;
    @JoinColumn(name = "InvoiceId", referencedColumnName = "InvoiceId")
    @ManyToOne(optional = false)
    private Invoice invoiceId;
    @JoinColumn(name = "ServiceIncludedId", referencedColumnName = "ServiceIncludedId")
    @ManyToOne(optional = false)
    private Serviceincluded serviceIncludedId;

    public Invoiceitem() {
    }

    public Invoiceitem(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Invoiceitem(Integer invoiceItemId, String itemName, double itemPrice) {
        this.invoiceItemId = invoiceItemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Integer getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Serviceincluded getServiceIncludedId() {
        return serviceIncludedId;
    }

    public void setServiceIncludedId(Serviceincluded serviceIncludedId) {
        this.serviceIncludedId = serviceIncludedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceItemId != null ? invoiceItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoiceitem)) {
            return false;
        }
        Invoiceitem other = (Invoiceitem) object;
        if ((this.invoiceItemId == null && other.invoiceItemId != null) || (this.invoiceItemId != null && !this.invoiceItemId.equals(other.invoiceItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Invoiceitem[ invoiceItemId=" + invoiceItemId + " ]";
    }
    
}
