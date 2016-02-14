//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches

$(".next").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	next_fs = $(this).parent().next();
	
	//activate next step on progressbar using the index of next_fs
	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	
	//show the next fieldset
	next_fs.show(); 
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			//2. bring next_fs from the right(50%)
			left = (now * 50)+"%";
			//3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'transform': 'scale('+scale+')'});
			next_fs.css({'left': left, 'opacity': opacity});
		}, 
		duration: 800, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".previous").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();
	
	//de-activate current step on progressbar
	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
	
	//show the previous fieldset
	previous_fs.show(); 
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale previous_fs from 80% to 100%
			scale = 0.8 + (1 - now) * 0.2;
			//2. take current_fs to the right(50%) - from 0%
			left = ((1-now) * 50)+"%";
			//3. increase opacity of previous_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'left': left});
			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
		}, 
		duration: 800, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".submit").click(function(){
	return false;
})
$(".next-last").click(function() {
		var obj = $(this);
		if(validator()){
			var pamar = {
					"userEmail" : $.trim($("#userEmail").val()),
					"userName" : $.trim($("#userName").val()),
					"password" : $.trim($("#password").val())
				}
				$.ajax({
					type : "post", // 
					url : 'http://localhost:8080/spider_blog/reg/reg',
					data : pamar,
					success : function(data) {
						if (data.state) {
							tz(obj);
							var second = 2;
							var interval = setInterval(function() {
								$("#timeOut").html(second);
								if (--second < 0) {
									clearInterval(interval);
									location.href = "http://localhost:8080/spider_blog"
								}
							}, 1000);
						}else{
							if(data.msg=='USERNAME_NULL'){
								$(".previous").click();
								$("#userName").css("border","solid 1px #c40000");
							}else if(data.msg=='USEREMAIL_NULL'){
								$(".previous").click();
								$("#userEmail").css("border","solid 1px #c40000");
							}else if(data.msg=='PASSWORD_NULL'){
								$(".previous").click();
								$("#password").css("border","solid 1px #c40000");
							}else{
								$(".previous").click();
								$("#msg").show();
								$("#msg").text(data.msg);
							}
						}
					},
					error:function(){
						$(".previous").click();
						$("#msg").show();
						$("#msg").text("服务器繁忙，请稍后重试");
					}
				});
		}else{
			$(".previous").click();
			$("#msg").show();
			$("#msg").text("请输入完整、正确的注册信息");
		}
		
	});
	$("input").focus(function(){
		$("#msg").hide();
	});
	function tz(obj){
		if(animating) return false;
		animating = true;
		
		current_fs = obj.parent();
		next_fs = obj.parent().next();
		
		//activate next step on progressbar using the index of next_fs
		$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
		
		//show the next fieldset
		next_fs.show(); 
		//hide the current fieldset with style
		current_fs.animate({opacity: 0}, {
			step: function(now, mx) {
				//as the opacity of current_fs reduces to 0 - stored in "now"
				//1. scale current_fs down to 80%
				scale = 1 - (1 - now) * 0.2;
				//2. bring next_fs from the right(50%)
				left = (now * 50)+"%";
				//3. increase opacity of next_fs to 1 as it moves in
				opacity = 1 - now;
				current_fs.css({'transform': 'scale('+scale+')'});
				next_fs.css({'left': left, 'opacity': opacity});
			}, 
			duration: 800, 
			complete: function(){
				current_fs.hide();
				animating = false;
			}, 
			//this comes from the custom easing plugin
			easing: 'easeInOutBack'
		});
	}
	$("input").focus(function(){
		$(this).removeClass("active_input");
	});
	function validator() {
		if ($("input[name='user.password']").val() != ''
				&& $("input[name='user.userName']").val()!=''&& $("input[name='user.password']").val() == $(
						"input[name='cpass']").val()
				&& $("input[name='user.userEmail']").val() != '') {
			var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
			if(re.test($("input[name='user.userEmail']").val())){
				return true;
			}else{
				$("#userEmail").addClass("active_input");
				return false;
			}
		
		} else {
			return false;
		}
	}