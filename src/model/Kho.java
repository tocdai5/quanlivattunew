package model;

// Generated Apr 5, 2015 2:15:39 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Kho generated by hbm2java
 */
public class Kho implements java.io.Serializable {

	private Integer id;
	private String makho;
	private String tenkho;
	private Set<Hoadon> hoadons = new HashSet<Hoadon>(0);

	public Kho() {
	}

	public Kho(String makho, String tenkho) {
		this.makho = makho;
		this.tenkho = tenkho;
	}

	public Kho(String makho, String tenkho, Set<Hoadon> hoadons) {
		this.makho = makho;
		this.tenkho = tenkho;
		this.hoadons = hoadons;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMakho() {
		return this.makho;
	}

	public void setMakho(String makho) {
		this.makho = makho;
	}

	public String getTenkho() {
		return this.tenkho;
	}

	public void setTenkho(String tenkho) {
		this.tenkho = tenkho;
	}

	public Set<Hoadon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(Set<Hoadon> hoadons) {
		this.hoadons = hoadons;
	}

	@Override
	public String toString() {
		return tenkho ;
	}
	
	

}
