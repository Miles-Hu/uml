package com.demo.db.datasource.multdatasource.demo1;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CatalogTests extends AbstractJUnit4SpringContextTests {

	private Catalog catalog;

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public void testDataSourceRouting() {
		CustomerContextHolder.setCustomerType("MASTER");
		List<Item> goldItems = catalog.getItems();
		assertEquals(1, goldItems.size());
		System.out.println("gold items: " + goldItems);

		CustomerContextHolder.setCustomerType("SLAVE");
		List<Item> silverItems = catalog.getItems();
		assertEquals(1, silverItems.size());
		System.out.println("silver items: " + silverItems);

		CustomerContextHolder.clearCustomerType();
		List<Item> bronzeItems = catalog.getItems();
		assertEquals(1, bronzeItems.size());
		System.out.println("bronze items: " + bronzeItems);
	}

	protected String[] getConfigLocations() {
		return new String[] { "/multdatasource/demo1/applicationContext.xml" };
	}
}
