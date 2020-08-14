package com.example.ShopApp.repository


import com.example.ShopApp.model.SubscriptionTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface SubscriptionRepository: JpaRepository<SubscriptionTable, Long>