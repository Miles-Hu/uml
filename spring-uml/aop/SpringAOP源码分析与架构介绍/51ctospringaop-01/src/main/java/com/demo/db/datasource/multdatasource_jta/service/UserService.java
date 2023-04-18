package multdatasource_jta.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.Data;
import multdatasource_jta.dao.LogDao;
import multdatasource_jta.dao.UserDao;
@Service
@Data
public class UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private LogDao logDao;

	public void saveUser(String id, String name) {
		userDao.insertUser(id, name);
//		 int i = 1 / 0; // ÷∆‘Ï“Ï≥£
		logDao.insertLog(id, id + "_" + name);
	}
}
