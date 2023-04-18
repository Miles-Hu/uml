package com.demo.db.transaction.ibatis;

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
}
