/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics;

import java.util.SortedMap;
import java.util.TreeMap;
import org.badr.orm.jpa.BaseClassITest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;

/**
 *
 * @author OBD
 */
public class GenericsInheritanceITest extends BaseClassITest{

	private Parking parking;
	private Vehicle vehicle;
	private TwoWheeler twoWheeler;
	private FourWheeler fourWheeler;

	@Before
	public void setUp() {

		vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringTwoWheeler("Bike Steering Handle");

		fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Alto");
		fourWheeler.setSteeringFourWheeler("Alto Steering Wheel");

		transaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(twoWheeler);
		entityManager.persist(fourWheeler);
		transaction.commit();

		parking = new Parking();

		SortedMap<Long, Vehicle> vehicles = new TreeMap<>();

		vehicles.put(vehicle.getVehicleId(), vehicle);
		vehicles.put(twoWheeler.getVehicleId(), twoWheeler);
		vehicles.put(fourWheeler.getVehicleId(), fourWheeler);
		parking.setVehicles(vehicles);

		transaction.begin();
		entityManager.persist(parking);
		transaction.commit();

	}

	@Test
	public void shouldGetAllCastedVehicle() {

		transaction.begin();

		Parking parking2 = entityManager.find(Parking.class, parking.getId());

		assertTrue(parking2.getVehicles().get(vehicle.getVehicleId()) instanceof Vehicle);
		assertTrue(parking2.getVehicles().get(twoWheeler.getVehicleId()) instanceof TwoWheeler);
		assertTrue(parking2.getVehicles().get(fourWheeler.getVehicleId()) instanceof FourWheeler);

		transaction.commit();
	}
}
