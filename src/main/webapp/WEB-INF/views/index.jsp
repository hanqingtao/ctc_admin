<%@ page contentType="text/html;charset=UTF-8"%>
 <%@ include file="/WEB-INF/views/center/common/meta.jsp"%> 
 
 <link href="${ctxStatic}/css/index.css" rel="stylesheet" type="text/css" />
 
 
 <head>
    <meta name="renderer" content="webkit">
 </head>
 <!-- 
  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.10.2.min.js"></script>
  -->
 <script type="text/javascript" src="${ctxStatic}/bootstrap/3.3.5/bootstrap.js"></script>
 <script type="text/javascript" src="${ctxStatic}/jquery/jquery.flexslider-min.js" ></script>
 <script type="text/javascript" src="${ctxStatic}/jquery/jquery.placeholder.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/map/baiduDitu.js"></script>
<!-- <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=XOqpyuEGGwap3D2p6j4NIR2BrogIxDpX&v"></script> -->
<script type="text/javascript" src="${ctxStatic}/map/TextIconOverlay_min.js"></script>
<script type="text/javascript" src="${ctxStatic}/map/MarkerClusterer_min.js"></script>
<script type="text/javascript" src="${ctxStatic}/map/AreaRestriction_min.js"></script>

<body style="background:#fff;">
<span id="message" class="uploadFile">${message }</span>
<div class="header">
	<%@ include file="/WEB-INF/views/center/common/top.jsp"%> 
    <%@ include file="/WEB-INF/views/center/common/nav.jsp"%> 
