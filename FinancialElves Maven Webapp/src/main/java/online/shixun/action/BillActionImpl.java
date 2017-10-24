package online.shixun.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import online.shixun.model.Account;
import online.shixun.model.Bill;
import online.shixun.service.BillService;

@Controller
public class BillActionImpl implements BillAction {

	private Bill bill;// 账单类
//	private Account account;// 用户类
	private BillService billService;// 服务类
	private int page;// 接收页码
	private int pages;// 总页码数
	private int incomeOrExpend;// 接收收入或支出类型，收入0，支出1

	@Override
	public void addAccountBillInfo() {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		billService.addBillInfo(bill, account.getAccount_id());
	}

	@Override
	public void deleteAccountBillInfo() {
		billService.deleteBillInfo(bill.getBill_id());
	}

	@Override
	public void updateAccountBillInfo() {
		billService.updateBillInfo(bill);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write("更新账单成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void queryAccountBillPages() throws IOException {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		pages = billService.queryBillPages(account.getAccount_id(), incomeOrExpend);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(Integer.toString(pages));
	}

	@Override
	public void queryAccountBillInfo() throws IOException {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		String s = billService.queryBillInfo(account.getAccount_id(), page, incomeOrExpend);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(s);

	}

	@Override
	public void fuzzyQueryBillPages() throws IOException {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		pages = billService.fuzzyQueryBillPages(account.getAccount_id(), bill.getBill_pay_type(), incomeOrExpend);
		ServletActionContext.getResponse().getWriter().write(pages);

	}

	@Override
	public void fuzzyQueryBillInfo() throws IOException {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		String s = billService.fuzzyQueryBillInfo(account.getAccount_id(), bill.getBill_pay_type(), page, incomeOrExpend);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(s);

	}

	@Override
	public void queryBillCreateDate() {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(billService.queryBillCreateDate(account.getAccount_id(), incomeOrExpend));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void queryBillMoney() {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(billService.queryBillMoney(account.getAccount_id(), incomeOrExpend));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void queryBillAllMoney() {
		Account account = (Account)ServletActionContext.getContext().getSession().get("account");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(billService.queryBillAllMoney(account.getAccount_id()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}

	public BillService getbillService() {
		return billService;
	}

	@Resource
	public void setbillService(BillService billService) {
		this.billService = billService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getIncomeOrExpend() {
		return incomeOrExpend;
	}

	public void setIncomeOrExpend(int incomeOrExpend) {
		this.incomeOrExpend = incomeOrExpend;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
