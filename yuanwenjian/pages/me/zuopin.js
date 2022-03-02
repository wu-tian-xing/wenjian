// pages/me/zuopin.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        //点赞的相关数据
        like:0,
        hasChange: false,
        show:false,
        favor_img: "https://b2.kuibu.net/file/imgdisk/imgs/2022/01/bd8553b8c0033e66.png",
        favor_img2: "https://b2.kuibu.net/file/imgdisk/imgs/2022/01/20cb79abe96c4fe3.png",
  
   
},
      praiseThis: function (e) {
    
        var that = this;
        var hasChange = that.data.hasChange;
    
        if (hasChange !== undefined) {
          var onum = parseInt(that.data.like);
          console.log(hasChange);
          if (hasChange == 'true') {
            that.data.like = (onum - 1);
            that.data.hasChange = 'false';
            that.data.show = false;
          } else {
            that.data.like = (onum + 1);
            that.data.hasChange = 'true';
            that.data.show = true;
          }
          this.setData({
            like: that.data.like,
            hasChange: that.data.hasChange,
            show:that.data.show
          })
        };
        wx.request({
          url: 'https://********',//这里写后台点赞接口的url
          //定义传到后台的数据
          data: {
            userID: app.globalData.openid,//我的ID
            paperID: this.data.id//文章ID
          },
          method: 'get',//定义传到后台接受的是post方法还是get方法
          success: function (res) {
            console.log("成功");
          },
          fail: function (res) {
            console.log("失败");
          }
    
        });
        var pages = getCurrentPages();//当前页面栈
        if (pages.length > 1) {
          var beforePage = pages[pages.length - 2];//获取上一个页面实例对象
          beforePage.changeData();//触发父页面中的方法
        }
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