package Entity;

import Entity.Producttype;
import Entity.Warehouse;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Producttypeincluded.class)
public class Producttypeincluded_ { 

    public static volatile SingularAttribute<Producttypeincluded, Warehouse> warehouseId;
    public static volatile SingularAttribute<Producttypeincluded, Integer> productTypeIncludedId;
    public static volatile SingularAttribute<Producttypeincluded, Producttype> productTypeId;

}