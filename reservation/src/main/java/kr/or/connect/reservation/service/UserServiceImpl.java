package kr.or.connect.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.User;
import kr.or.connect.reservation.dto.UserRole;
import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	private final UserRoleDao userRolesDao;
	
	public UserServiceImpl(UserDao userDao, UserRoleDao userRolesDao) {
		this.userDao = userDao;
		this.userRolesDao = userRolesDao;
	}

	@Override
	@Transactional
	public UserEntity getUser(String loginUserId) {
		User user = userDao.getUserByEmail(loginUserId);
		System.out.println(loginUserId);
		return new UserEntity(user.getEmail(), user.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		List<UserRole> userRoles = userRolesDao.getRolesByEmail(loginUserId);
		List<UserRoleEntity> list = new ArrayList<>();
		
		for (UserRole userRole : userRoles) {
			list.add(new UserRoleEntity(loginUserId, userRole.getRoleName()));
		}
		return list;
	}

}
