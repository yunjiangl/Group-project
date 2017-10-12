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
 * @ClassName: Expenditure
 *
 * @Description: 支出账单实体类
 *
 * @author: 芸江
 *
 * @date 2017年10月10日 下午4:19:57
 */
@Entity
@Table(name = "expenditure", catalog = "financialElves")
public class Expenditure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expenditure_id", unique = true, nullable = false)
	private Long expenditure_id; // 支出账单的id

	@Column(name = "expenditure_money", nullable = false)
	private Double expenditure_money; // 支出的金额

	@Column(name = "expenditure_type", nullable = false)
	private String expenditure_type; // 支出的类型

	@Column(name = "expenditure_caertedate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date expenditure_caertedate; // 支出创建时间

	@Column(name = "expenditure_modifydate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date expendituret_modifydate; // 支出修改时间

	@Column(name = "expenditure_isdelete", nullable = false)
	private boolean expenditure_isdelete; // 是否删除标记

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public Long getExpenditure_id() {
		return expenditure_id;
	}

	public void setExpenditure_id(Long expenditure_id) {
		this.expenditure_id = expenditure_id;
	}

	public Double getExpenditure_money() {
		return expenditure_money;
	}

	public void setExpenditure_money(Double expenditure_money) {
		this.expenditure_money = expenditure_money;
	}

	public String getExpenditure_type() {
		return expenditure_type;
	}

	public void setExpenditure_type(String expenditure_type) {
		this.expenditure_type = expenditure_type;
	}

	public Date getExpenditure_caertedate() {
		return expenditure_caertedate;
	}

	public void setExpenditure_caertedate(Date expenditure_caertedate) {
		this.expenditure_caertedate = expenditure_caertedate;
	}

	public Date getExpendituret_modifydate() {
		return expendituret_modifydate;
	}

	public void setExpendituret_modifydate(Date expendituret_modifydate) {
		this.expendituret_modifydate = expendituret_modifydate;
	}

	public boolean isExpenditure_isdelete() {
		return expenditure_isdelete;
	}

	public void setExpenditure_isdelete(boolean expenditure_isdelete) {
		this.expenditure_isdelete = expenditure_isdelete;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Expenditure(Double expenditure_money, String expenditure_type, Date expenditure_caertedate,
			Date expendituret_modifydate, boolean expenditure_isdelete, Account account) {
		super();
		this.expenditure_money = expenditure_money;
		this.expenditure_type = expenditure_type;
		this.expenditure_caertedate = expenditure_caertedate;
		this.expendituret_modifydate = expendituret_modifydate;
		this.expenditure_isdelete = expenditure_isdelete;
		this.account = account;
	}

	public Expenditure() {

	}

}
