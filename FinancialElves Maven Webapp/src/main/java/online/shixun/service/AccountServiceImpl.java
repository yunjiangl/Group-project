package online.shixun.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import online.shixun.dao.AccountDao;
import online.shixun.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	@Override
	public String accountLogin(String username, String password) {
		Account account = accountDao.queryAccountInfo(username);
		String result = null;
		// 账户存在
		if (account != null) {
			// 错误次数
			int account_loginCount = account.getAccount_loginCount();
			// 错误次数小于5
			if (account_loginCount <= 5) {
				// 密码正确,
				if (password.equals(account.getAccount_password())) {
					// 错误次数归0，传入数据库(登陆成功)
					account.setAccount_loginCount(0);
					accountDao.updateAccountInfo(account);
					result = "0";
					// 密码错误
				} else {
					// 增加错误次数，传入数据库(密码或账户错误)
					account.setAccount_loginCount(account_loginCount + 1);
					accountDao.updateAccountInfo(account);
					result = "2";
				}
				// 错误次数大于5，账号锁定
			} else {
				result = "1";
			}
			// 账户不存在
		} else {

		}
		return result;
	}

	@Override
	public void updateAccountInfo(Account account) {

	}

	/**
	 * 用户注册
	 */
	@Override
	public void addAccountInfo(Account account) {
		account.setAccount_caertedate(new Date());
		account.setAccount_modifydate(new Date());
		accountDao.addAccountInfo(account);

	}

	@Override
	public void deleteAccountInfo(Account account) {
		// TODO Auto-generated method stub

	}

	/**
	 * 查询账户信息
	 */
	@Override
	public Account queryAccountInfo(String username) {
		Account account = accountDao.queryAccountInfo(username);
		System.out.println("查询成功！" + account);
		return account;
	}

	public void setaccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
