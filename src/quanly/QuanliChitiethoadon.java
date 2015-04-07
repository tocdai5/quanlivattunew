package quanly;

import java.util.List;

import model.Chitiethoadon;
import dao.ChitiethoadonHome;

public class QuanliChitiethoadon {
private ChitiethoadonHome cthdhome = new ChitiethoadonHome();
	
	public void luuChitiethoadonmoi(Chitiethoadon cthd)
	{
		cthdhome.attachDirty(cthd);
	}
	
	public boolean suaChitiethoadon(Chitiethoadon newcthd)
	{
		Chitiethoadon cthd = cthdhome.merge(newcthd);
		if(cthd !=null)
			return true;
		return false;
	}
	
	public List<Chitiethoadon> getDanhsachChitiethoadon()
	{
		List<Chitiethoadon> listctHd = cthdhome.findByExample();
		if(listctHd !=null)
			return listctHd;
		return null;
	}
	
	public void xoaChitiethoadon(Chitiethoadon cthd)
	{
		cthdhome.delete(cthd);
	}
	
	
}
