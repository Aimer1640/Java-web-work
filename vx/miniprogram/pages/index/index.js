// pages/index/index.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      list:[],
      role:[]
    },
  
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        // console.log(options.role)
        
        var role=options.role
        var that=this;
        that.setData({
          role:role
        })
        console.log(role)
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
      var that=this;
      // console.log(role)
      wx.request({
        url: 'http://localhost:8080/project/findAllProjects',
        method:'GET',
        data:{},
        success:function(res){
          var list=res.data;
        //   console.log(list)
          if(list==null){
            var toastText='获取数据失败';
            wx.showToast({
              title: toastText,
              icon:'',
              duration:2000 //弹出时间
            })
          }else{
            that.setData({
              list:list
            })
            console.log(list)
          }
        }
      })
      wx.request({
        url: 'http://localhost:8080/coursework/findAllCourseWorks',
        method:'GET',
        data:{},
        success:function(res){
          var courseworklist=res.data;
        //   console.log(list)
          if(courseworklist==null){
            var toastText='获取数据失败';
            wx.showToast({
              title: toastText,
              icon:'',
              duration:2000 //弹出时间
            })
          }else{
            that.setData({
              courseworklist:courseworklist
            })
            console.log(courseworklist)
          }
        }
      })
    },
  
    addCoursework:function(){
      wx.redirectTo({
        url: '../AddCoursework/Addcourssework',
      })
    },
   
    deleteProject: function (e) {
      var that=this;
      console.log(e.target.dataset.areaid)
      wx.showModal({
        title: '提示',
        content: '确定要删除[' + e.target.dataset.areaname +']吗？',
        success:function(sm){
          if(sm.confirm){
            wx.request({
              url: 'http://localhost:8090/project/deleteProject',
              data: { projectId: e.target.dataset.areaid},
              method:'GET',
              success:function(res){
                var result=res.statusCode;
                var toastText="删除成功";
                if(result!=200){
                  toastText = "删除失败";
                }else{
                  that.data.list.splice(e.target.dataset.index,1);
                  that.setData({
                    list:that.data.list
                  });
                }
                wx.showToast({
                  title: toastText,
                  icon:'',
                  duration:2000
                });
              }
            })
          }
        }
      })
  
      
    },

    deleteCoursework: function (e) {
      var that=this;
      console.log(e.target.dataset.areaid)
      wx.showModal({
        title: '提示',
        content: '确定要删除[' + e.target.dataset.areaname +']吗？',
        success:function(sm){
          if(sm.confirm){
            wx.request({
              url: 'http://localhost:8090/coursework/deleteCourseWork',
              data: { uploadId: e.target.dataset.areaid},
              method:'GET',
              success:function(res){
                var result=res.statusCode;
                var toastText="删除成功";
                if(result!=200){
                  toastText = "删除失败";
                }else{
                  that.data.courseworklist.splice(e.target.dataset.index,1);
                  that.setData({
                    courseworklist:that.data.courseworklist
                  });
                }
                wx.showToast({
                  title: toastText,
                  icon:'',
                  duration:2000
                });
              }
            })
          }
        }
      })
  
      
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
    
    },
    addProject:function(){
      wx.navigateTo({
        url:'../AddProject/AddProject'
      })
    },
    deleteArea: function (e) {
      var that=this;
      wx.showModal({
        title: '提示',
        content: '确定要删除[' + e.target.dataset.areaname +']吗？',
        success:function(sm){
          if(sm.confirm){
            wx.request({
              url: 'http://localhost:8080/test/delete',
              data: { id: e.target.dataset.areaid},
              method:'GET',
              success:function(res){
  
                var result=res.statusCode;
                var toastText="删除成功";
                if(result!=200){
                  toastText = "删除失败";
                }else{
                  that.data.list.splice(e.target.dataset.index,1);
                  that.setData({
                    list:that.data.list
                  });
                }
                wx.showToast({
                  title: toastText,
                  icon:'',
                  duration:2000
                });
              }
            })
          }
        }
      })
  
      
    }
  })
  