package com.demo.db.transaction.jdbctemplate;

import java.util.List;
import java.util.Map;

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
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer sysAdminId) throws Exception {
		this.jdbcTemplate.update("delete from sys_admin where adminId= ? ", new Object[] { sysAdminId }, new int[] { java.sql.Types.INTEGER });
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,timeout=12)
	public SysAdmin getSysAdmin(Integer sysAdminId) {
		return (SysAdmin) this.jdbcTemplate.queryForObject("select * from sys_admin where adminId=? ", new Object[] { sysAdminId },
				new int[] { java.sql.Types.INTEGER }, new SysAdminRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<SysAdmin> getSysAdmins() {
		List<Map<String,Object>> resultList = jdbcTemplate.queryForList("select * from sys_admin");
		Map retMap = (ListOrderedMap) resultList.get(0);
		return (List<SysAdmin>)this.jdbcTemplate.query("select * from sys_admin ", new SysAdminRowMapper());
	}

	public void save(SysAdmin sysAdmin) {
		this.jdbcTemplate.update("insert into sys_admin(adminid,admin_name,password) values(?,?,?)", 
				new Object[] { sysAdmin.getAdminId(), sysAdmin.getAdminName(), sysAdmin.getPassword() },
				new int[] { java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR });
	}

	public void update(SysAdmin sysAdmin) throws Exception {
		this.jdbcTemplate.update("update sys_admin set admin_name=? where adminId= ? ", 
				new Object[] { sysAdmin.getAdminName(), sysAdmin.getAdminId() }, 
				new int[] { java.sql.Types.VARCHAR, java.sql.Types.INTEGER });
		throw new Exception();
	} 
	public void save2(SysAdmin sysAdmin, ApplicationContext ac) {
		this.jdbcTemplate.update("insert into sys_admin(adminid,admin_name,password) values(?,?,?)", 
				new Object[] { sysAdmin.getAdminId(), sysAdmin.getAdminName(), sysAdmin.getPassword() },
				new int[] { java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR });
	}

	public void updateAndDel() throws Exception {
//		SysAdmin tmp=this.getSysAdmin(1);
//		tmp.setAdminName("wangtlc");
//		this.update(tmp);
		this.delete(5);
//		throw new Exception();
	}
}
