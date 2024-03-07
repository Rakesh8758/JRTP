package com.rs.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entiy.Plan;
import com.rs.service.PlanService;

@RestController
public class PlanRestController
{
	@Autowired
	private PlanService planservice;
	
	@GetMapping("/Categories")
	public ResponseEntity<Map<Integer,String>> PlanCategories()
	{
		Map<Integer,String> categories=planservice.getPlanCategories();
		
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	
	@PostMapping("/SavePlan")
	public ResponseEntity<String> SavePlan(Plan plan)
	{
		String responsemsg=" ";
		boolean isSaved = planservice.savePlan(plan);
		if(isSaved)
		{
			responsemsg="plan is saved ";
		}
		else
		{
			responsemsg="Plan is not saved ";
		}
		
		return new ResponseEntity<>(responsemsg,HttpStatus.CREATED);
	}
	
	@GetMapping("/Plan")
	public ResponseEntity<List<Plan>> Plan()
	{
		List<Plan> allPlan = planservice.getAllPlan();
		return new ResponseEntity<>(allPlan,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/plan/{planId}")
	public  ResponseEntity<Plan> editPlanById(@PathVariable Integer PlanId)
	{
		com.rs.entiy.Plan planById = planservice.getPlanById(PlanId);
		
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> UpdatePlan(Plan plan)
	{
		boolean updatePlan = planservice.UpdatePlan(plan);
		String msg=" ";
		if(updatePlan)
		{
			msg="Plan is updated ";
			
		}
		else
		{
			msg="Plan is not Updated ";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@DeleteMapping("plan/{planId}")
	public  ResponseEntity<String> DeleteById(@PathVariable Integer PlanId)
	{
		boolean deletePlanById = planservice.DeletePlanById(PlanId);
		
		String deleteStatus=" ";
		if(deletePlanById)
		{
			deleteStatus="Plan is deleted ";
		}
		else
		{
			deleteStatus="Plan is not deleted ";
		}
		return new ResponseEntity<>(deleteStatus,HttpStatus.OK);
	}
	
	@PutMapping("statusChange")
	public ResponseEntity<String> PlanStatusChage(Integer Plan,String Status)
	{
		boolean planStatusChange = planservice.PlanStatusChange(Plan, Status);
		String msg="";
		if(planStatusChange)
		{
			msg="status changed";
		}
		else
		{
			msg="status not changed";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	
	

}
