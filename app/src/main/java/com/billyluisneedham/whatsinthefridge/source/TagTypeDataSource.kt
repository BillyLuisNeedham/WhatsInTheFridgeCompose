package com.billyluisneedham.whatsinthefridge.source

import com.billyluisneedham.whatsinthefridge.model.TagType

interface TagTypeDataSource {

    suspend fun add(tagType: TagType)
    suspend fun getAll(): List<TagType>
    suspend fun update(tagType: TagType)
    suspend fun delete(tagType: TagType)

}