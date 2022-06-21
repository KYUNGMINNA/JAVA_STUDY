package stu.Spring0620_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.user.mapper.IuserMapper;


@Service
public class UserService implements IUserService {

	@Autowired
	private IuserMapper mapper;
	@Override
	public int idCheck(String id) {
		return 0;
	}

	@Override
	public void join(UserVO vo) {

	}

	@Override
	public UserVO login(String id, String pw) {
		return null;
	}

	@Override
	public UserVO getInfo(String id) {
		return null;
	}

	@Override
	public void updateUser(UserVO vo) {

	}

	@Override
	public void deleteUser(String id, String pw) {

	}

}
