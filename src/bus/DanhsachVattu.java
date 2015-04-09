package bus;

import java.util.ArrayList;
import java.util.List;

import quanly.QuanlyVattu;
import model.Kho;
import model.Vattu;

public class DanhsachVattu {
	private List<Vattu> lstVattu;
	private QuanlyVattu qlvt = new QuanlyVattu();
	
	public DanhsachVattu() {
		List<Vattu> lstvt = qlvt.getListVT();
		if(lstvt != null)
			lstVattu = lstvt;
		else
		{
			lstVattu = new ArrayList<Vattu>();
			System.out.println("A A");
		}
	}
	public Vattu getByIndex(int index)
	{
		return lstVattu.get(index);
	}
	public List<Vattu> getLstVattu() {
		return lstVattu;
	}
	
	public Vattu findByIndex(int index)
	{
		return lstVattu.get(index);
	}
	
	public boolean themVattu(Vattu vt)
	{
		if(!lstVattu.contains(vt))
		{
			lstVattu.add(vt);
			qlvt.luuVattu(vt);
			return true;
		}
		return false;
	}
	
	public boolean capnhatpVattu(int i , Vattu vt)
	{
		Vattu newVt = findByIndex(i);
		if(newVt != null)
		{
			newVt.setMavattu(vt.getMavattu());
			newVt.setTenvattu(vt.getTenvattu());
			newVt.setDongia(vt.getDongia());
			newVt.setDonvitinh(vt.getDonvitinh());
			qlvt.capnhatVattu(newVt);
			return true;
		}
		return false;
	}
	
	public void xoaVattu(int i )
	{
		qlvt.xoaVattu(findByIndex(i));
		lstVattu.remove(i);
	}
	
}