</div>

 <div >
   <div id="allmap"></div>
 </div>


 	<!--
 <div id="pageContaienr">
 	<div id="test"></div>
 	<div id="Flexslider" class="flexslider">
             <ul class="slides" id="bannerContainer">
                 
                 
             </ul>
        </div>
 	
	<div class="main">
    <div class="all" id='all'>
        <div class="screen">
            <ul id="screenContainer"></ul>
        </div>
         <ol >
        </ol>
    </div>
    <div class="gonggao">
        <div class="top" id="newsTitleContainer">
            <div id="newsTitle"></div>
            <a target="_blank" href="javascript:moreNews();">更多>></a>
      </div>
       <div class="newsContainerContent" id="newsContainer">
        </div>
    </div>
	<div class="denglu">
        <div class="top">
            <p class="on">我要登录</p>
        </div>
        <input type="button" class="button1"  value="代理机构入口"  onclick="qualificationManagementEntrance()"/>
        <input type="button" class="button2"  value="管理员入口"  onclick="adminOpen()"/>
        <input type="button" class="button3"  value="新机构快速注册入口" onclick="register()"/>
        <input type="button" class="button4"  value="代理机构信息公示" onclick="agentInfoEnter()"/>
    </div>
    <div class="clear"></div>
    <div class="banner1"></div>
    <div class="indexxwdl left">
    	<div class="top">
            <p class="on">名录公示</p>
            <a  href="javascript:moreAgent();">更多>></a>
        </div>
        <dl>
         <c:forEach items="${orgList}" var="org">
        	<dt><a href="javascript:lookOrgDetails(${org.id});" >${org.name }</a></dt>
            <dd> 近三年业绩：<fmt:formatNumber value="${org.recentMoney}" pattern="#,#00.0#"/><c:if test="${not empty org.recentMoney}"> 万元</c:if>　 　变更时间：<fmt:formatDate value="${org.createDate}" pattern="yyyy-MM-dd"/>　　 　所在区域：${org.area.name} </dd>
		 </c:forEach> 
        </dl>
    </div> 
    <div class="indexxwdl right">
    	<div class="top">
            <p class="on">项目公示</p>
            <a href="javascript:moreProject();">更多>></a>
        </div>
        <dl>
              <c:forEach items="${projectList}" var="project">
        	<dt><a href="javascript:;" onclick="lookProjectDetails(${project.id})">${project.name}</a></dt>
            <dd> 中标金额：<fmt:formatNumber value="${project.projectFlow.bidMoney }" pattern="#,#00.0#"/><c:if test="${not empty project.projectFlow.bidMoney}"> 万元</c:if>　　　　中标单位：${project.projectFlow.bidUnit }　　  　　　中标时间：<fmt:formatDate value="${project.bidTime}" pattern="yyyy-MM-dd"/>　 　　　 </dd>
			 </c:forEach>
        </dl>
    </div>
    <div class="tongji_left">
    	<div class="top">
        	<p class="on">招标业绩统计</p><span>（统计数据为中央投资项目）</span>
        </div>
        <div class="left_nav" id="performanceStatisticsTtileContainer">
       		<p class="on" onclick="javascript: $('#scrollbox1').find('p').first().click();">地区</p>
        	<p onclick="javascript: $('#div_p_year').find('p').first().click();" >中标金额</p>
            <p onclick="javascript: $('#natureTitleContainer').find('p').first().click();" >企业性质</p>
        </div>
        
        <div id="performanceStatisticsContentContainer">
	          <dl >
	                <div class="jian_left"><img src="${ctxStatic}/images/leftjt1.png" id="arrLeft1" /></div>
			        <div class="right_nav" id="scrollbox1">
			        </div>
			        <div class="jian_right"><img src="${ctxStatic}/images/rightjt1.png" id="arrRight1"/></div>
			        <div id="areaOrgContentContainer"></div>
			        <div>
			        	<ul id="div_ul_area">
				        	<li>地区业绩统计数据加载中...</li>
				        </ul>
			        </div>
	         </dl> 
	          <dl style="display:none">
			        <div class="right_nav" id="div_p_year">
			        	<p onclick="javascript:indexStatic_com('year','2017')" >2017</p>
			        	<p onclick="javascript:indexStatic_com('year','2016')" >2016</p>
			        	<p onclick="javascript:indexStatic_com('year','2015')" >2015</p>
			        	<p  onclick="javascript:indexStatic_com('year','2014')">2014</p>
			        	 
			        </div>
			        <div>
				 		<ul id="div_ul_year">
							<li>中标金额统计数据加载中...</li>
				        </ul>
			        </div>
	         </dl>  
	           
	          <dl style="display:none">
			        <div class="right_nav" id="natureTitleContainer"></div>
			        <div>
				 		<ul id="div_ul_nature">
				        	<li>企业性质统计数据加载中...</li>
				        </ul>
			        </div>
	         </dl> 
         </div>
    </div>
    <div class="tongji_right">
    	<div class="top"><p class="on">区域统计</p></div>
    	<div id="div_area_top">
    	</div>
    	<div id="div_area_down">
    	</div>
    </div>
    <div class="clear"></div>
    <div class="youlian">
    	<div class="top">
            <p class="on">友情链接</p>
        </div>
        <a href="http://www.miit.gov.cn/" target="_blank">中华人民共和国工业和信息化部</a>
        <div class="clear"></div>
    </div>
</div>
 </div>
