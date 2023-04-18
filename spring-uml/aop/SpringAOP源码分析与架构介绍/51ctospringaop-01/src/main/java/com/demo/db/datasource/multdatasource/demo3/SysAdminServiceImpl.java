package com.demo.db.datasource.multdatasource.demo3;

import java.util.List;

import lombok.Setter;

/** 
 * @author wangtl
 * 创建时间：2012-5-30 下午09:38:27 
 * 类说明 
 */
//@Transactional 
public class SysAdminServiceImpl  {
	public SysAdminServiceImpl() {
		super();
	}
	@Setter
	private IbatisDao ibatisDao;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.jdbc.SysAdminService#delete(java.lang.Integer)
	 */
//	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer sysAdminId) throws Exception {
		ibatisDao.delete("del");
//		throw new Exception();
	}


	/* (non-Javadoc)
	 * @see com.demo.jdbc.SysAdminService#update(com.demo.jdbc.SysAdmin)
	 */
	public void update(SysAdmin sysAdmin) throws Exception {
		ibatisDao.update("update");
	} 

	public void updateAndDel() throws Exception {
		this.delete(2);
		this.update(null);
	}


	public List queryUserList1(int src) throws Exception {
		return ibatisDao.queryUserList1(src);
	}
	
	public List queryUserListA() throws Exception {
		queryUserListB();
		return ibatisDao.queryUserList1(1);
	}
	public List queryUserListB() throws Exception {
		return ibatisDao.queryUserList1(2);
	}
}
