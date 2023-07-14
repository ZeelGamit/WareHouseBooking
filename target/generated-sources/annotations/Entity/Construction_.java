package Entity;

import Entity.Warehouse;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Construction.class)
public class Construction_ { 

    public static volatile SingularAttribute<Construction, String> constructionType;
    public static volatile SingularAttribute<Construction, Integer> constructionId;
    public static volatile CollectionAttribute<Construction, Warehouse> warehouseCollection;

}