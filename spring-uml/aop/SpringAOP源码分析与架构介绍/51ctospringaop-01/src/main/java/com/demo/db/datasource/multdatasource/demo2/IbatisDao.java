package multdatasource.demo2;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 
 */
public class IbatisDao extends SqlMapClientDaoSupport {
	static Logger logger = Logger.getLogger(IbatisDao.class);


	public int delete(String id) throws Exception {
		try {
			return this.getSqlMapClientTemplate().delete(id);
		} catch (Exception e) {
			logger.error("IbatisDao delete error:" + id, e);
			throw new Exception("IbatisDao delete error:" + id, e);
		}

	}

	public int update(String id) throws Exception {
		try {
			return this.getSqlMapClientTemplate().update(id);
		} catch (Exception e) {
			logger.error("IbatisDao update error:" + id, e);
			throw new Exception("IbatisDao update error:" + id, e);
		}

	}
	
	public List queryUserList1() throws Exception {
		try {
			return this.getSqlMapClientTemplate().queryForList("queryUserList");
		} catch (Exception e) {
			throw new Exception("IbatisDao update error:", e);
		}

	}
	public List queryUserList2() throws Exception {
		try {
			return this.getSqlMapClientTemplate().queryForList("queryUserList");
		} catch (Exception e) {
			throw new Exception("IbatisDao update error:", e);
		}

	}
}
