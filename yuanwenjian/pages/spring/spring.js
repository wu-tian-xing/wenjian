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
  
gotospring2:function()
  {   wx.navigateTo({
      url:'/pages/spring/spring2',
  })

  },
  gotospring3:function()
  {   wx.navigateTo({
      url:'/pages/spring/spring3',
  })

  },
  gotospring4:function()
  {   wx.navigateTo({
      url:'/pages/spring/spring4',
  })

  },
  gotospring5:function()
  {   wx.navigateTo({
      url:'/pages/spring/spring5',
  })

  },
  gotospring6:function()
  {   wx.navigateTo({
      url:'/pages/spring/spring6',
  })

  },
  gotospring7:function()
  {   wx.navigateTo({
      url:'/pages/spring/spring7',
  })

  },

  








})
