package com.example.ShopApp.repository

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.SubCategoryTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface SubCategoryRepository: JpaRepository<SubCategoryTable, Long>
{
    fun findBycategoryId(categoryId:CategoryTable):MutableIterable<SubCategoryTable>
}