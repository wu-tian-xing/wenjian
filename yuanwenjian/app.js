App({



  data:{
    
  },

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  // onLaunch: function () {

  //  wx.getSetting({
  //    success:res=>{
  //      console.log(res.authSetting);
  //      if(res.authSetting['scope.userInfo']){
  //        console.log('shouquanguo');
  //         wx.getUserInfo({
            
  //           success:data=>{
  //             console.log(data);
  //           }
  //         })
  //      }else{

  //      }
  //    }
  //  })

          //查找数据库用户是否有这个记录
          


     //   },
      


     globalData:{
       i:''
     },

  

 

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  }
})