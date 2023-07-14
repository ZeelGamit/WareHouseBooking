package Entity;

import Entity.Invoice;
import Entity.Participate;
import Entity.Warehouse;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile CollectionAttribute<Booking, Invoice> invoiceCollection;
    public static volatile SingularAttribute<Booking, Date> endDate;
    public static volatile SingularAttribute<Booking, Warehouse> warehouseId;
    public static volatile SingularAttribute<Booking, Participate> participateId;
    public static volatile SingularAttribute<Booking, Integer> bookingId;
    public static volatile SingularAttribute<Booking, Date> startDate;

}