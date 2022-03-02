
Page({

    /**
     * 页面的初始数据
     */
    data: {
        mszq:[]

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

        var that=this
        wx.request({
          url: 'http://116.62.214.111:8001/FestivalActionController/selectFestivalAction',
          
          data:{
          festival_id:3,
              actions:'美食',
              page:1,
              limit:10
          },
          success:function(res){
           
              console.log(res.data.data)
              that.setData({
                  mszq:res.data.data
              })
          },
          fail:(res)=>{
            console.log(res)
          }
        })

    },
    gotonew33:function(e)
    {
    let ID=e.currentTarget.dataset.id
    console.log(ID);
       wx.navigateTo({
        url:'/pages/newyear1/new33?ID='+ID 
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