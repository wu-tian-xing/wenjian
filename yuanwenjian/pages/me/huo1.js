var app=getApp()
Page({

    /**
     * 页面的初始数据
     */
    data: {
      hd:{},
      opid:[],
        sty:0,
        score: '#52BF5F', 
      },
     score: function (e) {
       //点击按钮，样式改变
       let that = this;
       that.setData({
         sty: 1,
         score: '#C9C9C9'
       });
       var hdxqid=e.currentTarget.dataset.id
       console.log(hdxqid)
       var opid=that.data.opidd
      console.log(opid)
      wx.request({
        url: 'http://localhost:8003/ActionController/selectUserAction',
        data:{
          u_id:opid,
          a_id:hdxqid
        }
      })




      },
    
    

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function () {
      var that=this
      that.setData({
        opidd:app.globalData.i
      })
      
      var opid=that.data.opidd
      console.log(opid)
      wx.request({
        url: 'http://localhost:8003/ActionController/selectUserAction',
        data:{
          U_id:opid,
          page:1,
          limit:10,
          statecode:"-1"
        },
        success(res){
          console.log(res.data)
         that.setData({
           hd:res.data
         })
        }
      })

    },

    gotoxiangqing:function()
    {   wx.navigateTo({
        url:'/pages/zuopin/xiangqing',
    })
  
    },

    /**
     * 生命周期函数--监听页面加载
     */
    // onLoad: function (options) {

    // },

    gotoxiangqing1:function()
    {   wx.navigateTo({
        url:'/pages/me/xiangqing1',
    })
  
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