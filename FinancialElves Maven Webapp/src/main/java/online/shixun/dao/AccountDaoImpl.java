package online.shixun.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import online.shixun.model.Account;


@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@Resource(name = "mySessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 查询所有用户
	 */
	@Override
	public Account queryAccountInfo(String username) {
		// 1.获取session
		Session session = sessionFactory.getCurrentSession();
		// 2.执行查询
		Account account = (Account) session.createQuery("from Account a where a.account_username= ? ")
				.setParameter(0, username).uniqueResult();
		return account;
	}

	@Override
	public void updateAccountInfo(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.update(account);
	}

	/**
	 * 用户注册
	 */
	@Override
	public void addAccountInfo(Account account) {
		// 1.获取session
		Session session = sessionFactory.getCurrentSession();
		session.save(account);

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
