package com.example.ShopApp.model

import com.example.ShopApp.repository.StringPrefixedSequenceIdGenerator
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.GenericGenerator
import org.hibernate.id.enhanced.SequenceStyleGenerator
import java.util.*
import javax.persistence.*
import org.hibernate.annotations.Parameter

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
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
        @GenericGenerator(
                name = "book_seq",
                strategy = "com.example.ShopApp.helper.StringPrefixedSequenceIdGenerator",
                parameters = [

                    Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SHOP_"),
                    Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") ])
        var id:String?,
        @OneToOne
        var subscriptionPlan:SubscriptionTable?=null
//        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//        var Id:Long =0,
//        @GeneratedValue(generator = "uuid2")
//        @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")//
//        var id:UUID?=UUID.randomUUID(),
     )

@Entity
data class CategoryTable(
        var categoryName: String = "",
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var categoryId: Long = 0)


@Entity
data class SubCategoryTable(
        var SubCategoryName: String = "",
        var price: Double=0.0,
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name = "category_id")
        var categoryId: CategoryTable?=null,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var subCategoryId: Long = 0)

@Entity
data class sample(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
        @GenericGenerator(
                name = "book_seq",
                strategy = "com.example.ShopApp.repository.StringPrefixedSequenceIdGenerator",
                parameters = [

                    Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CID_"),
                    Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") ])
        var id:String?,
        var name:String=""
//        @Id
//        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//        @GenericGenerator(name = "sequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//                parameters = [
//                    Parameter(name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "APP"),
//                    Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
//                    Parameter(name = SequenceStyleGenerator.OPT_PARAM, value = "pooled"),
//                    Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1123")
//
//                ]
//        )
//        var id: Long? = null,
//        var name:String = ""

)


@Entity @Table(name = "SubscriptionTable")
data class SubscriptionTable(
                             var subscriptionPlan:String="",
                             @Temporal(TemporalType.DATE)
                             var startDate:Date,
                             @Temporal(TemporalType.DATE)
                             var endDate:Date,
                             @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var subscriptionId:Long=0,
                             @ManyToOne(fetch = FetchType.EAGER)
                             var user:UserTable?=null)





