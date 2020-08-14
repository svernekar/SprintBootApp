package com.example.ShopApp.controller

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.ShopItem
import com.example.ShopApp.model.SubscriptionTable
import com.example.ShopApp.model.UserTable
import com.example.ShopApp.repository.CategoryRepository
import com.example.ShopApp.repository.ShopItemRepository
import com.example.ShopApp.repository.SubscriptionRepository
import com.example.ShopApp.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("subscription")

class SubscriptionController(private val subscriptionRepository: SubscriptionRepository){

    @PostMapping
    fun addSubscriptionPlan(@RequestBody subscriptionTable:MutableList<SubscriptionTable>):String
    {
        subscriptionRepository.saveAll(subscriptionTable)
        return "Subscription/s added : "+ subscriptionTable.size + " with response status: "+ HttpStatus.CREATED
    }
    @GetMapping
    fun getSubscriptions():MutableIterable<SubscriptionTable>{
        val items = subscriptionRepository.findAll()
        return items
    }


}