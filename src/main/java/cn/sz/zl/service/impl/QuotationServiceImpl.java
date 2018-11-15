package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IQuotationDAO;
import cn.sz.zl.pojo.Quotation;
import cn.sz.zl.service.IQuotationService;
import cn.sz.zl.util.MFenYe;
import cn.sz.zl.util.Query;
@Service
public class QuotationServiceImpl implements IQuotationService {
	@Autowired
	private IQuotationDAO qd;
	@Override
	public Quotation findQuotationById(Integer quotationid) {
		// TODO Auto-generated method stub
		return qd.findQuotationById(quotationid);
	}

	@Override
	public List<Quotation> findAllQuotation() {
		// TODO Auto-generated method stub
		return qd.findAllQuotation();
	 }

	@Override
	public List<Quotation> queryQuotationByFy(MFenYe fy) {
		if(fy.getPage()==null) {
			fy.setPage(1);
		}
		fy.setRowCount(qd.queryRowsByQuery(fy.getQuery()));
		return qd.queryQuotationByFy(fy);
	}

	@Override
	public Integer queryRowsByQuery(Query query) {
		
		return qd.queryRowsByQuery(query);
	}

	@Override
	public boolean UpdateQuotation(Quotation quotation) {
		return qd.UpdateQuotation(quotation);
	}

	@Override
	public boolean insertQuotation(Quotation quotation) {
		return qd.insertQuotation(quotation);
	}

	@Override
	public boolean deleteQuotation(Integer quotationid) {
		// TODO Auto-generated method stub
		return qd.deleteQuotation(quotationid);
	}

	@Override
	public boolean updateTJStateById(Integer quotationid) {
		// TODO Auto-generated method stub
		return qd.updateTJStateById(quotationid);
	}

	@Override
	public boolean updateSHStateById(Integer quotationid) {
		// TODO Auto-generated method stub
		return qd.updateSHStateById(quotationid);
	}

}
