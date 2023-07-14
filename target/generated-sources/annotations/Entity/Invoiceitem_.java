package Entity;

import Entity.Invoice;
import Entity.Serviceincluded;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Invoiceitem.class)
public class Invoiceitem_ { 

    public static volatile SingularAttribute<Invoiceitem, Serviceincluded> serviceIncludedId;
    public static volatile SingularAttribute<Invoiceitem, String> itemName;
    public static volatile SingularAttribute<Invoiceitem, Double> itemPrice;
    public static volatile SingularAttribute<Invoiceitem, Invoice> invoiceId;
    public static volatile SingularAttribute<Invoiceitem, Integer> invoiceItemId;

}