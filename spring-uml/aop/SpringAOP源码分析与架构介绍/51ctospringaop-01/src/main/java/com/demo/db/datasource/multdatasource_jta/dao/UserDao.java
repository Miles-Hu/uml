package multdatasource_jta.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Resource
	private JdbcTemplate jdbcTemplate_user;

	public void insertUser(String id, String name) {
		jdbcTemplate_user.execute("insert into user values('" + id + "','" + name + "')");
	}
}
