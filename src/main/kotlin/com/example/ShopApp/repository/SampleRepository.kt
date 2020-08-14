package com.example.ShopApp.repository

import com.example.ShopApp.model.CategoryTable
import com.example.ShopApp.model.sample
import org.springframework.data.repository.CrudRepository

interface SampleRepository: CrudRepository<sample, Long>
