package quanly;

import java.util.List;

import model.Vattu;
import dao.VattuHome;

public class QuanlyVattu {
	private VattuHome vthome = new VattuHome();
	
	public List<Vattu> getListNhacungcung()
	{
		List<Vattu> lstvt = vthome.findByExample();
		if(lstvt != null)
			return lstvt;
		return null;
	}
}
