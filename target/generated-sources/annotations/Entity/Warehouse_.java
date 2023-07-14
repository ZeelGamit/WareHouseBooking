package Entity;

import Entity.Amenityincluded;
import Entity.Booking;
import Entity.Compliencesincluded;
import Entity.Construction;
import Entity.Location;
import Entity.Producttypeincluded;
import Entity.Serviceincluded;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Warehouse.class)
public class Warehouse_ { 

    public static volatile SingularAttribute<Warehouse, Double> area;
    public static volatile SingularAttribute<Warehouse, Construction> constructionTypeId;
    public static volatile CollectionAttribute<Warehouse, Producttypeincluded> producttypeincludedCollection;
    public static volatile CollectionAttribute<Warehouse, Compliencesincluded> compliencesincludedCollection;
    public static volatile SingularAttribute<Warehouse, Integer> warehouseId;
    public static volatile SingularAttribute<Warehouse, Location> locationId;
    public static volatile CollectionAttribute<Warehouse, Amenityincluded> amenityincludedCollection;
    public static volatile CollectionAttribute<Warehouse, Booking> bookingCollection;
    public static volatile CollectionAttribute<Warehouse, Serviceincluded> serviceincludedCollection;

}