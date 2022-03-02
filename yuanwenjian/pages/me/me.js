var app = getApp()
// pages/zuopin/zuopin.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      opid:[],
      
       

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function () {

      
    
      },



      getWxInfo:function(){
        var that=this;
         wx.getUserProfile({
           desc: '完善用户信息',
         
           success(res){
               console.log(res.userInfo)
               that.setData({
                 user:res.userInfo
               })
              
           }
         })
 
         wx.login({
           
           success(res){
          
             console.log("code:"+res.code)
             wx.request({
               url: 'https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code',
               data:{
                 appid:'wx88142ca519028d06',
                 secret:'6fbdde48105ca6b1d8502e89d5c802c0',
                 js_code:res.code,
                 grant_type:'authorization_code'
               },
               methed:"GET",
               success:function(res){
                 console.log("openid:"+ res.data.openid)
                 that.setData({
                   opid:res.data.openid
                 })
               var openid=that.data.opid
                console.log(openid)
               app.globalData.i=openid

                 wx.request({
                  url: '',
                  data:{
                    openid:'op',
                    nickName:'user.nackName',
                    avatarUrl:'user.avatarUrl'
                  },
         
                })
         
               
               
                
               
               }
             })
         



           }
         })
       
         
 
     },


     
 

    loginOut(){
        this.setData({
            user:null
        })

    },



    gotozuopin:function()
    {   wx.navigateTo({
        url:'/pages/me/zuopin',
    })
  
    },
    gotohuodong:function()
    {   wx.navigateTo({
        url:'/pages/me/huodong',
    })
  
    },
    gotokefu:function()
    {   wx.navigateTo({
        url:'/pages/me/kefu',
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