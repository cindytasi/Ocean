package videoPlay.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProductImg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productImgId;
	@Lob
	private byte[] img1;
	@Lob
	private byte[] img2;
	@Lob
	private byte[] img3;
	@Lob
	private byte[] img4;
	
	public ProductImg() {
		
	}
	
	
	
	public ProductImg(Integer productImgId, byte[] img1, byte[] img2, byte[] img3, byte[] img4) {
		super();
		this.productImgId = productImgId;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
	}



	public Integer getProductImgId() {
		return productImgId;
	}



	public byte[] getImg1() {
		return img1;
	}



	public byte[] getImg2() {
		return img2;
	}



	public byte[] getImg3() {
		return img3;
	}



	public byte[] getImg4() {
		return img4;
	}



	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}



	public void setImg1(byte[] img1) {
		this.img1 = img1;
	}



	public void setImg2(byte[] img2) {
		this.img2 = img2;
	}



	public void setImg3(byte[] img3) {
		this.img3 = img3;
	}



	public void setImg4(byte[] img4) {
		this.img4 = img4;
	}
	
	
}
