package mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.po.User;

/**
 * @author Yu
 * @date 2017年9月6日
 */
public class UserDaoImplement implements UserDao {

	// 需要向Dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImplement(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlssession = sqlSessionFactory.openSession();
		User user = sqlssession.selectOne("test.findUserById", id);
		// 释放资源
		sqlssession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlssession = sqlSessionFactory.openSession();
		sqlssession.insert("test.insertUser", user);

		// 提交事物
		sqlssession.commit();
		// 释放资源
		sqlssession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlssession = sqlSessionFactory.openSession();
		sqlssession.delete("test.deleteUser", id);

		// 提交事物
		sqlssession.commit();
		// 释放资源
		sqlssession.close();
	}

}
