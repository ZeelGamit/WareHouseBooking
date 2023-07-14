package Entity;

import Entity.City;
import Entity.Warehouse;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> locationName;
    public static volatile SingularAttribute<Location, Integer> locationId;
    public static volatile CollectionAttribute<Location, Warehouse> warehouseCollection;
    public static volatile SingularAttribute<Location, City> cityId;

}