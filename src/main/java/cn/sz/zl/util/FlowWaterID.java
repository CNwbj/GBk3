package cn.sz.zl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlowWaterID {
	private static String getBody(Integer id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		return sdf.format(new Date())+String.format("%06d", id);
	}
}
