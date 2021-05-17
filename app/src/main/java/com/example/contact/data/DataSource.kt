package com.example.contact.data

import com.example.contact.R
import com.example.contact.model.CategoryData

class DataSource{

    fun loadCategoryData():List<CategoryData>{
        return listOf(
            CategoryData("Family", R.drawable.ic_family),
            CategoryData("Friends",R.drawable.ic_friends),
            CategoryData("Work", R.drawable.ic_work),
            CategoryData("Customers", R.drawable.ic_money)

        )
    }

}