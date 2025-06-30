package com.javaexpress.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.helper.CategoryMappingHelper;
import com.javaexpress.models.Category;
import com.javaexpress.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryDto save(CategoryDto categoryDto) {
		log.info("CategoryService save");
		
		Category parentCategory=null;
		if(categoryDto.getParentCategoryDto()!=null) {
			Integer id=categoryDto.getParentCategoryDto().getCategoryId();
			parentCategory=categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			 
		}
		
		Category category=CategoryMappingHelper.map(categoryDto);
		if(parentCategory!=null) {
			category.setParentCategory(parentCategory);
			
		}
		Category dbCategory=categoryRepository.save(category);
		return CategoryMappingHelper.map(dbCategory);
		
		}
	public List<CategoryDto>findAll(){
		return categoryRepository.findAll().stream().map(CategoryMappingHelper::map).distinct().collect(Collectors.toList());
	}
}
