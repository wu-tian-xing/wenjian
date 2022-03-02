const app = getApp()
 
Page({
  data: {
    testtrue: true,
  },
  changeContent: function () {
    var isShow = this.data.testtrue;
    this.setData({ testtrue: !isShow })
  },
  onLoad: function () {
    var that = this;
    setInterval(function () {
      that.changeContent();
      console.log("轮播请求1秒触发一次");
    }, 2000)    //代表1秒钟发送一次请求
  },

  gotolantern4:function()
  {   wx.navigateTo({
      url:'/pages/lantern/lantern4',
  })

  },


  gotolantern1:function()
  {   wx.navigateTo({
      url:'/pages/lantern/lantern1',
  })

  },

  gotolantern2:function()
  {   wx.navigateTo({
      url:'/pages/lantern/lantern2',
  })

  },

  gotolantern3:function()
  {   wx.navigateTo({
      url:'/pages/lantern/lantern3',
  })

  },

})
