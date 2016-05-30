package cn.ucai.pojo;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mmemberId;
	private String mmemberUserName;
	private Integer mmemberGroupId;
	private String mmemberGroupHxid;
	private Integer mmemberPermission;
	public Member(){
		super();
	}
	public Member(Integer mmemberId,String mmemberUserName,Integer mmemberGroupId,String mmemberGroupHxid,Integer mmemberPermission){
		this.mmemberId = mmemberId;
		this.mmemberUserName = mmemberUserName;
		this.mmemberGroupId = mmemberGroupId;
		this.mmemberGroupHxid = mmemberGroupHxid;
		this.mmemberPermission = mmemberPermission;
	}
	
	public Integer getM_member_id() {
 		return this.mmemberId;
 	}
 	
	public void setM_member_id(Integer mmemberId){
		this.mmemberId = mmemberId;
	}
 	
 	public String getM_member_user_name() {
 		return this.mmemberUserName;
 	}
 	
	public void setM_member_user_name(String mmemberUserName){
		this.mmemberUserName = mmemberUserName;
	}
 	
 	public Integer getM_member_group_id() {
 		return this.mmemberGroupId;
 	}
 	
	public void setM_member_group_id(Integer mmemberGroupId){
		this.mmemberGroupId = mmemberGroupId;
	}
 	
 	public String getM_member_group_hxid() {
 		return this.mmemberGroupHxid;
 	}
 	
	public void setM_member_group_hxid(String mmemberGroupHxid){
		this.mmemberGroupHxid = mmemberGroupHxid;
	}
 	
 	public Integer getM_member_permission() {
 		return this.mmemberPermission;
 	}
 	
	public void setM_member_permission(Integer mmemberPermission){
		this.mmemberPermission = mmemberPermission;
	}
 	
 	 	@Override
 	public String toString() {
 		return "Member ["
 	 	+ "this.mmemberId=" + mmemberId
	 	+ "this.mmemberUserName=" + mmemberUserName
	 	+ "this.mmemberGroupId=" + mmemberGroupId
	 	+ "this.mmemberGroupHxid=" + mmemberGroupHxid
	 	+ "this.mmemberPermission=" + mmemberPermission
		;
 	}
 
}