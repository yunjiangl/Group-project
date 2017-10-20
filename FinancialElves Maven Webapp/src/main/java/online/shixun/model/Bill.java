package online.shixun.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

/**
 * @ClassName: Income
 *
 * @Description: 账单实体类
 *
 * @author: 芸江
 *
 * @date 2017年10月10日 下午4:20:44
 */
@Entity
@Table(name = "bill", catalog = "financialElves")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id", unique = true, nullable = false)
	@Expose
	private Long bill_id; // 账单的id

	@Column(name = "bill_money", nullable = false)
	@Expose
	private Double bill_money; // 账单的金额

	@Column(name = "bill_pay_type", nullable = false)
	@Expose
	private String bill_pay_type; // 账单的消费（收入类型）的类型

	@Column(name = "bill_caertedate", nullable = false)
	@Temporal(TemporalType.DATE)
	@Expose
	private Date bill_caertedate; // 创建时间

	@Column(name = "bill_modifydate", nullable = false)
	@Temporal(TemporalType.DATE)
	@Expose
	private Date bill_modifydate; // 修改时间

	@Column(name = "bill_isdelete", nullable = false)
	@Expose
	private boolean bill_isdelete; // 是否删除标记

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}

	public Double getBill_money() {
		return bill_money;
	}

	public void setBill_money(Double bill_money) {
		this.bill_money = bill_money;
	}

	public String getBill_pay_type() {
		return bill_pay_type;
	}

	public void setBill_pay_type(String bill_pay_type) {
		this.bill_pay_type = bill_pay_type;
	}

	public Date getBill_caertedate() {
		return bill_caertedate;
	}

	public void setBill_caertedate(Date bill_caertedate) {
		this.bill_caertedate = bill_caertedate;
	}

	public Date getBill_modifydate() {
		return bill_modifydate;
	}

	public void setBill_modifydate(Date bill_modifydate) {
		this.bill_modifydate = bill_modifydate;
	}

	public boolean isBill_isdelete() {
		return bill_isdelete;
	}

	public void setBill_isdelete(boolean bill_isdelete) {
		this.bill_isdelete = bill_isdelete;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Bill(Double bill_money, String bill_pay_type, Date bill_caertedate, Date bill_modifydate,
			boolean bill_isdelete, Account account) {
		super();
		this.bill_money = bill_money;
		this.bill_pay_type = bill_pay_type;
		this.bill_caertedate = bill_caertedate;
		this.bill_modifydate = bill_modifydate;
		this.bill_isdelete = bill_isdelete;
		this.account = account;
	}

	public Bill() {

	}

}
