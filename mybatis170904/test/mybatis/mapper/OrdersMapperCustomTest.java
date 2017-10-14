package mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis.po.Orders;
import mybatis.po.OrdersCustom;

/** 
 * @author Yu
 * @date 2017年9月8日
 */
public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
//	@Test
//	public void testFindOrdersUser() throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建代理对象
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		//调用mapper的方法
//		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
//		System.out.println(list);
//		sqlSession.close();
//	}
	
//	@Test
//	public void testFindOrdersUserResultMap() throws Exception {
//
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		// 创建代理对象
//		OrdersMapperCustom ordersMapperCustom = sqlSession
//				.getMapper(OrdersMapperCustom.class);
//
//		// 调用maper的方法
//		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
//
//		System.out.println(list);
//
//		sqlSession.close();
//	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailUserResultMap();

		System.out.println(list);

		sqlSession.close();
	}


}
