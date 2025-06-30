package com.nt.service;

import java.util.List;

import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanMgmtService {

	
	
	public String registerTravelPlan(TravelPlan plan);//save Operation
	public Map<Integer,String> getTravelPlanCategories(); //for select operation
	public List<TravelPlan> showAllTravelPlans();//for select operation
	public TravelPlan showTravelPlanById(Integer planId);
	public String updateTravelPlan(TravelPlan plan);//for update Operation
	public String deleteTravelPlan(Integer planId);//delete operation
	public String changeTravelPlanStatus(Integer planId, String status);//change operation
	
	
	
	
}
