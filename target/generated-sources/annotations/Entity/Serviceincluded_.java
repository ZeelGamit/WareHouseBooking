package Entity;

import Entity.Invoiceitem;
import Entity.Provideservice;
import Entity.Status;
import Entity.Warehouse;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Serviceincluded.class)
public class Serviceincluded_ { 

    public static volatile SingularAttribute<Serviceincluded, Integer> serviceIncludedId;
    public static volatile CollectionAttribute<Serviceincluded, Invoiceitem> invoiceitemCollection;
    public static volatile SingularAttribute<Serviceincluded, Warehouse> warehouseId;
    public static volatile SingularAttribute<Serviceincluded, Double> price;
    public static volatile SingularAttribute<Serviceincluded, Status> currentStatusId;
    public static volatile SingularAttribute<Serviceincluded, Provideservice> provideServiceId;

}