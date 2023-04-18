package com.demo.db.transaction.ibatisAndjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;

/**
 * @author wangtl ����ʱ�䣺2012-5-30 ����09:36:16 ��˵��
 */
public interface SysAdminService {
	public void save(SysAdmin sysAdmin);

	public void save2(SysAdmin sysAdmin, ApplicationContext ac);

	public void update(SysAdmin sysAdmin)throws Exception;

	public SysAdmin getSysAdmin(Integer sysAdminId);

	public List<SysAdmin> getSysAdmins();

	public void delete(Integer sysAdminId) throws Exception;

	public void updateAndDel() throws Exception;
}