-->
 
   <%@ include file="/WEB-INF/views/center/common/footer.jsp"%>
    <style type="text/css">
                #allmap {
                    width: 1024px;
                    height: 768px;
                    margin: 5px auto;
                }
                .anchorBL {
                    display: none;
                }
                 #msg{
                  width:100px;
                  height:20px;
                  margin-left:15px;
                  color:red;
                  display:none;
                 }
 
         </style>
   <script type="text/javascript">
       	
        	// 百度地图API功能
            var map = new BMap.Map("allmap", {
                   minZoom:5,maxZoom:16,enableMapClick : false
            });
        	map.centerAndZoom("锡林浩特",11);      // 初始化地图,用城市名设置地图中心点
          //  map.centerAndZoom(new BMap.Point(105.331398, 37.897445), 5); //设置 中国
            map.enableScrollWheelZoom();
            //map.disableDragging(); 
            //添加放大和缩小控件
            map.addControl(new BMap.NavigationControl());
            var oveCtrl = new BMap.OverviewMapControl();
            map.addControl(oveCtrl);
            oveCtrl.changeView();
            oveCtrl.setSize(new BMap.Size(200, 200));

            var myStyles = [{
                url:  '../static/images/big11.png',
                size: new BMap.Size(38, 68),
                opt_anchor: [16, 0],
                textColor: '#ffffff',
                opt_textSize: 10
            }];
           
            var myIcon2 = new BMap.Icon("../static/images/red.png", new BMap.Size(30, 40));
            //添加聚合效果。
            var markersTemp = new Array();
	        var markerClusterer = new BMapLib.MarkerClusterer(map, {
	               markers : markersTemp
	        });
	        markerClusterer.setStyles(myStyles);
	        //默认初始化 站点
	        //searchStation();
	        
	        function searchStation(){
                alert("sera");
               /*  var orgName=$("#orgName").val();
               
                var options=$("#orgArea option:selected");  //获取选中的项
                var areaCode=options.val();   //拿到选中项的值 */
                var category="";
                var orgName="";
                var areaCode = "";
                var t = "${ctxFront}/node/getAllNodeList";
                alert("ac"+t)
               /* if(areaCode == ""&&(orgName == "" ||orgName.trim().length==0)){
                    alert("请选择省份!");
                    return ;
                }*/
                
                /*if(orgName.length==0&&orgName.trim().length==0&&areaCode==""){
                    //alert("请输入要搜索学校的名称或者省份");
                }*/
                
               /*  if($("#btn_1").val()=="高校"){
                    category=101;
                } */
                 //这里是按学校名查,地区和类型为默认
                 map.clearOverlays();
                  
                 $.ajax({
                       type : "get",
                       url : "${ctxFront}/node/getAllNodeList",
                       data : {
                            "orgName":orgName,
                            "areaCode":areaCode,
                             "category":category
                       },
                       success : function(data) {
                    	   //alert(data);
                            if(data.length==0){
                                $("#msg").html("未查到相关信息").show();
                            }else{
                            $("#msg").hide();
                            }
                            init(data);
                       },
                       error : function(e) {
                              $("#msg").html("请重新搜索").show();
                               
                       }
                   });
                 } 
	        
            function init(data){
            	
            	//initMap();
                var markers = new Array();
                $.each(data,function(i, item) {
                	alert(item.longitude);
                	alert(item.latitude);
                    var point = new BMap.Point(item.longitude, item.latitude);
                    var marker = new BMap.Marker(point);
                                        marker.setIcon(myIcon2)
                                        var content = "<h4 style=' '>"+item.customer_name+"</h4>"+"<a href='http://"+item.domain+"' target='_blank'><img style='width:220px;height:55px' src='"+item.logo_path+"'/>";
                                        addClickHandler(content, marker); //添加点击事件
                                        markers.push(marker);
                                        
                });
               
                markerClusterer.clearMarkers();
                markerClusterer.addMarkers(markers);
                var opts = {
                    width : 230, // 信息窗口宽度
                    height : 80, // 信息窗口高度
                    enableMessage : true
                //设置允许信息窗发送短息
                };

                function addClickHandler(content, marker) {
                    marker.addEventListener("click", function(e) {
                        openInfo(content, e)
                    });
                }
                function openInfo(content, e) {
                    var p = e.target;
                    var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                    var infoWindow = new BMap.InfoWindow(content, opts); // 创建信息窗口对象
                    map.openInfoWindow(infoWindow, point); //开启信息窗口
                }
            }
        </script>
        
          <script type="text/javascript" >
          	$(document).ready(function(){
          		alert("redady!");
          		searchStation();
          		
          	});
          
          </script>
 </body>
 

 <!-- 
 <script type="text/javascript" src="${ctxStatic}/js/index.js"></script>
 <script type="text/javascript" src="${ctxStatic}/js/Designer.js"></script>
  -->
</html>
