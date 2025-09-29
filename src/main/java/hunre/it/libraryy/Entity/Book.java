package hunre.it.libraryy.Entity;
import jakarta.persistence.*;
@Entity
@Table(name="book")
public class Book {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	 @Column(name = "masach" ,unique = true)
		public String masach ;
	 @Column(name = "ten")
		public String ten ;
	 @Column(name = "tgia")
		public String tgia ;
	 @Column(name = "slg")
		public int slg ;

	 @Column(name = "danhmuc")
		public String danhmuc ;
	 @Column(name = "noidung")
		public String noidung ;
	 @Column(name = "gia")
		public int gia ;
	 @Column(name = "nxb")
		public String nxb ;
	 @Column(name = "namxb")
		public String namxb ;
	 public Book() {
			super();
		}
	 public Book(Long id, String masach, String ten, String tgia, int slg, String danhmuc, String noidung, int gia,
			String nxb, String namxb) {
		super();
		this.id = id;
		this.masach = masach;
		this.ten = ten;
		this.tgia = tgia;
		this.slg = slg;
		this.danhmuc = danhmuc;
		this.noidung = noidung;
		this.gia = gia;
		this.nxb = nxb;
		this.namxb = namxb;
	 }
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getMasach() {
		 return masach;
	 }
	 public void setMasach(String masach) {
		 this.masach = masach;
	 }
	 public String getTen() {
		 return ten;
	 }
	 public void setTen(String ten) {
		 this.ten = ten;
	 }
	 public String getTgia() {
		 return tgia;
	 }
	 public void setTgia(String tgia) {
		 this.tgia = tgia;
	 }
	 public int getSlg() {
		 return slg;
	 }
	 public void setSlg(int slg) {
		 this.slg = slg;
	 }
	 public String getDanhmuc() {
		 return danhmuc;
	 }
	 public void setDanhmuc(String danhmuc) {
		 this.danhmuc = danhmuc;
	 }
	 public String getNoidung() {
		 return noidung;
	 }
	 public void setNoidung(String noidung) {
		 this.noidung = noidung;
	 }
	 public int getGia() {
		 return gia;
	 }
	 public void setGia(int gia) {
		 this.gia = gia;
	 }
	 public String getNxb() {
		 return nxb;
	 }
	 public void setNxb(String nxb) {
		 this.nxb = nxb;
	 }
	 public String getNamxb() {
		 return namxb;
	 }
	 public void setNamxb(String namxb) {
		 this.namxb = namxb;
	 }
	 

}
