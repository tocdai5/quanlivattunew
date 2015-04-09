package gui;

import java.util.List;

import model.Hoadon;
import dao.HoadonHome;

public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HoadonHome hdhome = new HoadonHome();
		
		List<Hoadon> list = hdhome.findByExample();
		
		for(int i = 0 ; i< list.size() ; i++)
		{
			Hoadon hd = list.get(i);
			System.out.println(hd.getId());
			System.out.println(hd.getNgay());
			System.out.println(hd.getSochungtu());
			System.out.println(hd.getSohoadon());
			System.out.println(hd.getKho());
			System.out.println(hd.getNhacungcap());
			System.out.println(hd.getDoituong());
			System.out.println(hd.getUser());
			System.out.println(hd.getGhichu());
			System.out.println(hd.getLoaihoadon());
			System.out.println(hd.getNguoinhan());
			
		}
		
	}

}
