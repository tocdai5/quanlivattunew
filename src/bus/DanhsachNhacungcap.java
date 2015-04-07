package bus;

import java.util.ArrayList;
import java.util.List;

import quanly.QuanlyNhacungcap;

import model.Nhacungcap;

public class DanhsachNhacungcap {
	private List<Nhacungcap> lstNhacungcap;
	private QuanlyNhacungcap qlncc = new QuanlyNhacungcap();
	
	public DanhsachNhacungcap() {
		List<Nhacungcap> lstncc = qlncc.getDSNhacungcap();
		if(lstncc != null)
			lstNhacungcap = lstncc;
		else
			lstNhacungcap = new ArrayList<Nhacungcap>();
	}

	public List<Nhacungcap> getLstNhacungcap() {
		return lstNhacungcap;
	}
	
	public Nhacungcap findByIndex(int index)
	{
		return lstNhacungcap.get(index);
	}
	
	
	
	
	
}
