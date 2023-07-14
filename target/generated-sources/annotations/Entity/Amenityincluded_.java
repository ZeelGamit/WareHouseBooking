package Entity;

import Entity.Amenity;
import Entity.Warehouse;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Amenityincluded.class)
public class Amenityincluded_ { 

    public static volatile SingularAttribute<Amenityincluded, Integer> amenityIncludedId;
    public static volatile SingularAttribute<Amenityincluded, Amenity> amenityId;
    public static volatile SingularAttribute<Amenityincluded, Warehouse> warehouseId;

}