package pre;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.Chitiethoadon;
import model.Vattu;
import dao.VattuHome;

public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		HoadonHome hdhome = new HoadonHome();
//		
//		KhoHome khohome = new KhoHome();
//		NhacungcapHome ncchome = new NhacungcapHome();
//		UserHome userhome = new UserHome();
//		DoituongHome dthome = new DoituongHome();
//		
//		List<Hoadon> list = hdhome.findByExample();
//		
//		for(int i = 0 ; i< list.size() ; i++)
//		{
//			Hoadon hd = list.get(i);
//			System.out.println(hd.getId());
//			System.out.println(hd.getNgay());
//			System.out.println(hd.getSochungtu());
//			System.out.println(hd.getSohoadon());
//			System.out.println(hd.getKho());
//			System.out.println(hd.getNhacungcap());
//			System.out.println(hd.getDoituong());
//			System.out.println(hd.getUser());
//			System.out.println(hd.getGhichu());
//			System.out.println(hd.getLoaihoadon());
//			System.out.println(hd.getNguoinhan());
//			
//			System.out.println("\n\n");
//		}
//		
//		Kho k1 = new Kho("KH01", "Kho");
//		User u1 =  new User("user1", "user1", "123");
//		Nhacungcap ncc1 =  new Nhacungcap("1", "ncc", "q7");
//		Doituong dt1 = new Doituong("ss", "dt", "q8");
//		
//		khohome.attachDirty(k1);
//		userhome.attachDirty(u1);
//		ncchome.attachDirty(ncc1);
//		dthome.attachDirty(dt1);
//		
//		Hoadon hd = new Hoadon(k1,null,ncc1, dt1, new Date(), "sct", 123, "phieu nhap", "tien mat", "anh ta", "chan qua di dai qua");
//		hdhome.attachDirty(hd);
//		
		VattuHome vthome = new VattuHome();
		Vattu vt1 = vthome.findById(8);
		Vattu vt2 = vthome.findById(9);
		Chitiethoadon cthd1 = new Chitiethoadon(vt1, null, 2, 4, 4);
		Chitiethoadon cthd2 = new Chitiethoadon(vt2, null, 2, 4, 4);
		
		Set<Chitiethoadon> cthds = new HashSet<Chitiethoadon>(0);
		cthds.add(cthd1);
		cthds.add(cthd2);
		
		Chitiethoadon cthd = new Chitiethoadon(vt1, null, 2, 4, 4);
		cthds.remove(cthd);
		
		for(Iterator<Chitiethoadon> it = cthds.iterator(); it.hasNext() ;)
		{
			Chitiethoadon ct = it.next();
			System.out.println(ct.getVattu().getTenvattu().toString()+"\n");
		}
		
		
		
	}

}
