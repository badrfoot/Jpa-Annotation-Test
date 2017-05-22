/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

	@Test
	public void shouldGetMapTableAndEntitiesName() {

		Metamodel metamodel = entityManager.getMetamodel();
		for (EntityType<?> e : metamodel.getEntities()) {
			Class<?> entityClass = e.getJavaType();
			String entityTableName = entityClass.getAnnotation(Table.class) == null ? entityClass.getSimpleName().toUpperCase()
					: entityClass.getAnnotation(Table.class).name();
//			System.out.println("Table_Name: " + entityTableName);
		}

//		createTableToRootEntityName(entityManager).entrySet().stream().map(e -> (new StringBuilder()).append(e.getKey()).append(" **** ").append(e.getValue()))
//																		.forEach(System.out::println);
		getTableNameWithUniqueID(entityManager).entrySet().stream().map(e -> (new StringBuilder()).append(e.getKey()).append(" **** ").append(e.getValue()))
				.forEach(System.out::println);

	}

	private Map<String, String> createTableToRootEntityName(EntityManager entityManager) {
		Metamodel metamodel = entityManager.getMetamodel();
		return metamodel.getEntities().stream()
				.collect(Collectors.toMap(e -> getTableName(entityManager, e.getJavaType(), metamodel), e -> e.getJavaType().getSimpleName()));
	}

	private String getTableName(EntityManager em, Class<?> entityClass, Metamodel metamodel) {
		return entityClass.getAnnotation(Table.class) == null ? entityClass.getSimpleName().toUpperCase()
				: entityClass.getAnnotation(Table.class).name();
	}

	private String getColumnName(EntityType entity, Field field) {
		Column column = field.getAnnotation(Column.class);

		return column == null ? field.getName() : column.name();


	}

	private Map<String, String> getTableNameWithUniqueID(EntityManager entityManager) throws NoSuchFieldException{
		Metamodel metamodel = entityManager.getMetamodel();
		Map<String, String> tablesNameWithSingleIdMap = new HashMap<>();

		for (EntityType entityType : metamodel.getEntities()) {

			for (SingularAttribute singularAttribute : entityType.getSingularAttributes()) {
				if (singularAttribute.isId()){
					tablesNameWithSingleIdMap.put(getTableName(entityManager, entityType.getClass(), metamodel), getColumnName(entityType, entityType.getdec));
				}
			}

		}


		return metamodel.getEntities()
				.stream()
				.filter(e -> e.getSingularAttributes().stream().map(a -> a.isId()).count() == 1)
				.collect(to)

	}

}
