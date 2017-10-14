package mybatis.dao;

import mybatis.po.User;

/** 
 * @author Yu
 * @date 2017年9月6日
 * 
 * Dao接口，用户管理
 */
public interface UserDao {

	// 根据id查询用户的信息
	public User findUserById(int id) throws Exception;
	// 添加用户的信息
	public void insertUser(User user) throws Exception;
	// 删除用户的信息
	public void deleteUser(int id) throws Exception;
}
