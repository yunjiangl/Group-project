package online.shixun.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import online.shixun.dao.BillDao;
import online.shixun.model.Account;
import online.shixun.model.Bill;

@Service("billService")
public class BillServiceImpl implements BillService {

	private BillDao billDao;

	@Override
	public void addBillInfo(Bill bill, Long account_id) {
		Account account = new Account();
		account.setAccount_id(account_id);
		bill.setAccount(account);
		bill.setBill_modifydate(new Date());
		bill.setBill_caertedate(new Date());
		billDao.addBillInfo(bill);
	}

	@Override
	public void deleteBillInfo(Long bill_id) {
		Bill bill = billDao.queryBillFoId(bill_id);
		bill.setBill_isdelete(true);
		bill.setBill_modifydate(new Date());
		billDao.updateBillInfo(bill);
	}

	@Override
	public int queryBillPages(Long account_id, int incomeOrExpend) {
		int a = billDao.queryBillPages(account_id, incomeOrExpend) % 10;
		int b = billDao.queryBillPages(account_id, incomeOrExpend) / 10;
		if (a != 0) {
			b += 1;
		}
		return b;
	}

	@Override
	public String queryBillInfo(Long account_id, int page, int incomeOrExpend) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(billDao.queryBillInfo(account_id, page, incomeOrExpend));
	}

	@Override
	public int fuzzyQueryBillPages(Long account_id, String bill_pay_type, int incomeOrExpend) {
		int a = billDao.fuzzyQueryBillPages(account_id, bill_pay_type, incomeOrExpend) % 10;
		int b = billDao.fuzzyQueryBillPages(account_id, bill_pay_type, incomeOrExpend) / 10;
		if (a != 0) {
			b += 1;
		}
		return b;
	}

	@Override
	public String fuzzyQueryBillInfo(Long account_id, String bill_pay_type, int page, int incomeOrExpend) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(billDao.fuzzyQueryBillInfo(account_id, bill_pay_type, page, incomeOrExpend));
	}

	@Override
	public String queryBillMoney(Long account_id, int incomeOrExpend) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(billDao.queryBillMoney(account_id, incomeOrExpend));
	}

	@Override
	public String queryBillCreateDate(Long account_id, int incomeOrExpend) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(billDao.queryBillCreatDate(account_id, incomeOrExpend));
	}

	@Override
	public String queryBillAllMoney(Long account_id) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(billDao.queryBillAllMoney(account_id));
	}

	@Override
	public void updateBillInfo(Bill bill) {
		Bill b = billDao.queryBillFoId(bill.getBill_id());
		bill.setBill_caertedate(b.getBill_caertedate());
		bill.setBill_modifydate(new Date());
		bill.setAccount(b.getAccount());
		billDao.updateBillInfo(bill);

	}

	@Resource
	public void setbillDao(BillDao billDao) {
		this.billDao = billDao;
	}

}
