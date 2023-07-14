package Entity;

import Entity.Country;
import Entity.Location;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SingularAttribute<City, Integer> cityId;
    public static volatile CollectionAttribute<City, Location> locationCollection;
    public static volatile SingularAttribute<City, Country> countryId;

}