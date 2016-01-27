/**
 * 
 */
function isNum(numString){
		var re = /^[1-9]+[0-9]*]*$/;
		if (re.test(numString)){
			return true;
		}else{
			return false;
		}
	}

function loadRank(rankPage){
			
			if (isNum(rankPage)){
			$.ajax({
			url:'getRank?rankPage='+rankPage,
			type:"get",
			dataType:"json",
			async:false,
			error: function(){
				alert('获取数据失败');
				},
			success: function(data){
				
				if (data != ""){
					//这里一定要把data转换成json格式之后再使用，否则会出错
					data = $.parseJSON(data);
					$("#rank").empty();
					var tmprankPage = 0 ;
					//这里设置前一页
					if (data.rankPage-1 <=  0){
						tmpRankPage = 1;
					}else{
						tmpRankPage = data.rankPage-1;
					}
					$("#prevRankPage").attr("href","javascript:void(0)");
					$("#prevRankPage").attr("onClick","javascript:loadRank("+tmpRankPage+")");
					
					//设置后一页
					if (data.rankPage >= data.rankMaxPage){
						tmpRankPage = data.rankMaxPage;
					}else{
						tmpRankPage = data.rankPage+1;
					}
					
					$("#nextRankPage").attr("href","javascript:void(0)");
					$("#nextRankPage").attr("onClick","javascript:loadRank("+tmpRankPage+")");
					
					//设置分页数
					$("#rankPagination").empty();
					for (var i = data.rankBeginIndex;i<=data.rankEndIndex;i++){
						var li = $('<li></li>');
						var a = $('<a></a>').text(i);
						a.attr("href","javascript:void(0)");
						a.attr("onClick","javascript:loadRank("+i+")");
						li.append(a);
						$("#rankPagination").append(li);	
					}
					
					//设置表头
					var tr = $('<tr></tr>');
					var td0 = $('<td></td>').text("");
					var td1 = $('<td></td>').text("排名");
					var td2 = $('<td></td>').text("用户名");
					var td3 = $('<td></td>').text("成绩");
					tr.append(td0,td1,td2,td3);
					$("#rank").append(tr);
					
					$.each(data.scores,function(i,item){
						
						var tr = $('<tr></tr>');
						var td0 = $('<td></td>').text("");
						var td1 = $('<td></td>').text((data.rankPage-1)*5+i+1);
						var td2 = $('<td></td>').text(item.username);
						var td3 = $('<td></td>').text(item.score);
						tr.append(td0,td1,td2,td3);
						$("#rank").append(tr);		
						});
					}
				}
				
			});
			}else{
				alert("您的输入非法！");
			}
	}

	function loadWeeklyRank(weeklyRankPage){
		if (isNum(weeklyRankPage)){
		$.ajax({
		url:'getWeeklyRank?weeklyRankPage='+weeklyRankPage,
		type:"get",
		dataType:"json",
		async:false,
		error: function(){
			alert('获取数据失败');
			},
		success: function(data){
			if(data != ""){
			//这里一定要把data转换成json格式之后再使用，否则会出错
			data = $.parseJSON(data);
			$("#weeklyRank").empty();
			var tmpWeekRankPage = 0;
			//这里设置前一页
			if (data.weeklyRankPage-1 <= 0){
				tmpWeeklyRankPage = 1;
			}else{
				tmpWeeklyRankPage = data.weeklyRankPage-1;
			}
			$("#prevWeeklyRankPage").attr("href","javascript:void(0)");
			$("#prevWeeklyRankPage").attr("onClick","javascript:loadWeeklyRank("+tmpWeeklyRankPage+")");
			
			//设置后一页
			if (data.weeklyRankPage  >= data.weekRankMaxPage){
				tmpWeeklyRankPage = data.weekRankMaxPage;
			}else{
				tmpWeeklyRankPage = data.weeklyRankPage+1;
			}
			
			$("#nextWeeklyRankPage").attr("href","javascript:void(0)");
			$("#nextWeeklyRankPage").attr("onClick","javascript:loadWeeklyRank("+tmpWeeklyRankPage+")");
			
			//设置分页数
			$("#weeklyRankPagination").empty();
			for (var i = data.weeklyRankBeginIndex;i<=data.weeklyRankEndIndex;i++){
				var li = $('<li></li>');
				var a = $('<a></a>').text(i);
				a.attr("href","javascript:void(0)");
				a.attr("onClick","javascript:loadWeeklyRank("+i+")");
				li.append(a);
				$("#weeklyRankPagination").append(li);	
			}
			
			//设置表头
			var tr = $('<tr></tr>');
			var td0 = $('<td></td>').text("");
			var td1 = $('<td></td>').text("排名");
			var td2 = $('<td></td>').text("用户名");
			var td3 = $('<td></td>').text("成绩");
			tr.append(td0,td1,td2,td3);
			$("#weeklyRank").append(tr);
			
			$.each(data.Weeklyscores,function(i,item){
				
				var tr = $('<tr></tr>');
				var td0 = $('<td></td>').text("");
				var td1 = $('<td></td>').text((data.weeklyRankPage-1)*5+i+1);
				var td2 = $('<td></td>').text(item.username);
				var td3 = $('<td></td>').text(item.score);
				tr.append(td0,td1,td2,td3);
				$("#weeklyRank").append(tr);		
				});
			}
		}
		});
		}else{
			alert("您的输入非法！");
		}
}

