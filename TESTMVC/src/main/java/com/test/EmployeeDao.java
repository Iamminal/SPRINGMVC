package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;  

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  
	public void insertarow() {
		String sql="insert into demo1 values(122,'Minal')";
		jdbcTemplate.update(sql);
	}
	public int save(Employee emp) {
		String sql="insert into employees values(?,?,?)";
	int result=	jdbcTemplate.update(sql,new Object[]{emp.getId(),emp.getName(),emp.getSalary()});
	return result;
	}
	public Employee getEmployee(int id)
	{
		String sql="Select * from employees where id=?";

		Employee empl=(Employee)jdbcTemplate.queryForObject(sql,new Object[]{id},new RowMapper<Object>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getFloat(3));	
				return employee;
			}		
		});
		return empl;

	}
	public List<Employee> getallEmployees()
	{
		String sql="select * from employees";
		List<Employee> emplist=jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {

			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Employee> list = new ArrayList<Employee>();
				while(rs.next())
				{
					Employee e=new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setSalary(rs.getFloat(3));
					list.add(e);
				}
				return list;
				
			}
			
		});
		return emplist;
		
	}
}
