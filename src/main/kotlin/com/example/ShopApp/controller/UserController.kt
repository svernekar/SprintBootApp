package com.example.ShopApp.controller

import com.example.ShopApp.model.ShopItem
import com.example.ShopApp.model.SubscriptionTable
import com.example.ShopApp.model.UserTable
import com.example.ShopApp.repository.ShopItemRepository
import com.example.ShopApp.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("users")
class UserController(private val userRepository: UserRepository){

    @PostMapping
    fun addUsers(@RequestBody userTable:MutableList<UserTable>):String
    {
        userRepository.saveAll(userTable)
        return "Items added to the cart :  "+userTable.size+ " with response status: "+ HttpStatus.CREATED
    }

    @PostMapping("/{subscriptionid}")
    fun assignsubscriptionID(@RequestBody userID:Long,@PathVariable("subscriptionid")subscriptionid:SubscriptionTable): ResponseEntity<Boolean>
    {
        val item = userRepository.findById(userID)
        return when{

            item.isPresent ->{
                item.get().subscriptionPlan=subscriptionid
                userRepository.save(item.get())
                ResponseEntity(true,HttpStatus.OK)
            }
            else ->
                ResponseEntity(false,HttpStatus.NOT_IMPLEMENTED)

        }
    }
    @GetMapping
    fun getuserdetails():MutableIterable<UserTable>{
        val items=userRepository.findAll()
        return items
    }


}