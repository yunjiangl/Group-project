package online.shixun.dao;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: BillDao
 *
 * @Description: 账单数据库交互接口类
 *
 * @author: 芸江
 *
 * @date 2017年10月12日 下午9:28:36
 */
public interface BillDao<Bill> {

	/**
	 * 新增一条账单信息
	 * 
	 * <p>
	 * 向数据库中新增一条账单记录
	 * </p>
	 * 
	 * @param bill
	 *            账单实体类对象
	 */
	void addBillInfo(Bill bill);

	/**
	 * 修改收入账单信息
	 * 
	 * @param bill
	 *            账单实体类对象，已经修改了相应的信息
	 */
	void updateBillInfo(Bill bill);

	/**
	 * 查询账单信息记录总数
	 * 
	 * <p>
	 * 查询数据库中与某个用户关联的所有的账单信息记录总数
	 * </p>
	 * 
	 * @param account_id
	 *            用户id
	 * @return 所查询到的记录总数
	 */
	Long queryBillPages(Long account_id);

	/**
	 * 查询某页账单的信息（每页显示10条数据）
	 * 
	 * @param account_id
	 *            用户id
	 * @param page
	 *            所要查询的页数
	 * @return 账单实体类集合
	 */
	List<Bill> queryBillInfo(Long account_id, Long page);

	/**
	 * 模糊查询账单记录的总数
	 * 
	 * <p>
	 * 以账单的消费（收入）类型，模糊查询与用户关联的账单总数
	 * </p>
	 * 
	 * @param account_id
	 *            用户id
	 * @param incomeOrExpenditure_type
	 *            账单的消费（收入）类型
	 * @return 查询到的总数
	 */
	Long fuzzyQueryBillPages(Long account_id, String incomeOrExpenditure_type);

	/**
	 * 模糊查询账单的某页数据（每页10条数据）
	 * 
	 * @param account_id
	 *            用户id
	 * @param incomeOrExpenditure_type
	 *            账单的消费（收入）类型
	 * @param page
	 *            所要查询的页面
	 * @return 账单实体类集合
	 */
	List<Bill> fuzzyQueryBillInfo(Long account_id, String incomeOrExpenditure_type, Long page);

	/**
	 * 查询账单创建日期（过滤重复）
	 * 
	 * <p>
	 * 查询与用户关联的账单创建日期集合
	 * </p>
	 * 
	 * @param accouent_id
	 *            用户id
	 * @return Date 集合
	 */
	List<Date> queryBillCreatDate(Long account_id);

	/**
	 * 分组查询收入账单金额
	 * 
	 * <p>
	 * 以账单创建时间为条件，分组查询与用户关联的收入账单金额总数
	 * </p>
	 * 
	 * @param account_id
	 *            用户id
	 * @return 分组之后的收入金额集合
	 */
	List<Double> queryIncomeMoney(Long account_id);
}
