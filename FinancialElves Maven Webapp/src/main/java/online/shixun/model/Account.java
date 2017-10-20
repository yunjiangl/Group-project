package online.shixun.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 账户实体类，类中属性对应表中字段
 * 
 * @author 芸江
 *
 * @date 2017年10月10日 下午4:19:57
 */
@Entity
@Table(name = "account", catalog = "financialElves")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Long account_id; // 账户的id唯一标识符

	@Column(name = "account_username", nullable = false, unique = true)
	private String account_username; // 登录用户名，不可重复

	@Column(name = "account_password", nullable = false)
	private String account_password; // 登录密码

	@Column(name = "account_loginCount", nullable = false)
	private int account_loginCount; // 用户登录次数

	@Column(name = "account_email", nullable = false)
	private String account_email; // 联系邮箱

	@Column(name = "account_gender", nullable = false)
	private String account_gender; // 用户性别

	private String account_career; // 用户职业

	private String account_hobbies; // 用户爱好

	@Column(name = "account_caertedate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date account_caertedate; // 用户创建时间

	@Column(name = "account_modifydate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date account_modifydate; // 用户修改时间

	@Column(name = "account_isdelete", nullable = false)
	private boolean account_isdelete; // 是否删除标记

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Bill> bill;

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public String getAccount_username() {
		return account_username;
	}

	public void setAccount_username(String account_username) {
		this.account_username = account_username;
	}

	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}

	public int getAccount_loginCount() {
		return account_loginCount;
	}

	public void setAccount_loginCount(int account_loginCount) {
		this.account_loginCount = account_loginCount;
	}

	public String getAccount_email() {
		return account_email;
	}

	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}

	public String getAccount_gender() {
		return account_gender;
	}

	public void setAccount_gender(String account_gender) {
		this.account_gender = account_gender;
	}

	public String getAccount_career() {
		return account_career;
	}

	public void setAccount_career(String account_career) {
		this.account_career = account_career;
	}

	public String getAccount_hobbies() {
		return account_hobbies;
	}

	public void setAccount_hobbies(String account_hobbies) {
		this.account_hobbies = account_hobbies;
	}

	public Date getAccount_caertedate() {
		return account_caertedate;
	}

	public void setAccount_caertedate(Date account_caertedate) {
		this.account_caertedate = account_caertedate;
	}

	public Date getAccount_modifydate() {
		return account_modifydate;
	}

	public void setAccount_modifydate(Date account_modifydate) {
		this.account_modifydate = account_modifydate;
	}

	public boolean isAccount_isdelete() {
		return account_isdelete;
	}

	public void setAccount_isdelete(boolean account_isdelete) {
		this.account_isdelete = account_isdelete;
	}

	public Set<Bill> getBill() {
		return bill;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}

	public Account(String account_username, String account_password, int account_loginCount, String account_email,
			String account_gender, String account_career, String account_hobbies, Date account_caertedate,
			Date account_modifydate, boolean account_isdelete, Set<Bill> bill) {
		super();
		this.account_username = account_username;
		this.account_password = account_password;
		this.account_loginCount = account_loginCount;
		this.account_email = account_email;
		this.account_gender = account_gender;
		this.account_career = account_career;
		this.account_hobbies = account_hobbies;
		this.account_caertedate = account_caertedate;
		this.account_modifydate = account_modifydate;
		this.account_isdelete = account_isdelete;
		this.bill = bill;
	}

	public Account() {

	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_username=" + account_username + ", account_password="
				+ account_password + ", account_loginCount=" + account_loginCount + ", account_email=" + account_email
				+ ", account_gender=" + account_gender + ", account_career=" + account_career + ", account_hobbies="
				+ account_hobbies + ", account_caertedate=" + account_caertedate + ", account_modifydate="
				+ account_modifydate + ", account_isdelete=" + account_isdelete + ", bill=" + bill + "]";
	}

	
}
