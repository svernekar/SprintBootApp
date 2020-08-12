package com.example.ShopApp.controller

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.ShopItem
import com.example.ShopApp.model.SubCategoryTable
import com.example.ShopApp.repository.CategoryRepository
import com.example.ShopApp.repository.SubCategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("category/")
class SubCategoryController(private val subCategoryRepository: SubCategoryRepository){

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @PostMapping("subcategory_for={categoryname}/")
    fun addSubCategoryItems(@RequestBody subcategoryname:String,@PathVariable("categoryname")name:String):String
    {
//        categoryRepository.deleteAll()
//        subCategoryRepository.deleteAll()
        val category=CategoryTable(name)
        categoryRepository.save(category)
        val subcategory=SubCategoryTable(subcategoryname,category)
        subCategoryRepository.save(subcategory)
        return "Items added to the cart :  "+subCategoryRepository.count()+ " with response status: "+ HttpStatus.CREATED
    }

    @GetMapping("subcategory/")
    fun getSubCategoryItems():MutableIterable<SubCategoryTable>{
        val items = subCategoryRepository.findAll()
        return items
    }
}