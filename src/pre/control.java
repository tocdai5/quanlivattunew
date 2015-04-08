package pre;

import java.util.List;

import model.Hoadon;
import model.Vattu;

import dao.HoadonHome;
import dao.VattuHome;

public class control {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		VattuHome vthome = new VattuHome();
		
//		List<Vattu> list = vthome.findByExample();
//		
//		for(Vattu vt : list)
//		{
//			System.out.println(vt);
//		}
		
		Vattu vt1 = vthome.findById(1);
		Vattu vt2 = vthome.findById(1);
		if(vt1.equals(vt2))
		System.out.println(vt1);
	}

}
