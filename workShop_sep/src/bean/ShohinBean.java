package bean;

public class ShohinBean {
		private Integer Id;
	    private String Name;
	    private Integer Price;
	    private String Insert_date;
	    private String ImgURL;

	    public void setId(Integer Id) {
	        this.Id = Id;
	    }

	    public Integer Id() {
	        return Id;
	    }

	    public void setName(String Name) {
	        this.Name = Name;
	    }

	    public String getName() {
	        return Name;
	    }

	    public void setPrice(Integer Price) {
	        this.Price = Price;
	    }

	    public Integer getPrice() {
	        return Price;
	    }


	    public void setInsert_date(String Insert_date) {
	        this.Insert_date = Insert_date;
	    }

	    public String getInsert_date() {
	        return Insert_date;
	    }

	    public void setImgURL(String ImgURL) {
	        this.ImgURL = ImgURL;
	    }

	    public String getImgURL() {
	        return ImgURL;
	    }

}
