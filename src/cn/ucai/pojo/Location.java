package cn.ucai.pojo;

import java.io.Serializable;

public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mlocationId;
	private String mlocationUserName;
	private Double mlocationLatitude;
	private Double mlocationLongitude;
	private Boolean mlocationIsSearched;
	private String mlocationLastUpdateTime;
	public Location(){
		super();
	}
	public Location(Integer mlocationId,String mlocationUserName,Double mlocationLatitude,Double mlocationLongitude,Boolean mlocationIsSearched,String mlocationLastUpdateTime){
		this.mlocationId = mlocationId;
		this.mlocationUserName = mlocationUserName;
		this.mlocationLatitude = mlocationLatitude;
		this.mlocationLongitude = mlocationLongitude;
		this.mlocationIsSearched = mlocationIsSearched;
		this.mlocationLastUpdateTime = mlocationLastUpdateTime;
	}
	
	public Integer getM_location_id() {
 		return this.mlocationId;
 	}
 	
	public void setM_location_id(Integer mlocationId){
		this.mlocationId = mlocationId;
	}
 	
 	public String getM_location_user_name() {
 		return this.mlocationUserName;
 	}
 	
	public void setM_location_user_name(String mlocationUserName){
		this.mlocationUserName = mlocationUserName;
	}
 	
 	public Double getM_location_latitude() {
 		return this.mlocationLatitude;
 	}
 	
	public void setM_location_latitude(Double mlocationLatitude){
		this.mlocationLatitude = mlocationLatitude;
	}
 	
 	public Double getM_location_longitude() {
 		return this.mlocationLongitude;
 	}
 	
	public void setM_location_longitude(Double mlocationLongitude){
		this.mlocationLongitude = mlocationLongitude;
	}
 	
 	public Boolean getM_location_is_searched() {
 		return this.mlocationIsSearched;
 	}
 	
	public void setM_location_is_searched(Boolean mlocationIsSearched){
		this.mlocationIsSearched = mlocationIsSearched;
	}
 	
 	public String getM_location_last_update_time() {
 		return this.mlocationLastUpdateTime;
 	}
 	
	public void setM_location_last_update_time(String mlocationLastUpdateTime){
		this.mlocationLastUpdateTime = mlocationLastUpdateTime;
	}
 	
 	 	@Override
 	public String toString() {
 		return "Location ["
 	 	+ "this.mlocationId=" + mlocationId
	 	+ "this.mlocationUserName=" + mlocationUserName
	 	+ "this.mlocationLatitude=" + mlocationLatitude
	 	+ "this.mlocationLongitude=" + mlocationLongitude
	 	+ "this.mlocationIsSearched=" + mlocationIsSearched
	 	+ "this.mlocationLastUpdateTime=" + mlocationLastUpdateTime
		;
 	}
 
}