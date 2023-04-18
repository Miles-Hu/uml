package multdatasource.demo2;

import lombok.extern.log4j.Log4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangtl 创建时间：2012-5-30 下午10:04:31 类说明
 */
@Log4j
public class MyAppTest extends Thread {
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("multdatasource/demo2/applicationContext-datasource2.xml",
			"multdatasource/demo2/applicationContext-datasource1.xml");

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			new MyAppTest().start();
		}
	}

	@Override
	public void run() {
		try {
			SysAdminServiceImpl sysAdminService1 = (SysAdminServiceImpl) ac.getBean("sysAdminService1");
			SysAdminServiceImpl2 sysAdminService2 = (SysAdminServiceImpl2) ac.getBean("sysAdminService2");

			log.info("11结果为：" + sysAdminService1.queryUserList1());
			log.info("22结果为：" + sysAdminService2.queryUserList2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
