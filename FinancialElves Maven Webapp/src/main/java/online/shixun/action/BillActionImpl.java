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
	private Account account;// 用户类
	private BillService billService;// 服务类
	private int page;// 接收页码
	private int pages;// 总页码数
	private int incomeOrExpend;// 接收收入或支出类型，收入0，支出1

	@Override
	public void addAccountBillInfo() {
		billService.addBillInfo(bill, 1L);

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
		pages = billService.queryBillPages(1L, incomeOrExpend);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(Integer.toString(pages));
	}

	@Override
	public void queryAccountBillInfo() throws IOException {
		String s = billService.queryBillInfo(1L, page, incomeOrExpend);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(s);

	}

	@Override
	public void fuzzyQueryBillPages() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		pages = billService.fuzzyQueryBillPages(1L, bill.getBill_pay_type(), incomeOrExpend);
		ServletActionContext.getResponse().getWriter().write(pages);

	}

	@Override
	public void fuzzyQueryBillInfo() throws IOException {
		String s = billService.fuzzyQueryBillInfo(1L, bill.getBill_pay_type(), page, incomeOrExpend);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(s);

	}

	@Override
	public void queryBillCreateDate() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(billService.queryBillCreateDate(1L, incomeOrExpend));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void queryBillMoney() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(billService.queryBillMoney(1L, incomeOrExpend));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void queryBillAllMoney() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(billService.queryBillAllMoney(1L));
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

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
