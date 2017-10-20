package online.shixun.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import online.shixun.dao.BillDaoImp;
import online.shixun.model.Account;
import online.shixun.model.Bill;

@Service
public class BillServiceImp {
	
	private BillDaoImp billDao;
	@Resource(name="billDaoImp")
	public void setBillDao(BillDaoImp billDao) {
		this.billDao = billDao;
	}

	public String queryBillCreateDate() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(billDao.queryBillCreateDate());
	}
	
	public void querytest(Account account){
		billDao.saveBill(account);
	}
	
	public String queryBillMoney() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(billDao.queryBillMoney());
	}

	public String queryBillAllMoney() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(billDao.queryBillAllMoney());
	}
}
