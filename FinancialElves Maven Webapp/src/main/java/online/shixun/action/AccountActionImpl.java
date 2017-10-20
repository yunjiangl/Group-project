package online.shixun.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import online.shixun.model.Account;
import online.shixun.service.AccountService;

@Controller
public class AccountActionImpl implements AccountAction {

	@Resource
	private AccountService accountService;

	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void doLogin() {

	}

	/**
	 * 用户名是否已存在
	 * 
	 * 先查询出账户类数据库中的所有账户，用于和用户输入的账户进行匹配 如果匹配成功，说明账户已存在，注册失败，反则成功
	 */
	@Override
	public void usernameIsRepeat() {
		HttpServletResponse hsr = ServletActionContext.getResponse();

		// 根据用户名称查询到用户信息
		Account accounts = accountService.queryAccountInfo(account.getAccount_username());
		// 将查询到的账户名称进行匹配，匹配成功则登录成功，反则失败

		// 用户名已存在
		if (accounts != null) {
			try {
				hsr.getWriter().write("no");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				hsr.getWriter().write("yes");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 用户注册
	 */
	@Override
	public void doRegistered() {
		// 新增用户
		accountService.addAccountInfo(account);
	}

	public void setaccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void loginOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void breakUsername() {
		// TODO Auto-generated method stub

	}

}
