package stu.jsp0516_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.User;

public class UserDAO implements IUserDAO {

	private DataSource ds;
	
	private UserDAO() {
		try {
			InitialContext ct=new InitialContext();
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/myOracle");
			
		}catch(NamingException e ) {
			e.printStackTrace();
		}
		
	}
	
	private static UserDAO dao=new UserDAO();
	
	public static UserDAO getInstance() {
		if(dao ==null) dao=new UserDAO();
		return dao;
	}
	
	
	
	///////////////////////////////////////////
	
	
	@Override
	public boolean confiemId(String id) {
		boolean flag=false;
		String sql="SELECT * FROM my_user WHERE user_id=?";
		
		/*
		 #try with resource
		 -try문을 작성할 때 사용할 자원 객체를 소괄호 안에 전달하면
		 try블록이 끝날 때 자동으로 자원을 해제해 줍니다.
		 -자동으로 종로되는 자원은 반드시 AutoCloseable 인터페이스를 구현한 구현체여야 합니다. 
		  
		  */
		try(
				Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
				
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	@Override
	public void insertUser(UserVO vo) {
		
		String sql="INSERT INTO my_user VALUES(?,?,?,?,?)";
		try(Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql)
				){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public int userCheck(String id, String pw) {
		String sql="SELECT * FROM my_user";
		int result=1;
		try (Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql)
				
				){
			

			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String r_id=rs.getString("user_id");
				String r_pw=rs.getString("user_pw");
				
				if(!r_id.equals(id)) {
					result=-1;
					
				}else if(r_id.equals(id) && !r_pw.equals(pw)) {
					result=0;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public UserVO getUserInfo(String id) {
		String sql="SELECT * FROM my_user WHERE user_id=?";
		UserVO vo=null;
		try (Connection conn=ds.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				)
		{
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new UserVO(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_address")
						
						); 
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vo;
	}

	@Override
	public void changePassword(String id, String newpw) {

	}

	@Override
	public void updateUser(UserVO vo) {

	}

	@Override
	public void deleteUser(String id) {

	}

}
