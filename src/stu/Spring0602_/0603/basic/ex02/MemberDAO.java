package stu.Spring0602_;

public class MemberDAO {

	private stu.Spring0602_.DataBaseInfo dbInfo;
	
	public void setDbInfo(stu.Spring0602_.DataBaseInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	public void showDBInfo() {
		System.out.println("URL : "+dbInfo.getUrl());
		System.out.println("UID : "+dbInfo.getUid());
		System.out.println("UPW : "+dbInfo.getUpw());
	}
}
