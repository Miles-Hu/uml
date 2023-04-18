package com.demo.db.transaction.ibatisAndjdbc;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/** 
 * @author wangtl
 * 创建时间：2012-5-30 下午09:38:27 
 * 类说明 
 */
//@Transactional 
public class SysAdminServiceImpl implements SysAdminService {
	public SysAdminServiceImpl() {
		super();
	}
	@Setter
	private JdbcTemplate jdbcTemplate;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.jdbc.SysAdminService#delete(java.lang.Integer)
	 */
//	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer sysAdminId) throws Exception {
		this.jdbcTemplate.update("delete from sys_admin where adminId= ? ", new Object[] { sysAdminId }, new int[] { java.sql.Types.INTEGER });
	}

	/* (non-Javadoc)
	 * @see com.demo.jdbc.SysAdminService#getSysAdmin(java.lang.Integer)
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,timeout=12)
	public SysAdmin getSysAdmin(Integer sysAdminId) {
		return (SysAdmin) this.jdbcTemplate.queryForObject("select * from sys_admin where adminId=? ", new Object[] { sysAdminId },
				new int[] { java.sql.Types.INTEGER }, new SysAdminRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.demo.jdbc.SysAdminService#getSysAdmins()
	 */
	@SuppressWarnings("unchecked")
	public List<SysAdmin> getSysAdmins() {
		List<Map<String,Object>> resultList = jdbcTemplate.queryForList("select * from sys_admin");
		Map retMap = (ListOrderedMap) resultList.get(0);
		return (List<SysAdmin>)this.jdbcTemplate.query("select * from sys_admin ", new SysAdminRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.demo.jdbc.SysAdminService#save(com.demo.jdbc.SysAdmin)
	 */
	public void save(SysAdmin sysAdmin) {
		this.jdbcTemplate.update("insert into sys_admin(adminid,admin_name,password) values(?,?,?)", 
				new Object[] { sysAdmin.getAdminId(), sysAdmin.getAdminName(), sysAdmin.getPassword() },
				new int[] { java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR });
	}

	/* (non-Javadoc)
	 * @see com.demo.jdbc.SysAdminService#update(com.demo.jdbc.SysAdmin)
	 */
	public void update(SysAdmin sysAdmin) throws Exception {
		this.jdbcTemplate.update("update sys_admin set admin_name=? where adminId= ? ", 
				new Object[] { sysAdmin.getAdminName(), sysAdmin.getAdminId() }, 
				new int[] { java.sql.Types.VARCHAR, java.sql.Types.INTEGER });
//		throw new Exception();
	} 
	public void save2(SysAdmin sysAdmin, ApplicationContext ac) {
		this.jdbcTemplate.update("insert into sys_admin(adminid,admin_name,password) values(?,?,?)", 
				new Object[] { sysAdmin.getAdminId(), sysAdmin.getAdminName(), sysAdmin.getPassword() },
				new int[] { java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR });
	}
	@Setter
	private IbatisDao ibatisDao;
	public void updateAndDel() throws Exception {
		SysAdmin tmp=this.getSysAdmin(1);
		tmp.setAdminName("wangtlc");
		this.update(tmp);
		this.delete(2);
		ibatisDao.delete("del");
//		throw new Exception();
	}
}
