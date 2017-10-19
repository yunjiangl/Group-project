package online.shixun.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;

import online.shixun.model.Account;
import online.shixun.model.Bill;
@Repository
public class BillDaoImp {
	private SessionFactory sessionFactory;
	@Resource(name="mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List queryBillCreateDate() {
		Session session = sessionFactory.getCurrentSession();
		Query list = session.createQuery("select bill_caertedate from Bill");
		return list.list();
	}

	public void saveBill(Account bill) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bill);
	}
	
	public List queryBillMoney() {//li
		Session session = sessionFactory.getCurrentSession();
		Query list = session.createQuery("select bill_pay_type,bill_money from Bill b order by b.bill_pay_type");
		return list.list();
	}

	public List<Double> queryBillAllMoney() {
		Session session = sessionFactory.getCurrentSession();
		Double shouru =  (Double) session.createQuery("select sum(bill_money) from Bill b where b.bill_money>0").uniqueResult();
		List<Double> list = new ArrayList<Double>();
		Double zhichu =  (Double) session.createQuery("select sum(bill_money) from Bill b where b.bill_money<0").uniqueResult();
		list.add(zhichu);
		list.add(shouru);
		return list;
	}
}
