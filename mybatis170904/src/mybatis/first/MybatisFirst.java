package mybatis.first;
/** 
 * @author Yu
 * @date 2017年9月5日
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.po.User;

public class MybatisFirst {

	// // 根据id查询用户信息，得到一条用户记录结果
	// @Test
	// public void findUserByIdTest() throws IOException {
	//
	// // mybatis配置文件
	// String resource = "SqlMapConfig.xml";
	// // 得到配置文件流
	// InputStream inputStream = Resources.getResourceAsStream(resource);
	// // 创建会话工厂，传入mybatis的配置信息
	// SqlSessionFactory sqlSessionFactory = new
	// SqlSessionFactoryBuilder().build(inputStream);
	// // 通过工厂得到SqlSession
	// SqlSession sqlssession = sqlSessionFactory.openSession();
	//
	// // 通过SqlSession操作数据库
	// // 第一个参数：映射文件中的statement的id，等于namespace+"."+statement的id
	// // 第二个参数：指定与映射文件中相匹配的parameterType类型的参数
	// // sqlssession.selectOne的结果是映射文件中所匹配的resultType类型的对象
	// User user = sqlssession.selectOne("test.findUserById", 1);
	// System.out.println(user);
	//
	// // 释放资源
	// sqlssession.close();
	// }

	// // 根据用户名称模糊的查找用户信息
	// @Test
	// public void findUserByNameTest() throws IOException {
	//
	// // mybatis配置文件
	// String resource = "SqlMapConfig.xml";
	// // 得到配置文件流
	// InputStream inputStream = Resources.getResourceAsStream(resource);
	// // 创建会话工厂，传入mybatis的配置信息
	// SqlSessionFactory sqlSessionFactory = new
	// SqlSessionFactoryBuilder().build(inputStream);
	// // 通过工厂得到SqlSession
	// SqlSession sqlssession = sqlSessionFactory.openSession();
	//
	// // 通过SqlSession操作数据库
	// // 第一个参数：映射文件中的statement的id，等于namespace+"."+statement的id
	// // 第二个参数：指定与映射文件中相匹配的parameterType类型的参数
	// // sqlssession.selectOne的结果是映射文件中所匹配的resultType类型的对象
	// List<User> list = sqlssession.selectList("test.findUserByName", "小明");
	// System.out.println(list);
	//
	// // 释放资源
	// sqlssession.close();
	// }

	// // 添加用户信息
	// @Test
	// public void insertUserTest() throws IOException {
	//
	// // mybatis配置文件
	// String resource = "SqlMapConfig.xml";
	// // 得到配置文件流
	// InputStream inputStream = Resources.getResourceAsStream(resource);
	// // 创建会话工厂，传入mybatis的配置信息
	// SqlSessionFactory sqlSessionFactory = new
	// SqlSessionFactoryBuilder().build(inputStream);
	// // 通过工厂得到SqlSession
	// SqlSession sqlssession = sqlSessionFactory.openSession();
	//
	// // 通过SqlSession操作数据库
	// // 第一个参数：映射文件中的statement的id，等于namespace+"."+statement的id
	// // 第二个参数：指定与映射文件中相匹配的parameterType类型的参数
	// // sqlssession.selectOne的结果是映射文件中所匹配的resultType类型的对象
	//
	// User user = new User();
	// user.setUsername("刘备");
	// user.setAddress("广东中山");
	// user.setBirthday(new Date());
	// user.setSex("1");
	// sqlssession.insert("test.insertUser", user);
	//
	// // 提交事物
	// sqlssession.commit();
	//
	// // 获取用户新增的信息主键
	// System.out.println(user.getId());
	// // 释放资源
	// sqlssession.close();
	// }

	// // 删除用户信息
	// @Test
	// public void deleteUserTest() throws IOException {
	//
	// // mybatis配置文件
	// String resource = "SqlMapConfig.xml";
	// // 得到配置文件流
	// InputStream inputStream = Resources.getResourceAsStream(resource);
	// // 创建会话工厂，传入mybatis的配置信息
	// SqlSessionFactory sqlSessionFactory = new
	// SqlSessionFactoryBuilder().build(inputStream);
	// // 通过工厂得到SqlSession
	// SqlSession sqlssession = sqlSessionFactory.openSession();
	// // 传入id删除用户
	// sqlssession.delete("test.deleteUser", 33);
	//
	// // 提交事物
	// sqlssession.commit();
	// // 释放资源
	// sqlssession.close();
	// }

	// 更新用户信息
	@Test
	public void updateUserTest() throws IOException {

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlssession = sqlSessionFactory.openSession();
		 User user = new User();
		 user.setId(31);
		 user.setUsername("刘大大备");
		 user.setAddress("广东广州");
		 user.setBirthday(new Date());
		 user.setSex("2");
		 sqlssession.update("test.updateUser", user);

		// 提交事物
		sqlssession.commit();
		// 释放资源
		sqlssession.close();
	}
}
