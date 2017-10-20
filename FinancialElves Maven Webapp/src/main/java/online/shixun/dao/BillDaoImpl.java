package online.shixun.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import online.shixun.model.Account;
import online.shixun.model.Bill;

@SuppressWarnings("unchecked")
@Repository("billDao")
public class BillDaoImpl implements BillDao {

	private SessionFactory sessionFactory;

	@Override
	public void addBillInfo(Bill bill) {
		sessionFactory.getCurrentSession().save(bill);
	}

	@Override
	public void updateBillInfo(Bill bill) {
		sessionFactory.getCurrentSession().merge(bill);
	}

	@Override
	public int queryBillPages(Long account_id, int incomeOrExpend) {
		List<Bill> list;
		if (incomeOrExpend == 0) {
			String hql = "from Bill where account_id=? and bill_money > 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id).list();
		} else if (incomeOrExpend == 1) {
			String hql = "from Bill where account_id=? and bill_money < 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id).list();
		} else {
			list = null;
		}
		int a = list.size();
		return a;
	}

	@Override
	public List<Bill> queryBillInfo(Long account_id, int page, int incomeOrExpend) {
		List<Bill> list;
		if (incomeOrExpend == 0) {
			String hql = "from Bill where account_id=? and bill_money > 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id).setMaxResults(10)
					.setFirstResult((page - 1) * 10).list();
		} else if (incomeOrExpend == 1) {
			String hql = "from Bill where account_id=? and bill_money < 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id).setMaxResults(10)
					.setFirstResult((page - 1) * 10).list();
		} else {
			list = null;
		}
		return list;
	}

	@Override
	public int fuzzyQueryBillPages(Long account_id, String bill_pay_type, int incomeOrExpend) {
		List<Bill> list;
		if (incomeOrExpend == 0) {
			String hql = "from Bill where account_id=? and bill_pay_type like ? and bill_money > 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id)
					.setParameter(1, "%" + bill_pay_type + "%").list();
		} else if (incomeOrExpend == 1) {
			String hql = "from Bill where account_id=? and bill_pay_type like ? and bill_money < 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id)
					.setParameter(1, "%" + bill_pay_type + "%").list();

		} else {
			list = null;
		}
		int a = list.size();
		return a;
	}

	@Override
	public List<Bill> fuzzyQueryBillInfo(Long account_id, String bill_pay_type, int page, int incomeOrExpend) {
		List<Bill> list;
		if (incomeOrExpend == 0) {
			String hql = "from Bill where account_id=? and bill_pay_type like ? and bill_money > 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id)
					.setParameter(1, "%" + bill_pay_type + "%").setMaxResults(10).setFirstResult((page - 1) * 10)
					.list();
		} else if (incomeOrExpend == 1) {
			String hql = "from Bill where account_id=? and bill_pay_type like ? and bill_money < 0 and bill_isdelete=0";
			list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, account_id)
					.setParameter(1, "%" + bill_pay_type + "%").setMaxResults(10).setFirstResult((page - 1) * 10)
					.list();
		} else {
			list = null;
		}
		return list;
	}

	@Override
	public List<Date> queryBillCreatDate(Long account_id, int incomeOrExpend) {
		Session session = sessionFactory.getCurrentSession();

		if (incomeOrExpend == 0) {
			return session
					.createQuery(
							"select bill_caertedate from Bill where bill_isdelete=0 and bill_money>0 and account_id=? group by bill_caertedate")
					.setParameter(0, account_id).list();
		} else {
			return session
					.createQuery(
							"select bill_caertedate from Bill where bill_isdelete=0 and bill_money<0 and account_id=? group by bill_caertedate")
					.setParameter(0, account_id).list();
		}

	}

	@Override
	public List<Double> queryBillMoney(Long account_id, int incomeOrExpend) {
		Session session = sessionFactory.getCurrentSession();

		if (incomeOrExpend == 0) {
			return session
					.createQuery(
							"select sum(bill_money) from Bill where bill_isdelete=0 and bill_money>0 and account_id=? group by bill_caertedate")
					.setParameter(0, account_id).list();
		} else {
			return session
					.createQuery(
							"select sum(bill_money) from Bill where bill_isdelete=0 and bill_money<0 and account_id=? group by bill_caertedate")
					.setParameter(0, account_id).list();
		}

	}

	@Override
	public List<Double> queryBillAllMoney(Long account_id) {
		Session session = sessionFactory.getCurrentSession();
		Double income = (Double) session
				.createQuery("select sum(bill_money) from Bill where bill_isdelete=0 and bill_money>0 and account_id=?")
				.setParameter(0, account_id).uniqueResult();
		List<Double> list = new ArrayList<Double>();
		Double expenditure = (Double) session
				.createQuery("select sum(bill_money) from Bill where bill_isdelete=0 and bill_money<0 and account_id=?")
				.setParameter(0, account_id).uniqueResult();
		list.add(expenditure);
		list.add(income);
		return list;
	}

	@Resource(name = "mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Bill queryBillFoId(Long bill_id) {
		Bill bill = (Bill) sessionFactory.getCurrentSession().createQuery("from Bill b where b.bill_id=?")
				.setParameter(0, bill_id).uniqueResult();
		Account account = bill.getAccount();
//		System.out.println(account);
		bill.setAccount(account);
		return bill;
	}

}
