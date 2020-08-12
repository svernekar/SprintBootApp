package com.example.ShopApp.controller

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.ShopItem
import com.example.ShopApp.model.UserTable
import com.example.ShopApp.repository.CategoryRepository
import com.example.ShopApp.repository.ShopItemRepository
import com.example.ShopApp.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("category")

class CategoryController(private val categoryRepository: CategoryRepository){

    @PostMapping
    fun addCategory(@RequestBody categoryTable:MutableList<CategoryTable>):String
    {
        categoryRepository.saveAll(categoryTable)
        return "Category/s added : "+ categoryTable.size + " with response status: "+ HttpStatus.CREATED
    }
    @GetMapping
    fun getCategoryList():MutableIterable<CategoryTable>{
        val items = categoryRepository.findAll()
        return items
    }


}