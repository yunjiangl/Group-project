package online.shixun.dao;

import java.util.List;

import online.shixun.model.Income;

/**
 * @ClassName: IncomeDao
 *
 * @Description: 收入账单数据库接口类
 *
 * 
 * @author: 芸江
 *
 * @date 2017年10月12日 下午7:14:10
 */
public interface IncomeDao extends BillDao<Income> {

	@Override
	void addBillInfo(Income income);

	@Override
	void updateBillInfo(Income income);

	@Override
	Long fuzzyQueryBillPages(Long account_id, String income_type);

	@Override
	List<Income> fuzzyQueryBillInfo(Long account_id, String income_type, Long page);

}
