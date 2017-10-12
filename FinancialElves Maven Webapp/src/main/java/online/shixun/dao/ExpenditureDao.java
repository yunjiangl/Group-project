package online.shixun.dao;

import java.util.List;

import online.shixun.model.Expenditure;

/**
 * @ClassName: ExpenditureDao
 *
 * @Description: 支出账单数据库交互接口类
 *
 * 
 * @author: 芸江
 *
 * @date 2017年10月12日 下午7:54:34
 */
public interface ExpenditureDao extends BillDao<Expenditure> {

	@Override
	void addBillInfo(Expenditure expenditure);

	@Override
	void updateBillInfo(Expenditure expenditure);

	@Override
	Long fuzzyQueryBillPages(Long account_id, String expenditure_type);

	@Override
	List<Expenditure> fuzzyQueryBillInfo(Long account_id, String expenditure_type, Long page);

}
