package com.shadow.usercenter.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.DateUtils
import com.kotlin.base.utils.GlideUtils
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.utils.UserPrefsUtils
import com.qiniu.android.storage.UploadManager
import com.shadow.base.common.BaseConstants
import com.shadow.base.ext.onclick
import com.shadow.base.ui.activity.BaseMvpActivity
import com.shadow.usercenter.R
import com.shadow.usercenter.injection.component.DaggerUserComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.presenter.UserInfoPresenter
import com.shadow.usercenter.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import kotlinx.android.synthetic.main.layout_header_bar.view.*
import org.jetbrains.anko.toast
import java.io.File


/**
 * 注册界面
 */
open class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView, TakePhoto.TakeResultListener {


    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    private var mLocalFileUrl: String? = null
    private var mRemoteFileUrl: String? = null
    private var mUserIcon: String? = null
    private var mUserName: String? = null
    private var mUserSex: String? = null
    private var mUserSign: String? = null
    private var mUserMobile: String? = null

    private val uploadManager: UploadManager by lazy { UploadManager() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        mTakePhoto = TakePhotoImpl(this, this)
        mTakePhoto.onCreate(savedInstanceState)
        initView()
        initData()
    }


    private fun initView() {
        mUserIconView.onclick {
            showAlertView()
        }
        mHeaderBar.mRightTv.onclick {
            toast("修改用户信息")
            mPresenter.editUserInfo(
                    mRemoteFileUrl!!,
                    mUserNameEt.text.toString(),
                    if (mGenderFemaleRb.isChecked) "0" else "1",
                    mUserSignEt.text.toString())
        }
    }


    private fun initData() {
        mUserIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
        mUserName = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        mUserSex = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_GENDER)
        mUserSign = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_SIGN)
        mUserMobile = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_MOBILE)
        mRemoteFileUrl = mUserIcon
        if (mUserIcon != "") {
            GlideUtils.loadImage(this@UserInfoActivity, mUserIcon!!, mUserIconIv)
        }
        mUserNameEt.setText(mUserName)
        if (mUserSex == "0") {
            mGenderMaleRb.isChecked = true
            mGenderMaleRb.isChecked = false
        } else {
            mGenderMaleRb.isChecked = false
            mGenderMaleRb.isChecked = true
        }
        mUserSignEt.setText(mUserSign)
        mUserMobileTv.text = mUserMobile
    }


    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    /*
       弹出选择框，默认实现
       可根据实际情况，自行修改
    */
    private fun showAlertView() {
        AlertView("选择图片", "", "取消", null, arrayOf("拍照", "相册"), this,
                AlertView.Style.ActionSheet, OnItemClickListener { o, position ->
            mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
            when (position) {
                0 -> {
                    createTempFile()
                    mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                }
                1 -> mTakePhoto.onPickFromGallery()
            }
        }
        ).show()
    }

    /*
        获取图片，成功回调
     */
    override fun takeSuccess(result: TResult?) {
        toast("success origin ${result?.image?.originalPath},compress ${result?.image?.compressPath}")
        Log.d("TakePhoto", result?.image?.originalPath)
        Log.d("TakePhoto", result?.image?.compressPath)
        mLocalFileUrl = result?.image?.compressPath
        mPresenter.getUploadToken()
    }

    /*
        获取图片，取消回调
     */
    override fun takeCancel() {
    }

    /*
        获取图片，失败回调
     */
    override fun takeFail(result: TResult?, msg: String?) {
        Log.e("takePhoto", msg)
    }

    /*
        TakePhoto默认实现
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    /*
        新建临时文件
     */
    private fun createTempFile() {
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        this.mTempFile = File(filesDir, tempFileName)
    }


    /**
     * 获取上传图片到七牛云的凭证
     */
    override fun onGetUploadToken(result: String) {
        //上传图片到七牛云
        uploadManager.put(mLocalFileUrl, null, result,
                { key, info, response ->
                    mRemoteFileUrl = BaseConstants.IMAGE_SERVER_ADDRESS + response!!.get("hash")
                    GlideUtils.loadImage(this@UserInfoActivity, mRemoteFileUrl!!, mUserIconIv)
                }, null)
    }


    override fun onEditUser(result: UserInfo) {
        UserPrefsUtils.putUserInfo(result)
        toast("修改成功")
    }
}
