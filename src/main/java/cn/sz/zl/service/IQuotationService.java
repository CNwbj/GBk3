package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.Quotation;
import cn.sz.zl.util.MFenYe;
import cn.sz.zl.util.Query;

public interface IQuotationService {
	//根据id编号查询报价单
	public Quotation findQuotationById(Integer quotationid);
	//查询所有的报价单
	public List<Quotation> findAllQuotation();
	//多条件分页查询
	public List<Quotation> queryQuotationByFy(MFenYe fy);
	//查询符合要求的条数
	public Integer queryRowsByQuery(Query query);
	//修改
	public boolean  UpdateQuotation(Quotation quotation);
	//添加
	public boolean insertQuotation(Quotation quotation);
	//删除
	public boolean deleteQuotation(Integer quotationid);
	public boolean updateTJStateById(Integer quotationid);
	public boolean updateSHStateById(Integer quotationid);
}
