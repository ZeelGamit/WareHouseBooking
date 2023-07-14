package Entity;

import Entity.Amenityincluded;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Amenity.class)
public class Amenity_ { 

    public static volatile SingularAttribute<Amenity, Integer> amenityId;
    public static volatile CollectionAttribute<Amenity, Amenityincluded> amenityincludedCollection;
    public static volatile SingularAttribute<Amenity, String> amenityName;

}