package com.example.ShopApp.controller

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.SubCategoryTable
import com.example.ShopApp.repository.CategoryRepository
import com.example.ShopApp.repository.SubCategoryRepository
import org.hibernate.criterion.Example
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("category/")
class SubCategoryController{

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var subCategoryRepository: SubCategoryRepository

    // Add new category with products
    @PostMapping("subcategory_for={categoryname}/")
    fun addSubCategoryItems(@RequestBody subcategoryname:List<String>,@PathVariable("categoryname")name:String):String
    {
//        categoryRepository.deleteAll()
//        subCategoryRepository.deleteAll()
        val category=CategoryTable(name)


        var itemexists:Boolean=categoryRepository.existsByCategoryName(name)
        if (!itemexists)
            categoryRepository.save(category)
            val subCategoryInstances:ArrayList<SubCategoryTable> = ArrayList()
            for (i in subcategoryname.indices)
                subCategoryInstances.add(SubCategoryTable(subcategoryname[i],category))

            subCategoryRepository.saveAll(subCategoryInstances)
            return "Items added to the cart :  "+subCategoryRepository.count()+ " with response status: "+ HttpStatus.CREATED
        return  "Category already exists"

    }



    @GetMapping("subcategory/")
    fun getSubCategoryItems():MutableIterable<SubCategoryTable>{
        val items = subCategoryRepository.findAll()
        return items
    }
}