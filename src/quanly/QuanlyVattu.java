package quanly;

import java.util.List;

import model.Vattu;
import dao.VattuHome;

public class QuanlyVattu {
	private VattuHome vthome = new VattuHome();
	
	public List<Vattu> getListVT()
	{
		List<Vattu> lstvt = vthome.findByExample();
		if(lstvt != null)
			return lstvt;
		return null;
	}
	
	public void luuVattu(Vattu vt)
	{
		vthome.attachDirty(vt);
	}
	
	public void capnhatVattu(Vattu vt)
	{
		vthome.merge(vt);
	}
	
	public void xoaVattu(Vattu vt)
	{
		vthome.delete(vt);
	}
}
