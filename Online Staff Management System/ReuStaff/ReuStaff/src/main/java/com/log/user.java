package com.log;

public class user {
	
	String memberid;
	String sname;
	String mail;
	String stype;

	
	
	@Override
	public String toString() {
		return "user [memberid=" + memberid + ", sname=" + sname + ", mail=" + mail + ",stype="+ stype + "]";
	}
	
	
	public user(String memberid, String sname, String mail, String stype) {
		super();
		this.memberid = memberid;
		this.sname = sname;
		this.mail = mail;
		this.stype = stype;
	}
	
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public void setName(String sname) {
		this.sname = sname;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setType(String stype) {
		this.stype = stype;
	}

	public String getMemberid() {
		return memberid;
	}
	
	public String getName() {
		return sname;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getType() {
		return stype;
	}
	
	

}
