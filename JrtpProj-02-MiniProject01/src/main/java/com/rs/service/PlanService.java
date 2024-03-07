package com.rs.service;

import java.util.List;
import java.util.Map;

import com.rs.entiy.Plan;

public interface PlanService
{
	public Map<Integer,String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
		
	public List<Plan> getAllPlan();
	
	public Plan getPlanById(Integer PlanId);
	
	public boolean UpdatePlan(Plan plan);
	
	public boolean DeletePlanById(Integer PlanId);
	
	public boolean PlanStatusChange(Integer PlanId,String status);

}
