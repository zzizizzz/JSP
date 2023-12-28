package hr.dao;

import java.util.List;

import helper.JdbcTemplate;
import hr.dto.EmpListDto;
import hr.vo.Employee;

public class EmployeeDao {
	
	public int getTotalRows() {
		String sql = """
				select count(*)cnt 
				from employees
				""";
		return JdbcTemplate.selectOne(sql, rs-> {
			int cnt = rs.getInt("cnt");
			return cnt;
		});
	}
	
	public void insertEmployee(Employee emp) {
		String sql = """
				inseRt into employees
				(employee_id, first_name, last_name, email, phone_number,
				hire_date, job_id, salary, commission_pct, department_id)
				values
				(EMPLOYEES_SEQ.nextval, ?,?,?,?,?,?,?,?,?)
				""";
		
		JdbcTemplate.insert(sql,emp.getFitstName(),
								emp.getLastName(),
								emp.getEmail(),
								emp.getPhoneNumber(),
								emp.getHireDate(),
								emp.getJobId(),
								emp.getSalary(),
								emp.getCommissionPct(),
								emp.getDepartmentId());
		
	}
	
	//페이징 처리
	public List<EmpListDto> getEmployees(int start, int end){
		
		String sql = """
			SELECT X.EMPLOYEE_ID,
				   X.FIRST_NAME,
				   X.PHONE_NUMBER,
				   X.HIRE_DATE,
                   X.JOB_ID,
                   D.DEPARTMENT_NAME
       
			FROM (SELECT 
				  ROW_NUMBER() over (order by EMPLOYEE_ID DESC) NUM,
        EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER, HIRE_DATE,
					JOB_ID, DEPARTMENT_ID
				FROM
					EMPLOYEES) X, DEPARTMENTS D
					WHERE X.NUM BETWEEN ? AND ?
					AND X.DEPARTMENT_ID= D.DEPARTMENT_ID(+)
				""";
		return JdbcTemplate.selectList(sql, rs -> {
			EmpListDto dto = new EmpListDto();
			dto.setId(rs.getInt("employee_id"));
			dto.setFirstName(rs.getString("first_name"));
			dto.setPhoneNumber(rs.getString("phone_number"));
			dto.setHireDate(rs.getDate("hire_date"));
			dto.setJobId(rs.getString("job_id"));
			dto.setDepartmentName(rs.getString("department_name"));
			return dto;
			
		}, start,end);
		
	}
}
