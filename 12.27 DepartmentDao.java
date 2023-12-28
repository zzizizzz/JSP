package hr.dao;

import java.util.List;

import helper.JdbcTemplate;
import hr.dto.DepartDetailDto;
import hr.vo.Department;

public class DepartmentDao {
	
	public DepartDetailDto getDepartmentDetail(int deptId ) {
		String sql = """
		select d.department_id,
               d.department_name,
               d.manager_id,
               m.first_name,
               d.location_id,
               l.city,
               l.street_address
		from departments d, employees m, locations l
		where d.department_id = ?
        and d.manager_id = m.employee_id
		and d.location_id = l.location_id
				""";
		return JdbcTemplate.selectOne(sql, rs-> {
			DepartDetailDto dto = new DepartDetailDto();
			dto.setId(rs.getInt("department_id"));
			dto.setName(rs.getString("department_name"));
			dto.setManagerId(rs.getInt("manager_id"));
			dto.setManagerName(rs.getString("first_name"));
			dto.setLocationId(rs.getInt("location_id"));
			dto.setCity(rs.getString("city"));
			dto.setStreetAddress(rs.getString("street_address"));

					
			return dto;
		}, deptId);
	}
	
	public List<Department> getAllDepartments(){
		String sql = """
				SELECT
						DEPARTMENT_ID,
						DEPARTMENT_NAME,
						MANAGER_ID,
						LOCATION_ID
					FROM 
						DEPARTMENTS
					WHERE 
						MANAGER_ID IS NOT NULL
						
					ORDER BY
						DEPARTMENT_ID ASC
				""";
		return JdbcTemplate.selectList(sql, rs ->{
			Department dept = new Department();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			return dept;
		});
		
	}
}
