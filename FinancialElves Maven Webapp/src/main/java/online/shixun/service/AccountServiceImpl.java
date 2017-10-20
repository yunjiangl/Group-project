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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccountInfo(Account account) {
		// TODO Auto-generated method stub

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
