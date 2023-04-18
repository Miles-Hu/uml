package com.demo.db.datasource.multdatasource.demo1;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Catalog extends JdbcDaoSupport {

	public List<Item> getItems() {
		String query = "select name, price from item";
		return getJdbcTemplate().query(query, new ParameterizedRowMapper<Item>() {
			public Item mapRow(ResultSet rs, int row) throws SQLException {
				String name = rs.getString(1);
				double price = rs.getDouble(2);
				return new Item(name, price);
			}
		});
	}
}
