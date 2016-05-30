package cn.ucai.pojo;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String muserName;
	private String muserPassword;
	private String muserNick;
	private Integer muserUnreadMsgCount;
	public User(){
		super();
	}
	public User(String muserName,String muserPassword,String muserNick,Integer muserUnreadMsgCount){
		this.muserName = muserName;
		this.muserPassword = muserPassword;
		this.muserNick = muserNick;
		this.muserUnreadMsgCount = muserUnreadMsgCount;
	}
	
	public String getM_user_name() {
 		return this.muserName;
 	}
 	
	public void setM_user_name(String muserName){
		this.muserName = muserName;
	}
 	
 	public String getM_user_password() {
 		return this.muserPassword;
 	}
 	
	public void setM_user_password(String muserPassword){
		this.muserPassword = muserPassword;
	}
 	
 	public String getM_user_nick() {
 		return this.muserNick;
 	}
 	
	public void setM_user_nick(String muserNick){
		this.muserNick = muserNick;
	}
 	
 	public Integer getM_user_unread_msg_count() {
 		return this.muserUnreadMsgCount;
 	}
 	
	public void setM_user_unread_msg_count(Integer muserUnreadMsgCount){
		this.muserUnreadMsgCount = muserUnreadMsgCount;
	}
 	
 	 	@Override
 	public String toString() {
 		return "User ["
 	 	+ "this.muserName=" + muserName
	 	+ "this.muserPassword=" + muserPassword
	 	+ "this.muserNick=" + muserNick
	 	+ "this.muserUnreadMsgCount=" + muserUnreadMsgCount
		;
 	}
 
}