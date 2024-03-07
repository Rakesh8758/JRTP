package com.rs.entiy;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN_MASTER")
public class Plan 
{
	@Id
	@Column(name="PLAN_ID")
	private Integer PlanId;
	
	@Column(name="PLAN_NAME")
	private String PlanName;
	
	@Column(name="START_DATE")
	private LocalDate StartDate;
	
	@Column(name="END_DATE")
	private LocalDate EndDate;
	
	@Column(name="ACTIVE_SW")
	private String ActiveSw;
	
	@Column(name="CATEGORY_ID")
	private Integer CategoryId;
	
	@Column(name="CREATE_BY")
	private String CreateBy;
	
	@Column(name="UPDATE_BY")
	private String UpdatedBy;
	
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@Column(name="UPDATED_DATE", insertable=false)
	@UpdateTimestamp
	private LocalDate UpdataedDate;

}
