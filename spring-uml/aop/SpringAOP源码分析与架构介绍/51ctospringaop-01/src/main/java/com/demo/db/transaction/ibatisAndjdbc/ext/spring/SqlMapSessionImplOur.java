/*
 *  Copyright 2004 Clinton Begin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.demo.db.transaction.ibatisAndjdbc.ext.spring;

import java.sql.SQLException;
import java.util.List;

import lombok.extern.log4j.Log4j;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapSessionImpl;

/**
 * Implementation of SqlMapSession
 */
@Log4j
public class SqlMapSessionImplOur extends SqlMapSessionImpl {

	public SqlMapSessionImplOur(SqlMapClientImpl client) {
		super(client);
	}

	public List queryForList(String id, Object paramObject) throws SQLException {
		long start = System.currentTimeMillis();

		List result = super.queryForList(id, paramObject);
		
		log.info("进入JDBC进行监控");
		return result;
	}

	@Override
	public Object insert(String id, Object param) throws SQLException {
		long start = System.currentTimeMillis();
		Object result = super.insert(id, param);

		return result;
	}

	@Override
	public int update(String id, Object param) throws SQLException {
		long start = System.currentTimeMillis();
		int result = super.update(id, param);

		return result;
	}

	@Override
	public int delete(String id, Object param) throws SQLException {
		long start = System.currentTimeMillis();
		int result = super.delete(id, param);

		return result;
	}

}
