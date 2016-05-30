package cn.ucai.pojo;

import java.io.Serializable;

public class Avatar implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mavatarId;
	private String mavatarUserName;
	private String mavatarPath;
	private Integer mavatarType;
	private String mavatarLastUpdateTime;
	public Avatar(){
		super();
	}
	public Avatar(Integer mavatarId,String mavatarUserName,String mavatarPath,Integer mavatarType,String mavatarLastUpdateTime){
		this.mavatarId = mavatarId;
		this.mavatarUserName = mavatarUserName;
		this.mavatarPath = mavatarPath;
		this.mavatarType = mavatarType;
		this.mavatarLastUpdateTime = mavatarLastUpdateTime;
	}
	
	public Integer getM_avatar_id() {
 		return this.mavatarId;
 	}
 	
	public void setM_avatar_id(Integer mavatarId){
		this.mavatarId = mavatarId;
	}
 	
 	public String getM_avatar_user_name() {
 		return this.mavatarUserName;
 	}
 	
	public void setM_avatar_user_name(String mavatarUserName){
		this.mavatarUserName = mavatarUserName;
	}
 	
 	public String getM_avatar_path() {
 		return this.mavatarPath;
 	}
 	
	public void setM_avatar_path(String mavatarPath){
		this.mavatarPath = mavatarPath;
	}
 	
 	public Integer getM_avatar_type() {
 		return this.mavatarType;
 	}
 	
	public void setM_avatar_type(Integer mavatarType){
		this.mavatarType = mavatarType;
	}
 	
 	public String getM_avatar_last_update_time() {
 		return this.mavatarLastUpdateTime;
 	}
 	
	public void setM_avatar_last_update_time(String mavatarLastUpdateTime){
		this.mavatarLastUpdateTime = mavatarLastUpdateTime;
	}
 	
 	 	@Override
 	public String toString() {
 		return "Avatar ["
 	 	+ "this.mavatarId=" + mavatarId
	 	+ "this.mavatarUserName=" + mavatarUserName
	 	+ "this.mavatarPath=" + mavatarPath
	 	+ "this.mavatarType=" + mavatarType
	 	+ "this.mavatarLastUpdateTime=" + mavatarLastUpdateTime
		;
 	}
 
}