package com.demo.db.transaction.jdbcIbatisHibernate.hibernate;

import com.demo.db.transaction.jdbcIbatisHibernate.SysAdmin;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 */
public class HibernateDaoImpl extends HibernateDaoSupport {


	public void addUser(SysAdmin sysAdmin) throws Exception {
		this.getHibernateTemplate().save(sysAdmin);
	}
}
