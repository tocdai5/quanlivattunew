package bus.copy;

import java.util.List;

import model.Chitiethoadon;
import model.Hoadon;
import dao.ChitiethoadonHome;

public class QuanlyChitiethoadon {
	private ChitiethoadonHome cthdhome=new ChitiethoadonHome();
	
	private void luuChitiethoadonMoi(Chitiethoadon cthd){
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
		List<Chitiethoadon> listCTHD = cthdhome.findByExample();
		if(listCTHD !=null)
			return listCTHD;
		return null;
	}
}
