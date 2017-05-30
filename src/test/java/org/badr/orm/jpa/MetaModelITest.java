/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.core.IsCollectionContaining.*;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author OBD
 */
public class MetaModelITest extends BaseClassITest {

	public MetaModelITest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test  @Ignore
	public void shouldGetMapTableAndEntitiesName() {

		Metamodel metamodel = entityManager.getMetamodel();
		for (EntityType<?> e : metamodel.getEntities()) {
			Class<?> entityClass = e.getJavaType();
			String entityTableName = entityClass.getAnnotation(Table.class) == null ? entityClass.getSimpleName().toUpperCase()
					: entityClass.getAnnotation(Table.class).name();
//			System.out.println("Table_Name: " + entityTableName);
		}

		System.out.println("createTableToRootEntityName() ==>");
		createTableToRootEntityName(entityManager).entrySet().stream().map(e -> (new StringBuilder()).append(e.getKey()).append(" **** ").append(e.getValue()))
																		.forEach(System.out::println);

		System.out.println("\ngetTableNameWithUniqueID() ==>");
		getTableNameWithUniqueID(entityManager).entrySet().stream().map(e -> (new StringBuilder()).append(e.getKey()).append(" **** ").append(e.getValue()))
				.forEach(System.out::println);

	}

	private Map<String, String> createTableToRootEntityName(EntityManager entityManager) {
		Metamodel metamodel = entityManager.getMetamodel();
		Map<String, String> test = metamodel.getEntities()
						.stream()
				        .collect(Collectors.toMap(e -> getTableName(e.getJavaType()), e -> e.getJavaType().getName()));

		return test;
	}

	private String getTableName(Class<?> entityClass) {
		return entityClass.getAnnotation(Table.class) != null ? entityClass.getAnnotation(Table.class).name():
																getEntityName(entityClass);
	}

	private String getEntityName(Class<?> entityClass) {
		if (entityClass.getAnnotation(Entity.class) == null){
			throw new IllegalArgumentException(String.format("l'Entity [%s] n'est pas annotée par @javax.​persistence.Entity!", entityClass.getName()));
		}

		return entityClass.getAnnotation(Entity.class).name().isEmpty()? entityClass.getSimpleName():
																		 entityClass.getAnnotation(Entity.class).name();
	}

	@Test @Ignore
	public void shouldGetSignleIDTable(){
	//Given
		List expectedTableNamesWithSignleID = Arrays.asList("DEPARTEEEEMENT");
	//When
		List resultTableNamesWithSignleID = Arrays.asList(getTableNameWithUniqueID(entityManager).keySet().toArray());
	//Then
		assertThat(resultTableNamesWithSignleID, is(expectedTableNamesWithSignleID));
	}



	private String getColumnName(EntityType entity, String fieldName){
		Column column = null;
		try {
			// Here just to get an inherited field as well don't forget to get rid of Embeddedid
			column = entity.getSingularAttribute(fieldName).getJavaMember().getDeclaringClass().getDeclaredField(fieldName).getAnnotation(Column.class);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		return column != null? column.name():fieldName;

	}

	private Map<String, String> getTableNameWithUniqueID(EntityManager entityManager){
		Metamodel metamodel = entityManager.getMetamodel();

		return metamodel.getEntities()
				.stream()
				.filter(e-> e.hasSingleIdAttribute() && e.getSingularAttributes().stream()
													.filter( a -> a.isId() && (a.getPersistentAttributeType()== PersistentAttributeType.BASIC))
													.count()==1)
				.collect(Collectors.toMap(e -> getTableName(e.getJavaType()),
										  e -> getColumnName(e , e.getSingularAttributes().stream().filter(a->a.isId()).findFirst().get().getName())));
	}

	public static Map<String, String> createTableToRootEntityName(SessionFactory sessionFactory) {

		Map<String, String> tableToRootEntityName = new HashMap<>();
		MetamodelImplementor metamodelImplementor = (MetamodelImplementor) sessionFactory.getMetamodel();

		for (Map.Entry<String, EntityPersister> entry : metamodelImplementor.entityPersisters().entrySet()) {

			ClassMetadata classMetadata = entry.getValue().getClassMetadata();
			if (classMetadata instanceof SingleTableEntityPersister) {
				SingleTableEntityPersister entityP = (SingleTableEntityPersister) classMetadata;
				String tableName = entityP.getTableName();
				tableToRootEntityName.put(tableName, entityP.getRootEntityName());
			}
		}
		return tableToRootEntityName;
	}

	@Test
	public void entityAndSessionManagerShouldGetSameTableName(){
		//assertEquals(createTableToRootEntityName(entityManager.getEntityManagerFactory().unwrap(SessionFactory.class)), createTableToRootEntityName(entityManager));
//		Map<String, String> expectedResultSessionFactory = createTableToRootEntityName(entityManager.getEntityManagerFactory().unwrap(SessionFactory.class));
//		Map<String, String> expectedResultEntityManager = createTableToRootEntityName(entityManager);
//
//		assertTrue(expectedResultSessionFactory.values().containsAll(expectedResultEntityManager.values()));
//		assertTrue(expectedResultSessionFactory.keySet().stream().collect(Collectors.toList()).containsAll(expectedResultEntityManager.keySet().stream().collect(Collectors.toList())));

	assertThat(createTableToRootEntityName(entityManager),
			   is(createTableToRootEntityName(entityManager.getEntityManagerFactory().unwrap(SessionFactory.class))));

	}


}
