package hr.dto;

import java.sql.Date;

public class EmpListDto {


	private int id;
	private String firstName;
	private String PhoneNumber;
	private Date hireDate;
	private String jobId;
	private String departmentName;
	 
	public EmpListDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "EmpListDto [id=" + id + ", firstName=" + firstName + ", PhoneNumber=" + PhoneNumber + ", hireDate="
				+ hireDate + ", jobId=" + jobId + ", departmentName=" + departmentName + "]";
	}
	
}

	
