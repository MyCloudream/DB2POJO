package cn.ucai.pojo;

import java.io.Serializable;

public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mgroupId;
	private String mgroupHxid;
	private String mgroupName;
	private String mgroupDescription;
	private String mgroupOwner;
	private String mgroupLastModifiedTime;
	private Integer mgroupMaxUsers;
	private Integer mgroupAffiliationsCount;
	private Boolean mgroupIsPublic;
	private Integer mgroupAllowInvites;
	public Group(){
		super();
	}
	public Group(Integer mgroupId,String mgroupHxid,String mgroupName,String mgroupDescription,String mgroupOwner,String mgroupLastModifiedTime,Integer mgroupMaxUsers,Integer mgroupAffiliationsCount,Boolean mgroupIsPublic,Integer mgroupAllowInvites){
		this.mgroupId = mgroupId;
		this.mgroupHxid = mgroupHxid;
		this.mgroupName = mgroupName;
		this.mgroupDescription = mgroupDescription;
		this.mgroupOwner = mgroupOwner;
		this.mgroupLastModifiedTime = mgroupLastModifiedTime;
		this.mgroupMaxUsers = mgroupMaxUsers;
		this.mgroupAffiliationsCount = mgroupAffiliationsCount;
		this.mgroupIsPublic = mgroupIsPublic;
		this.mgroupAllowInvites = mgroupAllowInvites;
	}
	
	public Integer getM_group_id() {
 		return this.mgroupId;
 	}
 	
	public void setM_group_id(Integer mgroupId){
		this.mgroupId = mgroupId;
	}
 	
 	public String getM_group_hxid() {
 		return this.mgroupHxid;
 	}
 	
	public void setM_group_hxid(String mgroupHxid){
		this.mgroupHxid = mgroupHxid;
	}
 	
 	public String getM_group_name() {
 		return this.mgroupName;
 	}
 	
	public void setM_group_name(String mgroupName){
		this.mgroupName = mgroupName;
	}
 	
 	public String getM_group_description() {
 		return this.mgroupDescription;
 	}
 	
	public void setM_group_description(String mgroupDescription){
		this.mgroupDescription = mgroupDescription;
	}
 	
 	public String getM_group_owner() {
 		return this.mgroupOwner;
 	}
 	
	public void setM_group_owner(String mgroupOwner){
		this.mgroupOwner = mgroupOwner;
	}
 	
 	public String getM_group_last_modified_time() {
 		return this.mgroupLastModifiedTime;
 	}
 	
	public void setM_group_last_modified_time(String mgroupLastModifiedTime){
		this.mgroupLastModifiedTime = mgroupLastModifiedTime;
	}
 	
 	public Integer getM_group_max_users() {
 		return this.mgroupMaxUsers;
 	}
 	
	public void setM_group_max_users(Integer mgroupMaxUsers){
		this.mgroupMaxUsers = mgroupMaxUsers;
	}
 	
 	public Integer getM_group_affiliations_count() {
 		return this.mgroupAffiliationsCount;
 	}
 	
	public void setM_group_affiliations_count(Integer mgroupAffiliationsCount){
		this.mgroupAffiliationsCount = mgroupAffiliationsCount;
	}
 	
 	public Boolean getM_group_is_public() {
 		return this.mgroupIsPublic;
 	}
 	
	public void setM_group_is_public(Boolean mgroupIsPublic){
		this.mgroupIsPublic = mgroupIsPublic;
	}
 	
 	public Integer getM_group_allow_invites() {
 		return this.mgroupAllowInvites;
 	}
 	
	public void setM_group_allow_invites(Integer mgroupAllowInvites){
		this.mgroupAllowInvites = mgroupAllowInvites;
	}
 	
 	 	@Override
 	public String toString() {
 		return "Group ["
 	 	+ "this.mgroupId=" + mgroupId
	 	+ "this.mgroupHxid=" + mgroupHxid
	 	+ "this.mgroupName=" + mgroupName
	 	+ "this.mgroupDescription=" + mgroupDescription
	 	+ "this.mgroupOwner=" + mgroupOwner
	 	+ "this.mgroupLastModifiedTime=" + mgroupLastModifiedTime
	 	+ "this.mgroupMaxUsers=" + mgroupMaxUsers
	 	+ "this.mgroupAffiliationsCount=" + mgroupAffiliationsCount
	 	+ "this.mgroupIsPublic=" + mgroupIsPublic
	 	+ "this.mgroupAllowInvites=" + mgroupAllowInvites
		;
 	}
 
}