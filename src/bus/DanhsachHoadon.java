package bus;

import java.util.ArrayList;
import java.util.List;

import model.Hoadon;

import quanly.QuanlyHoadon;

public class DanhsachHoadon {
	private List<Hoadon> listHD;
	
	private QuanlyHoadon qlhd = new QuanlyHoadon();

	public DanhsachHoadon() {
		super();
		if(qlhd.getDanhsachHoadon() != null)
		{
			this.listHD = qlhd.getDanhsachHoadon();
		}
		else
			listHD = new ArrayList<Hoadon>();
	}
	
	public Hoadon getByIndex(int index)
	{
		return listHD.get(index);
	}

	public List<Hoadon> getListHD() {
		return listHD;
	}
	
	public boolean themHoadon(Hoadon hd)
	{
		if(!listHD.contains(hd) && hd.getChitiethoadons().size() != 0)
		{
			listHD.add(hd);
			qlhd.themHoadon(hd);
			return true;
		}
		return false;
	}
	
	public void suahoadon(Hoadon hd , int index)
	{
		Hoadon newhd = listHD.get(index);
		if(newhd != null)
		{
			newhd.setLoaihoadon(hd.getLoaihoadon());
			newhd.setThanhtoan(hd.getThanhtoan());
			newhd.setNguoinhan(hd.getNguoinhan());
			qlhd.luuHoadonmoi(newhd);
		}
	}

	
	
	
}
