package Entity;

import Entity.Booking;
import Entity.Person;
import Entity.Provideservice;
import Entity.Role;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Participate.class)
public class Participate_ { 

    public static volatile SingularAttribute<Participate, String> password;
    public static volatile SingularAttribute<Participate, Role> roleId;
    public static volatile SingularAttribute<Participate, Integer> participateId;
    public static volatile SingularAttribute<Participate, Person> personId;
    public static volatile CollectionAttribute<Participate, Booking> bookingCollection;
    public static volatile SingularAttribute<Participate, String> username;
    public static volatile CollectionAttribute<Participate, Provideservice> provideserviceCollection;

}