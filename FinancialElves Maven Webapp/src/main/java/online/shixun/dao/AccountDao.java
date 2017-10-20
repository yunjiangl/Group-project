package online.shixun.dao;

import online.shixun.model.Account;

/**
 * @ClassName: AccountDao
 *
 * @Description: 用户数据库交互接口类
 *
 * @author: 芸江
 *
 * @date 2017年10月10日 下午4:40:51
 */
public interface AccountDao {

	/**
	 * 查询用户信息
	 * 
	 * <p>
	 * 通过用户名查询数据库中的用户信息
	 * </p>
	 * 
	 * @param username
	 *            用户名
	 * @return Account 对象实例，返回null表示没有查询到相关信息
	 */
	Account queryAccountInfo(String username);

	/**
	 * 修改用户信息
	 * 
	 * <p>
	 * 通过传入的参数，修改相应的用户信息
	 * </p>
	 * 
	 * @param account
	 *            Account 对象实例
	 */
	void updateAccountInfo(Account account);

	/**
	 * 新增用户信息
	 * 
	 * <p>
	 * 通过传入的参数，向数据库中添加一条用户信息
	 * </p>
	 * 
	 * @param account
	 *            Account 对象实例
	 */
	void addAccountInfo(Account account);

}
