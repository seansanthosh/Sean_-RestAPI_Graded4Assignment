package com.greatlearning.empmanagement.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp")
@SequenceGenerator(name="EMP_SEQ", sequenceName="employee_sequence",allocationSize = 1)
public class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMP_SEQ")
    private Long id ;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
	public void setFirstName(String fName) {
		this.firstName=fName;
		
	}
}
