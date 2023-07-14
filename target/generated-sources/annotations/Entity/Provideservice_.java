package Entity;

import Entity.Participate;
import Entity.Service;
import Entity.Serviceincluded;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Provideservice.class)
public class Provideservice_ { 

    public static volatile SingularAttribute<Provideservice, Participate> servicerId;
    public static volatile SingularAttribute<Provideservice, String> isActive;
    public static volatile SingularAttribute<Provideservice, Service> serviceId;
    public static volatile SingularAttribute<Provideservice, Integer> provideServiceId;
    public static volatile CollectionAttribute<Provideservice, Serviceincluded> serviceincludedCollection;

}