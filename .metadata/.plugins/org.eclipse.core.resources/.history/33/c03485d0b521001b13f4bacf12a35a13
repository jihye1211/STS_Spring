package exam.member.vo;

import java.util.Date;

public class MemberVo {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	
	public MemberVo(String email, String password, String name, Date registerDate) {
		// id가 왜 없지?
		this.email=email;
		this.password=password;
		this.name=name;
		this.registerDate=registerDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
		
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void changerPassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.password=newPassword;
	}
	public void delete(String email) {
		this.email=email;
	}
}
