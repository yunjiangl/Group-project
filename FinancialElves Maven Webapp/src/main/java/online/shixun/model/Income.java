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

/**
 * @ClassName: Income
 *
 * @Description: 收入账单实体类
 *
 * @author: 芸江
 *
 * @date 2017年10月10日 下午4:20:44
 */
@Entity
@Table(name = "income", catalog = "financialElves")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "income_id", unique = true, nullable = false)
	private Long income_id; // 收入账单的id

	@Column(name = "income_money", nullable = false)
	private Double income_money; // 收入的金额

	@Column(name = "eincome_type", nullable = false)
	private String income_type; // 收入的类型

	@Column(name = "income_caertedate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date income_caertedate; // 收入创建时间

	@Column(name = "income_modifydate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date income_modifydate; // 收入修改时间

	@Column(name = "income_isdelete", nullable = false)
	private boolean income_isdelete; // 是否删除标记

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public Long getIncome_id() {
		return income_id;
	}

	public void setIncome_id(Long income_id) {
		this.income_id = income_id;
	}

	public Double getIncome_money() {
		return income_money;
	}

	public void setIncome_money(Double income_money) {
		this.income_money = income_money;
	}

	public String getIncome_type() {
		return income_type;
	}

	public void setIncome_type(String income_type) {
		this.income_type = income_type;
	}

	public Date getIncome_caertedate() {
		return income_caertedate;
	}

	public void setIncome_caertedate(Date income_caertedate) {
		this.income_caertedate = income_caertedate;
	}

	public Date getIncome_modifydate() {
		return income_modifydate;
	}

	public void setIncome_modifydate(Date income_modifydate) {
		this.income_modifydate = income_modifydate;
	}

	public boolean isIncome_isdelete() {
		return income_isdelete;
	}

	public void setIncome_isdelete(boolean income_isdelete) {
		this.income_isdelete = income_isdelete;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Income(Double income_money, String income_type, Date income_caertedate, Date income_modifydate,
			boolean income_isdelete, Account account) {
		super();
		this.income_money = income_money;
		this.income_type = income_type;
		this.income_caertedate = income_caertedate;
		this.income_modifydate = income_modifydate;
		this.income_isdelete = income_isdelete;
		this.account = account;
	}

	public Income() {

	}

}
