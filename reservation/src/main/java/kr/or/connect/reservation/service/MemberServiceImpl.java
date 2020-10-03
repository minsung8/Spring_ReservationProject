package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;

public class MemberServiceImpl implements MemberService {
	
	

	@Override
	public UserEntity getUser(String loginUserId) {
        return new UserEntity("carami", "$2a$10$G/ADAGLU3vKBd62E6GbrgetQpEKu2ukKgiDR5TWHYwrem0cSv6Z8m");
	}

	@Override
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
