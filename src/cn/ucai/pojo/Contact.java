package cn.ucai.pojo;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcontactId;
	private String mcontactUserName;
	private String mcontactCname;
	public Contact(){
		super();
	}
	public Contact(Integer mcontactId,String mcontactUserName,String mcontactCname){
		this.mcontactId = mcontactId;
		this.mcontactUserName = mcontactUserName;
		this.mcontactCname = mcontactCname;
	}
	
	public Integer getM_contact_id() {
 		return this.mcontactId;
 	}
 	
	public void setM_contact_id(Integer mcontactId){
		this.mcontactId = mcontactId;
	}
 	
 	public String getM_contact_user_name() {
 		return this.mcontactUserName;
 	}
 	
	public void setM_contact_user_name(String mcontactUserName){
		this.mcontactUserName = mcontactUserName;
	}
 	
 	public String getM_contact_cname() {
 		return this.mcontactCname;
 	}
 	
	public void setM_contact_cname(String mcontactCname){
		this.mcontactCname = mcontactCname;
	}
 	
 	 	@Override
 	public String toString() {
 		return "Contact ["
 	 	+ "this.mcontactId=" + mcontactId
	 	+ "this.mcontactUserName=" + mcontactUserName
	 	+ "this.mcontactCname=" + mcontactCname
		;
 	}
 
}