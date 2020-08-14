package com.example.ShopApp.controller

import com.example.ShopApp.model.ShopItem
import com.example.ShopApp.model.SubscriptionTable
import com.example.ShopApp.model.UserTable
import com.example.ShopApp.model.sample
import com.example.ShopApp.repository.SampleRepository
import com.example.ShopApp.repository.ShopItemRepository
import com.example.ShopApp.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("sample")
class sampleController(private val sampleRepository: SampleRepository){

    @PostMapping
    fun addUsers(@RequestBody userTable:MutableList<sample>):String
    {
        sampleRepository.saveAll(userTable)
        return "Items added to the cart :  "+userTable.size+ " with response status: "+ HttpStatus.CREATED
    }



}