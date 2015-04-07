package quanly;

import java.util.List;

import model.Hoadon;
import dao.HoadonHome;

public class QuanlyHoadon {
	
	private HoadonHome hdhome = new HoadonHome();
	
	public void luuHoadonmoi(Hoadon hd)
	{
		hdhome.attachDirty(hd);
	}
	
	public boolean suaHoadon(Hoadon newhd)
	{
		Hoadon hd = hdhome.merge(newhd);
		if(hd !=null)
			return true;
		return false;
	}
	
	public List<Hoadon> getDanhsachHoadon()
	{
		List<Hoadon> listHd = hdhome.findByExample();
		if(listHd !=null)
			return listHd;
		return null;
	}
	
	
	public Hoadon findBySCT(String sct)
	{
		Hoadon hd = hdhome.findBySoChungtu(sct);
		if(hd != null)
			return hd;
		return null;
	}
	
	public void themHoadon(Hoadon hd)
	{
		hdhome.attachDirty(hd);
	}
	

}
