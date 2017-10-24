package online.shixun.service;

import online.shixun.model.Account;

/**
 * @ClassName: AccountService
 *
 * @Description: 用户服务接口类
 *
 * @author: 芸江
 *
 * @date 2017年10月10日 下午5:04:31
 */
public interface AccountService {

	/**
	 * 用户登录
	 * 
	 * <p>
	 * 对用户输入输入进行判断，
	 * <p>
	 * 当用户输入密码错误时（当用户名正确，登录密码错误时）对用户登录错误次数做增加操作
	 * </p>
	 * <p>
	 * 当用户登录成功时，用户登录错误次数清零
	 * </p>
	 * </p>
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            登陆密码
	 * @return 返回"0"登录成功，返回"1"密码错误5次，不能进行灯，返回"2"没有登录成功
	 */
	String accountLogin(String username, String password);

	/**
	 * 更新用户信息
	 * 
	 * @param account
	 *            已经更新相关信息的Account对象
	 *            <p>
	 *            传入的实例应该为修改了相应信息的Account对象，在此方法中将用户修改时间设置为当前时间
	 *            </p>
	 */
	void updateAccountInfo(Account account);

	/**
	 * 新增用户
	 * 
	 * @param account
	 *            Account 对象
	 *            <p>
	 *            在此方法中将用户创建，修改时间设置为当前时间，是否删除标记设置为false，登录错误次数为0
	 *            </p>
	 */
	void addAccountInfo(Account account);

	/**
	 * 删除用户
	 * 
	 * @param account
	 *            Account 对象
	 *            <p>
	 *            在此方法中，将用户的是否删除标记设置为true，修改时间设置为当前时间，然后更新用户信息，达到删除用户的效果
	 *            </p>
	 */
	void deleteAccountInfo(Account account);

	/**
	 * 查询用户信息
	 * 
	 * @param username
	 *            用户名，用来查询用户信息
	 * @return Account对象，返回null表示没有查找到相应的用户信息
	 */
	Account queryAccountInfo(String username);
}
