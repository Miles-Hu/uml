package com.demo.db.transaction.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;

public interface SysAdminService {
	public void save(SysAdmin sysAdmin);

	public void save2(SysAdmin sysAdmin, ApplicationContext ac);

	public void update(SysAdmin sysAdmin)throws Exception;

	public SysAdmin getSysAdmin(Integer sysAdminId);

	public List<SysAdmin> getSysAdmins();

	public void delete(Integer sysAdminId) throws Exception;

	public void updateAndDel() throws Exception;
}
