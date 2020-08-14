package com.example.ShopApp.controller

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.SubCategoryTable
import com.example.ShopApp.model.SubscriptionTable
import com.example.ShopApp.repository.CategoryRepository
import com.example.ShopApp.repository.SubCategoryRepository
import org.hibernate.criterion.Example
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("category/")
class SubCategoryController{

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var subCategoryRepository: SubCategoryRepository

    @PostMapping("subcategory_for={categoryname}/")
    fun addCategorywithSubcategory(@RequestBody subcategoryname:HashMap<String,Double>,@PathVariable("categoryname")name:String):String
    {
        //Format to be sent from Postman as text {"Product1":22.0,"Product2":55.0}
        val category=CategoryTable(name)
        var itemexists:Boolean=categoryRepository.existsByCategoryName(name)
        if (!itemexists)
            categoryRepository.save(category)
            val subCategoryInstances:ArrayList<SubCategoryTable> = ArrayList()
            subcategoryname.forEach {
            k, v ->subCategoryInstances.add(SubCategoryTable(k,v,category))
        }
            subCategoryRepository.saveAll(subCategoryInstances)
            return "Items added to the cart :  "+subCategoryRepository.count()+ " with response status: "+ HttpStatus.CREATED
        return  "Category already exists"

    }

    @GetMapping("subcategory/")
    fun getCategorywithSubcategory():MutableIterable<SubCategoryTable>{
        val items = subCategoryRepository.findAll()
        return items
    }

    @PostMapping("/{subcategoryid}")
    fun updatesubcategorydetails(@RequestBody subcategorydetails:SubCategoryTable,@PathVariable("subcategoryid")subcategoryid:Long): ResponseEntity<Boolean>
    {
        val item = subCategoryRepository.findById(subcategoryid)
        return when{

            item.isPresent ->{
                item.get().SubCategoryName=subcategorydetails.SubCategoryName
                item.get().price=subcategorydetails.price
                subCategoryRepository.save(item.get())
                ResponseEntity(true,HttpStatus.OK)
            }
            else ->
                ResponseEntity(false,HttpStatus.NOT_IMPLEMENTED)

        }
    }
}