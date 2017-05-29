
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.metamodel.EntityType;
import org.badr.orm.jpa.BaseClassITest;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OBD
 */
public class DraftTest extends BaseClassITest{
	

	@Test
	public void souldGetSameCollectionMetadata(){

			SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
	//Given
//		Map mapSessionFactory = sessionFactory.getAllCollectionMetadata();
//		System.out.println(mapSessionFactory);

		MetamodelImplementor metamodelImplementor = (MetamodelImplementor) sessionFactory.getMetamodel();


		Map map = metamodelImplementor.collectionPersisters();

		for (EntityType<?> entityType : entityManager.getMetamodel().getEntities()) {
			entityType.getSingularAttributes().stream().forEach(sa-> System.out.println(sa.getJavaMember()));
			entityType.getSingularAttributes().stream().forEach(sa-> System.out.println(sa.getName()));
			entityType.getSingularAttributes().stream().forEach(sa-> System.out.println(sa.getJavaType()));

		

			System.out.println("");
		}

		entityManager.getMetamodel().getEntities().stream().filter(e -> e.getPluralAttributes().size()>0)
				.forEach(e -> System.out.println(e.getPluralAttributes().stream().map(pla -> String.format("%s.%s", e.getJavaType().getName(),pla.getName())).collect(Collectors.toSet())));

		System.out.println("\n**********************FlatMap");
		System.out.println(
		entityManager.getMetamodel().getEntities().stream().filter(e -> e.getPluralAttributes().size()>0)
				.flatMap(e->e.getPluralAttributes().stream().map(pla -> String.format("%s.%s", e.getJavaType().getName(),pla.getName()))).collect(Collectors.toSet()));

		  
		  System.out.println("");

//		entityManager.getMetamodel().getEntities().stream().filter(e -> e. ().size()>0)
//		.flatMap(e->e.getPluralAttributes().stream().map(pla -> String.format("%s.%s", e.getJavaType().getName(),pla.getName()))).collect(Collectors.toSet());



	//When
		//Map mapEntityManager = entityManager.getMetamodel()
	//Then
	}

}
