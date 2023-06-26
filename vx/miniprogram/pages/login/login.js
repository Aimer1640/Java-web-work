// pages/login/login.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      username: '',
      upassword: '',
      user_role: ''
    },
    //获取用户名的值并将值赋给最先定义的初始化变量
    input_username: function (e) {
      this.setData({ username: e.detail.value })
    },
    //跟上面一样
    input_password: function (e) {
      this.setData({ upassword: e.detail.value })
    },
    input_role: function (e) {
        this.setData({ user_role: e.detail.value })
      },
    /**
     * 点击登录按钮时间
     */
    btns: function () {
      console.log("登录获取的参数：" + this.data.username + "," + this.data.upassword + "," + this.data.user_role)
     var that = this;
      wx.request({  
        url: 'http://localhost:8090/test/find',  //请求的URL
        method: "POST",                                        //提交方式
        header: { 'content-type': 'application/x-www-form-urlencoded' }, //设置请求的
        data: {
          'username': that.data.username,
          'password': that.data.password,
          'user_role': that.data.user_role
        },  //请求参数
        success: function (res) {   //接受后台的回调函数
          console.log("回调函数:" + res.data)
          // var resData = res.data;
          var resData = true;
          console.log(that.data.user_role)
          if (resData == true) {
            wx.showToast({    //这是微信小程序里面自带的成功弹窗
              title: '登录成功',  //弹窗里面的内容
              icon: 'success',  //图标
              duration: 2000,   //弹窗延迟的时间
              success: function () {
                wx.navigateTo({  //保留当前页面，跳转到应用内的某个页面
                  url: '../index/index?role='+that.data.user_role,   //跳转的页面
                  //url: '../list/list',
                })
              }
            })
          } else {
            wx.showToast({
              title: '登录失败',
              icon: 'none',
              duration: 2000,
            })
          }
        }
      })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
  
    },
  
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
  
    },
  
    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
  
    },
  
    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {
  
    },
  
    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {
  
    },
  
    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {
  
    },
  
    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
  
    },
  
    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {
  
    }
  })
  