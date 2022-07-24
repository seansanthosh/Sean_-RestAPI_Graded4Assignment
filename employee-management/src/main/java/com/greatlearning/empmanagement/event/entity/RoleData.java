package com.greatlearning.empmanagement.event.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
@SequenceGenerator(name="Role_SEQ", sequenceName="role_sequence",allocationSize = 1)
public class RoleData {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Role_SEQ")
    private Long id;
    private String rolevalue;
	public String getRole() {
		return rolevalue;
	}
}
