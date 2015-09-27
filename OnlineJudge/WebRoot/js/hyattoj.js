/**
 * 
 */
function loadRank(){
			$.ajax({
			url:'http://localhost:8080/OnlineJudge/getRank',
			type:"get",
			dataType:"json",
			async:false,
			error: function(){
				alert('获取数据失败');
				},
			success: function(data){
				//这里一定要把data转换成json格式之后再使用，否则会出错
				data = $.parseJSON(data);
				$.each(data.scores,function(i,item){
					
					var tr = $('<tr></tr>');
					var td0 = $('<td></td>').text("");
					var td1 = $('<td></td>').text(i+1);
					var td2 = $('<td></td>').text(item.username);
					var td3 = $('<td></td>').text(item.score);
					tr.append(td0,td1,td2,td3);
					$("#rank").append(tr);
					});
				}
			});
	}

function loadWeeklyRank(){
	$.ajax({
	url:'http://localhost:8080/OnlineJudge/getWeeklyRank',
	type:"get",
	dataType:"json",
	async:false,
	error: function(){
		alert('获取数据失败');
		},
	success: function(data){
		//这里一定要把data转换成json格式之后再使用，否则会出错
		data = $.parseJSON(data);
		$.each(data.Weeklyscores,function(i,item){
			var tr = $('<tr></tr>');
			var td0 = $('<td></td>').text("");
			var td1 = $('<td></td>').text(i+1);
			var td2 = $('<td></td>').text(item.username);
			var td3 = $('<td></td>').text(item.score);
			tr.append(td0,td1,td2,td3);
			$("#weeklyrank").append(tr);
			});
		}
	});
}

function loadNotice(){
	$.ajax({
	url:'http://localhost:8080/OnlineJudge/getLastestNotice',
	type:"get",
	dataType:"json",
	async:false,
	error: function(){
		alert('获取数据失败');
		},
	success: function(data){
		//这里一定要把data转换成json格式之后再使用，否则会出错
		data = $.parseJSON(data);
		$("#noticetitle").text(data.notice.noticetitle);
		$("#noticecontent").text(data.notice.noticecontent);
		$("#posttime").text(data.notice.posttime);
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
			url:'http://localhost:8080/OnlineJudge/checkStuId?stuid='+stuid,
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
	var regex = /^[a-zA-Z]\w{5,24}$/;
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
			url:'http://localhost:8080/OnlineJudge/checkEmail?email='+email,
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