package online.shixun.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import online.shixun.model.Bill;
import online.shixun.service.BillServiceImp;
@Controller
public class BillActionImp {
	
	private BillServiceImp billService;
	
	@Resource(name = "billServiceImp")
	public void setBillService(BillServiceImp billService) {
		this.billService = billService;
	}


	public void queryBillCreateDate() {//li
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw =  response.getWriter();
			pw.write(billService.queryBillCreateDate());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public void queryBillMoney() {//li
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw =  response.getWriter();
			pw.write(billService.queryBillMoney());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void queryBillAllMoney() {//li
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		try {
			PrintWriter pw =  response.getWriter();
			pw.write(billService.queryBillAllMoney());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
