package by.itacademy.mhl.service.impl;

import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.dao.AuthDao;
import by.itacademy.mhl.dao.DaoException;
import by.itacademy.mhl.dao.DaoFactory;
import by.itacademy.mhl.dao.impl.FileAuthDao;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.validation.UserDataValidator;

public class LoginServiceImpl implements LoginService {

	@Override
	public String logination(String login, String password) throws ServiceException {
		if (!UserDataValidator.checkAuthData(login, password)) {
			throw new ServiceException("Wrong login or password!!!");
		}

		DaoFactory daoFactory;
		AuthDao authDao;
		String role = null;

		try {
			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			role = authDao.authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		if (role == null) {
			throw new ServiceException("Wrong login or password!!!");
		}

		return role;
	}

	@Override
	public void registration(UserInfo user) {
		// TODO Auto-generated method stub

	}

}
