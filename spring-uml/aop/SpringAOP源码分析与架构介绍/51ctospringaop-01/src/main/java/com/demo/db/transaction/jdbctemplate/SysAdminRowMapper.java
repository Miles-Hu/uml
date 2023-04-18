package com.demo.db.transaction.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/** 
 * @author wangtl
 * 创建时间：2012-5-30 下午09:54:26 
 * 类说明 
 */
public class SysAdminRowMapper implements RowMapper {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		SysAdmin sysAdmin=new SysAdmin();
		sysAdmin.setAdminId(rs.getInt("adminId"));
		sysAdmin.setAdminName(rs.getString("ADMIN_NAME"));
		sysAdmin.setPassword(rs.getString("PASSWORD"));
		return sysAdmin;
	}

}
