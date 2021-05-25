package view.managedBean;

public class ImageAgence {

	private String nomImg;
	private String descriptions;
	
	
	public ImageAgence(String nomImg, String descriptions) {
		this.nomImg = nomImg;
		this.descriptions = descriptions;
	}
	
	public String getNomImg() {
		return nomImg;
	}
	public void setNomImg(String nomImg) {
		this.nomImg = nomImg;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
}
