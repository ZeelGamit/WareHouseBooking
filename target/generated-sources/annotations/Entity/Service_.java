package Entity;

import Entity.Provideservice;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Double> servicePrice;
    public static volatile SingularAttribute<Service, String> servicePicture;
    public static volatile SingularAttribute<Service, Integer> serviceId;
    public static volatile SingularAttribute<Service, String> serviceName;
    public static volatile CollectionAttribute<Service, Provideservice> provideserviceCollection;

}