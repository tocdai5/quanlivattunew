package bus;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.Chitiethoadon;
import model.Hoadon;
import model.Vattu;
import quanly.QuanliChitiethoadon;

public class DanhSachChitiethoadon {
	private Set<Chitiethoadon> cthds;
	
	private QuanliChitiethoadon qlcthd = new QuanliChitiethoadon();
	
	public DanhSachChitiethoadon() {
		cthds = new HashSet<Chitiethoadon>();
	}

	public Set<Chitiethoadon> getCthds() {
		return cthds;
	}

	public void setCthds(Set<Chitiethoadon> cthds) {
		this.cthds = cthds;
	}
	
	public boolean themChitiethoadon(Chitiethoadon cthd)
	{
		if(!kiemtratontai(cthd))
		{
			cthds.add(cthd);
			return true;
		}
		return false;
	}
	
	private boolean kiemtratontai(Chitiethoadon cthd)
	{
		for(Iterator<Chitiethoadon> it = cthds.iterator() ; it.hasNext() ;)
		{
			Chitiethoadon cursor = it.next();
			Vattu vt = cursor.getVattu();
			if(vt.getMavattu().contains(cthd.getVattu().getMavattu()))
				return true;
		}
		return false;
	}
	
	public void xoaCthd(Chitiethoadon cthd)
	{
		for(Iterator<Chitiethoadon> it = cthds.iterator() ; it.hasNext() ;)
		{
			Chitiethoadon cursor = it.next();
			if(cursor.getVattu().getMavattu().equals(cthd.getVattu().getMavattu()))
			{
				it.remove();
				return;
			}
		}
	}
	
	public Chitiethoadon timCthd(String mavattu)
	{
		for(Iterator<Chitiethoadon> it = cthds.iterator() ; it.hasNext() ; )
		{
			Chitiethoadon cthd = it.next();
			if(cthd.getVattu().getMavattu().equals(mavattu))
			{
				return cthd;
			}
		}
		return null;
	}
	
	public Chitiethoadon suaCthd(Chitiethoadon cthd)
	{
		Chitiethoadon newct = timCthd(cthd.getVattu().getMavattu());
		if(newct !=null)
		{
			newct.setSoluong(cthd.getSoluong());
			newct.setThue(cthd.getThue());
			newct.setThanhtien(cthd.getThanhtien());
			return newct;
		}
		return null;
	}
	
	public double tinhTongthanhtien()
	{
		double tongthanhtien = 0;
		for(Iterator<Chitiethoadon> it = cthds.iterator() ; it.hasNext() ;)
		{
			Chitiethoadon cursor = it.next();
			tongthanhtien += cursor.getThanhtien();
		}
		return tongthanhtien;
	}
}
