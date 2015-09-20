/**
 * 
 */
function loadRank(){
			$.ajax({
			url:'http://localhost:8080/OnlineJudge/getRank',
			type:"get",
			dataType:"json",
			error: function(){
				alert('获取数据失败');
				},
			success: function(data){
				//这里一定要把data转换成json格式之后再使用，否则会出错
				data = $.parseJSON(data);
				$.each(data.users,function(i,item){
					
					var tr = $('<tr></tr>');
					var td0 = $('<td></td>').text("");
					var td1 = $('<td></td>').text(i+1);
					var td2 = $('<td></td>').text(item.nickname);
					var td3 = $('<td></td>').text(item.score.score);
					tr.append(td0,td1,td2,td3);
					$("#rank").append(tr);
					});
				}
			});
	}

function loadNotice(){
	$.ajax({
	url:'http://localhost:8080/OnlineJudge/getLastestNotice',
	type:"get",
	dataType:"json",
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