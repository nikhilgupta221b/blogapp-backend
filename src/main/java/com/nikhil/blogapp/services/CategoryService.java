package com.nikhil.blogapp.services;

import com.nikhil.blogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    // create
    public CategoryDto createCategory(CategoryDto categoryDto);

    // update
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // delete
    public void deleteCategory(Integer categoryId);

    // get
    public CategoryDto getCategory(Integer categoryId);

    // getall
    public List<CategoryDto> getAllCategories();


}
