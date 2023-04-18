package com.demo.db.transaction.ibatis;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangtl 创建时间：2012-5-30 下午10:04:31 类说明
 */
public class SysAdminServiceTest {
	private static SysAdminServiceImpl sysAdminService;
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-事务-ibatis.xml");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			sysAdminService = (SysAdminServiceImpl) ac.getBean("sysAdminService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateAndDel() throws Exception {
		sysAdminService.updateAndDel();
	}

}
