package mybatis.mapper;
/** 
 * @author Yu
 * @date 2017年9月8日
 * 
 * 订单mapper
 */

import java.util.List;

import mybatis.po.Orders;
import mybatis.po.OrdersCustom;

public interface OrdersMapperCustom {
	// 查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser() throws Exception;

	// 查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap() throws Exception;

	// 查询订单关联查询用户及订单明细使用resultMap
	public List<Orders> findOrdersAndOrderDetailUserResultMap() throws Exception;

}
