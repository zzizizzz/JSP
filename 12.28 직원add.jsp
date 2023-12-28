<%@page import="hr.dao.EmployeeDao"%>
<%@page import="utils.DateUtils"%>
<%@page import="hr.vo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 URL : http://localhost/sample/hr/emp.add.jsp
	//요청 파라미터
	// firstName, lastName, email, tel1, tel2, tel3
	// hireDate, jobid, salary, commission, depId
	
	// 요청파라미터값 조회하기
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String email = request.getParameter("email");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String hireDate = request.getParameter("hireDate");
	String jobId = request.getParameter("jobId");
	double salary = Integer.valueOf(request.getParameter("salary"));
	double commission = Double.valueOf(request.getParameter("commission"));
	int deptId = Integer.valueOf(request.getParameter("deptId"));
	
	// Employee 객체를 생성하고, 요청파라미터값을 저장한다.
	Employee emp = new Employee();
	emp.setFitstName(firstName);
	emp.setLastName(lastName);
	emp.setEmail(email);
	emp.setPhoneNumber(tel1 + "-" + tel2 + "-" + tel3);
	emp.setHireDate(DateUtils.toDate(hireDate));
	emp.setJobId(jobId);
	emp.setSalary(salary);
	emp.setCommissionPct(commission);
	emp.setDepartmentId(deptId);
	System.out.println(emp);
	
	
	// EMPLOYEES 테이블에 대한 CRUD작업을 담당하는 EMPLOYEEDao객체를 생성한다.
	EmployeeDao empDao = new EmployeeDao();
	// EmployeeDao 객체의 insertEmployee(Employee emp)를 실행한다
	empDao.insertEmployee(emp);
	// 직원 목록을 요청한 list.jsp를 재요청하라는 응답을 보낸다.
	response.sendRedirect("list.jsp");
	

%>
