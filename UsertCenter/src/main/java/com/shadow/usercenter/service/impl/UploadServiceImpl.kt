package com.shadow.usercenter.service.impl

import com.shadow.base.ext.convert
import com.shadow.usercenter.data.repository.UploadRepository
import com.shadow.usercenter.service.UploadService
import rx.Observable
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UploadServiceImpl @Inject constructor() : UploadService {

    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }


}