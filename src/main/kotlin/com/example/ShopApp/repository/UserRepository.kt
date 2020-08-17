package com.example.ShopApp.repository


import com.example.ShopApp.model.UserTable
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<UserTable, String>
