
package manufactur.vo;

public class ProductImg {
	private Integer   productImgId;
	private byte[] img1;
	private byte[] img2;
	private byte[] img3;
	private byte[] img4;

	
	public  ProductImg() {
	}
	
	public ProductImg( byte[] img1,  byte[] img2, byte[] img3,
			 byte[] img4) {
		super();
		this. img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
	
	
		
		
		
	}

	public byte[] getImg1() {
		return img1;
	}

	public void setImg1(byte[] img1) {
		this.img1 = img1;
	}

	public byte[] getImg2() {
		return img2;
	}

	public void setImg2(byte[] img2) {
		this.img2 = img2;
	}

	public byte[] getImg3() {
		return img3;
	}

	public void setImg3(byte[] img3) {
		this.img3 = img3;
	}

	public byte[] getImg4() {
		return img4;
	}

	public void setImg4(byte[] img4) {
		this.img4 = img4;
	}

	public Integer getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(int productImgId) {
		this.productImgId = productImgId;
	}
}
