package com.demo.db.transaction.ibatis;


/**
 * @author wangtl ����ʱ�䣺2012-5-30 ����09:36:16 ��˵��
 */
public interface SysAdminService {

	public void update(SysAdmin sysAdmin) throws Exception;

	public void delete(Integer sysAdminId) throws Exception;

	public void updateAndDel() throws Exception;
}
