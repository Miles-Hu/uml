package com.demo.db.transaction.ibatis;


/**
 * @author wangtl 创建时间：2012-5-30 下午09:36:16 类说明
 */
public interface SysAdminService {

	public void update(SysAdmin sysAdmin) throws Exception;

	public void delete(Integer sysAdminId) throws Exception;

	public void updateAndDel() throws Exception;
}
