package mybatis.mapper;

import java.util.List;

import mybatis.po.User;
import mybatis.po.UserCustom;
import mybatis.po.UserQueryVo;

/**
 * @author Yu
 * @date 2017年9月6日
 * 
 *       Mapper接口，用户管理
 */
public interface UserMapper {

	// 用户综合信息查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	// 用户综合信息查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	// 根据id查询用户的信息
	public User findUserById(int id) throws Exception;

	// 根据id查询用户的信息,使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;

	// 根据用户名称模糊的查找用户信息，可能返回多条
	public List<User> findUserByName(String name) throws Exception;

	// 添加用户的信息
	public void insertUser(User user) throws Exception;

	// 删除用户的信息
	public void deleteUser(int id) throws Exception;
}