function loadNoticeList(noticePage){
	
	if (isNum(noticePage)){
		
		$.ajax({
		url:'getNoticeList?noticePage='+noticePage,
		type:"get",
		dataType:"json",
		async:false,
		error: function(){
			alert('获取数据失败');
			},
		success: function(data){
			if (data != null){
			//先把数据清空
			$("#notices").empty();
			
			//这里一定要把data转换成json格式之后再使用，否则会出错
			data = $.parseJSON(data);
			
			var tmpNoticePage = 0;
			//这里设置前一页
			if (data.noticePage-1 <= 0){
				tmpNoticePage = 1;
			}else{
				tmpNoticePage = data.noticePage-1;
			}
			$("#prevNoticePage").attr("href","javascript:void(0)");
			$("#prevNoticePage").attr("onClick","javascript:loadnotice("+tmpNoticePage+")");
			
			//设置后一页
			if (data.noticePage  >= data.noticeMaxPage){
				tmpNoticePage = data.noticeMaxPage;
			}else{
				tmpNoticePage = data.noticePage+1;
			}
			
			$("#nextNoticePage").attr("href","javascript:void(0)");
			$("#nextNoticePage").attr("onClick","javascript:loadNoticeList("+tmpNoticePage+")");
			
			//设置分页数
			$("#noticePagination").empty();
			for (var i = data.noticeBeginIndex;i<=data.noticeEndIndex;i++){
				var li = $('<li></li>');
				var a = $('<a></a>').text(i);
				a.attr("href","javascript:void(0)");
				a.attr("onClick","javascript:loadNoticeList("+i+")");
				li.append(a);
				$("#noticePagination").append(li);	
			}
			
			$.each(data.notices,function(i,item){
				
				//输出获取到的公告
				var divAccordion = $("<div class=\"accordion accordion-group\" style=\"margin-bottom:20px;\"></div>");
				//处理公告标题
				var divAccordionHeading  = $("<div class=\"accordion-heading text-center\"></div>");
				var h4Title = $("<h4></h4>").text(item.noticetitle);
				divAccordionHeading.append(h4Title);
				divAccordion.append(divAccordionHeading);
				
				//处理公告内容
				var divAccordionInner = $("<div class=\"accordion-inner\"></div>");
				var pContent = $("<p></p>").text(item.noticecontent);
				divAccordionInner.append(pContent);
				divAccordion.append(divAccordionInner);
				
				//处理发布时间
				var divModalFooter = $("<div class=\"modal-footer\"></div>");
				var pPosttime = $("<p class=\"pull-right\"></p>").text(item.posttime);
				divModalFooter.append(pPosttime);
				divAccordion.append(divModalFooter);
						
				$("#notices").append(divAccordion);
				
			});
			}
			}
		});
		}else{
			alert("您的输入非法！");
		}
}
	
function loadNotice(){
	$.ajax({
	url:'getLastestNotice',
	type:"get",
	dataType:"json",
	async:false,
	error: function(){
		alert('获取数据失败');
		},
	success: function(data){
		if (data != ""){
		//这里一定要把data转换成json格式之后再使用，否则会出错
		data = $.parseJSON(data);
		$("#noticetitle").text(data.notice.noticetitle);
		$("#noticecontent").text(data.notice.noticecontent);
		$("#posttime").text(data.notice.posttime);
		}
	}
	});
}

function checkPasswordAgain(){
	var password = $("#password").val();
	var passwordAgain = $("#passwordAgain").val();
	if (password == passwordAgain){
		return true;
	}else{
		return false;
	}
}

function checkRealname(){
	var realname = $("#realname").val();
	var regex = /^[\u4e00-\u9fa5]{2,}$/;
	if (regex.test(realname)){
		return true;	
	}else{
		return false;
	}
}

function checkStuid(){
	var flag = false;
	var stuid = $("#stuid").val();
	var regex = /^\d{9}$/;
	
	if (regex.test(stuid)){
		$.ajax({
			url:'checkStuId?stuid='+stuid,
			type:"get",
			dataType:"json",
			async:false,//这里要设置为同步，否则会出现flag还未赋值就返回的情况
			error: function(){
				},
			success: function(data){
				data = $.parseJSON(data);
				flag = data.stuidStatus;
			}
			});
	}
	return flag;
}

function checkPassword(){
	var password = $("#password").val();
	var regex = /^[A-Za-z0-9]{6,18}$/;
	if (regex.test(password)){
		return true;
	}else{
		return false;
	}
}

function checkUsername(){
	var username = $("#username").val();
	var regex = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;

	if (regex.test(username)){
		return true;
	}else{
		return false;
	}
}

function checkEmail(){
	var flag = false;
	var email = $("#email").val();
	
	var regex = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	if (regex.test(email)){
		$.ajax({
			url:'checkEmail?email='+email,
			type:"get",
			dataType:"json",
			async:false,//这里要设置为同步，否则会出现flag还未赋值就返回的情况
			error: function(){
				},
			success: function(data){
				data = $.parseJSON(data);
				flag = data.emailStatus;
			}
			});
	}
	return flag;
}

function checkPhonenum(){
	var phonenum = $("#phonenum").val();
	var regex = /^1\d{10}$/;
	if (regex.test(phonenum)){
		return true;
	}else{
		return false;
	}
}

function checkQQ(){
	var qq = $("#qq").val();
	var regex = /^[1-9][0-9]{4,9}$/;
	if (regex.test(qq)){
		return true;
	}else{
		return false;
	}
}