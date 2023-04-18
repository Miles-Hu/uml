package com.demo.db.jdbctemplate;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class SysAdminServiceTest {
    private static SysAdminService sysAdminService;
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        try {
            sysAdminService = (SysAdminService) ac.getBean("sysAdminService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     */
    @Test
    public void testSave() {
//		System.out.println(sysAdminService.getClass());
//		System.out.println(sysAdminService.getClass().isInterface());
        sysAdminService.save2(new SysAdmin(-1, "d1", "a1"), ac);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        sysAdminService.update(new SysAdmin(123, "wangtl", "a"));
    }

    /**
     */
    @Test
    public void testGetSysAdmin() {
        System.out.println(sysAdminService.getSysAdmin(1));
    }

    /**
     */
    @Test
    public void testGetSysAdmins() {
        System.out.println(sysAdminService.getSysAdmins());
    }

    /**
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        sysAdminService.delete(1);
    }

    @Test
    public void updateAndDel() throws Exception {
        sysAdminService.updateAndDel();
    }

}
