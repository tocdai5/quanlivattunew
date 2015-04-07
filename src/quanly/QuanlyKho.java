package quanly;

import java.util.List;

import model.Kho;

import dao.KhoHome;

public class QuanlyKho {
	private KhoHome khome = new KhoHome();
	
	public List<Kho> getKhoList()
	{
		return khome.findByExample()!=null ? khome.findByExample() : null;
	}
}
