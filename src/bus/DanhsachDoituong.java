package bus;

import java.util.ArrayList;
import java.util.List;

import model.Doituong;
import quanly.QuanlyDoituong;

public class DanhsachDoituong {
private List<Doituong> lstDoituong;
	
	private QuanlyDoituong qldt = new QuanlyDoituong();

	public DanhsachDoituong() {
		super();
		if(qldt.getDoituongList() != null)
		{
			lstDoituong = qldt.getDoituongList();
		}
		else
		{
			lstDoituong = new ArrayList<Doituong>();
		}
	}

	public Doituong getByIndex(int index)
	{
		return lstDoituong.get(index);
	}

	public List<Doituong> getLstDoituong() {
		return lstDoituong;
	}
	
	public Doituong findByIndex(int index)
	{
		return lstDoituong.get(index);
	}
	
}
