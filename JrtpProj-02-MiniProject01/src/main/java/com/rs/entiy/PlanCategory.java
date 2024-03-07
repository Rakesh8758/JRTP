package com.rs.entiy;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory 
{
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer CategoryId;
	
	@Column(name="CATEGORY_NAME")
	private String CategoryName;
	
	@Column(name="ACTIVE-SW")
	private String ActiveSw;
	
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
