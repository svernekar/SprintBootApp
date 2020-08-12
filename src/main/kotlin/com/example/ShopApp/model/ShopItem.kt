package com.example.ShopApp.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
data class ShopItem(var name:String ="",
                       var isAvailable:Boolean=false,
                       @Id
                       @GeneratedValue(strategy = GenerationType.AUTO)
                       var Id:Long =0)
@Entity
data class UserTable(
        var FirstName: String = "",
        var LastName: String = "",
        var Address: String = "",
        var City: String = "",
        var EmailId: String = "",
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
        var id:UUID?=UUID.randomUUID()
)

@Entity
data class CategoryTable(
        var CategoryName: String = "",
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var CategoryId: Long = 0
)


@Entity
data class SubCategoryTable(
        var SubCategoryName: String = "",
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name = "category_id")
        var CategoryId: CategoryTable?=null,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var SubCategoryId: Long = 0)


@Entity @Table(name = "product")
data class Product(
        var name:String ="",
        var price:Double=0.0,
        var isAvailable:Boolean=false,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "SubCategoryName")
        var category: SubCategoryTable? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var Id:Long =0)





