package com.example.ShopApp.controller

import com.example.ShopApp.model.ShopItem
import com.example.ShopApp.repository.ShopItemRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shopping")
class ShopController(private val shopItemRepository: ShopItemRepository){

    @PostMapping
    fun addshoppingitems(@RequestBody shopItem:MutableList<ShopItem>):String
    {

        shopItemRepository.saveAll(shopItem)
        return "Items added to the cart :  "+shopItem.size+ " with response status: "+ HttpStatus.CREATED
    }
    @GetMapping
    fun getitemdetails():MutableIterable<ShopItem>{
        val items=shopItemRepository.findAll()
        return items
    }


}