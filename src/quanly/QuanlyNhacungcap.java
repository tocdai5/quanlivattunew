package quanly;

import java.util.List;

import model.Nhacungcap;
import dao.NhacungcapHome;

public class QuanlyNhacungcap {
	private NhacungcapHome ncchome = new NhacungcapHome();
	
	public List<Nhacungcap> getDSNhacungcap()
	{
		List<Nhacungcap> lstncc = ncchome.findByExample();
		if(lstncc != null)
			return lstncc;
		return null;
	}
}
