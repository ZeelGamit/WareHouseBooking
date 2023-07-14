package Entity;

import Entity.Booking;
import Entity.Invoiceitem;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Date> currentTime;
    public static volatile CollectionAttribute<Invoice, Invoiceitem> invoiceitemCollection;
    public static volatile SingularAttribute<Invoice, String> paymentId;
    public static volatile SingularAttribute<Invoice, Integer> invoiceId;
    public static volatile SingularAttribute<Invoice, Double> invoiceAmount;
    public static volatile SingularAttribute<Invoice, Short> paymentStatus;
    public static volatile SingularAttribute<Invoice, Booking> bookingId;
    public static volatile SingularAttribute<Invoice, String> paymentType;

}