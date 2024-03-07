package com.rs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.Dao.PlanCategoryDao;
import com.rs.Dao.PlanDao;
import com.rs.entiy.Plan;
import com.rs.entiy.PlanCategory;


@Service
public class PlanServiceImp implements PlanService 
{
	@Autowired
	private PlanDao plandao;
	
	@Autowired
	private PlanCategoryDao plancategorydao;

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = plancategorydao.findAll();
		Map<Integer, String> categoryMap=new HashMap<>();
		categories.forEach(category ->
		categoryMap.put(category.getCategoryId(), category.getCategoryName())
		);
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan isSaved = plandao.save(plan);
		
	/*	if(isSaved.getPlanId()!=null)
			return true;
		else
			return false;  */
		/*
		return isSaved.getPlanId()!=null ? true :false ;  */
		
		return isSaved.getPlanId()!=null; // is the advanced way of writing
	
		
		
	}

	@Override
	public List<Plan> getAllPlan()
	{
		return plandao.findAll();
		
	}

	@Override
	public Plan getPlanById(Integer PlanId)
	{
		Optional<Plan> findById = plandao.findById(PlanId);
		if(findById.isPresent())
			return findById.get();
		else
			return null;
		
		
	}

	@Override
	public boolean UpdatePlan(Plan plan)
	{
		Plan save = plandao.save(plan);
		return save.getPlanId()!=null;
		
	}

	@Override
	public boolean DeletePlanById(Integer PlanId) 
	{
		boolean status=false;
		try
		{
			plandao.deleteById(PlanId);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean PlanStatusChange(Integer PlanId, String status) 
	{
		Optional<Plan> findById = plandao.findById(PlanId);
		if(findById.isPresent())
		{
			Plan plan = findById.get();
			plan.setActiveSw(status);
			plandao.save(plan);
			
			return true;
		}
		
		return false;
	}

}
