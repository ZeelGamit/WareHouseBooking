package Entity;

import Entity.Compliencesincluded;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-18T01:07:43", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Compliances.class)
public class Compliances_ { 

    public static volatile SingularAttribute<Compliances, Integer> compliancesId;
    public static volatile SingularAttribute<Compliances, String> compliancName;
    public static volatile CollectionAttribute<Compliances, Compliencesincluded> compliencesincludedCollection;

}