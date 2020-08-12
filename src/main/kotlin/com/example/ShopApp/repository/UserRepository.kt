package com.example.ShopApp.repository


import com.example.ShopApp.model.UserTable
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserTable, Long>