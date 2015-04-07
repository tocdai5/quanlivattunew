package bus;

import java.util.ArrayList;
import java.util.List;

import quanly.QuanlyVattu;

import model.Vattu;

public class DanhsachVattu {
	private List<Vattu> lstVattu;
	private QuanlyVattu qlvt = new QuanlyVattu();
	
	public DanhsachVattu() {
		List<Vattu> lstvt = qlvt.getListNhacungcung();
		if(lstvt != null)
			lstVattu = lstvt;
		else
			lstVattu = new ArrayList<Vattu>();
	}

	public List<Vattu> getLstVattu() {
		return lstVattu;
	}
	
	public Vattu findByIndex(int index)
	{
		return lstVattu.get(index);
	}
	
}
