package quanly;

import java.util.List;

import model.Doituong;
import dao.DoituongHome;

public class QuanlyDoituong {
private DoituongHome dthome = new DoituongHome();
	
	public List<Doituong> getDoituongList()
	{
		return dthome.findByExample()!=null ? dthome.findByExample() : null;
	}
}
