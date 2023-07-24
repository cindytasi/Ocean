package shop.vo;

import java.io.InputStream;
import java.util.Date;

public class Image {
	

	private Integer productImgId;
	private InputStream img1;
	private InputStream img2;
	private InputStream img3;
	private InputStream img4;
	
	
	
	public Image() {
		
	}
	
	public Image(Integer productImgId, InputStream img1, InputStream img2, InputStream img3, InputStream img4) {
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
	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}
	public InputStream getImg1() {
		return img1;
	}
	public void setImg1(InputStream img1) {
		this.img1 = img1;
	}
	public InputStream getImg2() {
		return img2;
	}
	public void setImg2(InputStream img2) {
		this.img2 = img2;
	}
	public InputStream getImg3() {
		return img3;
	}
	public void setImg3(InputStream img3) {
		this.img3 = img3;
	}
	public InputStream getImg4() {
		return img4;
	}
	public void setImg4(InputStream img4) {
		this.img4 = img4;
	}
	
}
