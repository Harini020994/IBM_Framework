package com.training.bean;

public class CategoryCreateBean {
	private String categoryName;
	private String description;
	private String metaTag; 
	private String metaTagdesc;
	private String prodname;
	private String metaTagNm;
	private String cateName;
	
	

	
	public CategoryCreateBean(String categoryName,String description,String metaTag,String metaTagdesc,String prodname,String metaTagNm,String cateName) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.metaTag=metaTag;
		this.metaTagdesc = metaTagdesc;
		this.prodname = prodname;
		this.metaTagNm=metaTagNm;
		this.cateName=cateName;
		
	}
	public String getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getMetaTag() {
		return metaTag;
	}




	public void setMetaTag(String metaTag) {
		this.metaTag = metaTag;
	}




	public String getMetaTagdesc() {
		return metaTagdesc;
	}




	public void setMetaTagdesc(String metaTagdesc) {
		this.metaTagdesc = metaTagdesc;
	}




	public String getProdname() {
		return prodname;
	}




	public void setProdname(String prodname) {
		this.prodname = prodname;
	}




	public String getMetaTagNm() {
		return metaTagNm;
	}




	public void setMetaTagNm(String metaTagNm) {
		this.metaTagNm = metaTagNm;
	}




	public String getCateName() {
		return cateName;
	}




	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	@Override
	public String toString() {
		return "CategoryCreateBean";
	}

}
