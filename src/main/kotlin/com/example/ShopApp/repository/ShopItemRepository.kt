package com.example.ShopApp.repository

import com.example.ShopApp.model.ShopItem
import org.springframework.data.repository.CrudRepository

interface ShopItemRepository: CrudRepository<ShopItem, Long>