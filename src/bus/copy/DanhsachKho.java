package bus.copy;

import java.util.ArrayList;
import java.util.List;

import quanly.QuanlyKho;
import model.Doituong;
import model.Kho;

public class DanhsachKho {
	private List<Kho> lstKho;
	
	private QuanlyKho qlk = new QuanlyKho();

	public DanhsachKho() {
		super();
		if(qlk.getKhoList() != null)
		{
			lstKho = qlk.getKhoList();
		}
		else
		{
			lstKho = new ArrayList<Kho>();
		}
	}
	public Kho getByIndex(int index)
	{
		return lstKho.get(index);
	}
	public List<Kho> getLstKho() {
		return lstKho;
	}
	
	public Kho findIndex(int index)
	{
		return lstKho.get(index);
	}
	
	
	
	
}
