package com.example.ShopApp.repository

import com.example.ShopApp.model.CategoryTable
import org.springframework.data.repository.CrudRepository

interface CategoryRepository: CrudRepository<CategoryTable, Long>