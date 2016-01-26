$(function() {
	var timer;
	
	$('#textInput').keyup(function() {
		clearTimeout(timer);
		timer = setTimeout(translate, 2000);
	});
	
	$('#textInput').keydown(function() {
		clearTimeout(timer);
	});
	
	$('#tlSelect').change(function() {
		translate();
	});
	
	$('#flSelect').change(function() {
		translate();
	});
	
	var translate = function() {		
		if (!($('#tlSelect').val() && $('#flSelect').val())) {
			return;
		}
		
		if (!($('#textInput').val() && $('#textInput').val().trim())) {
			return;
		}
		
		$.ajax({
			type     : $('#translateForm').attr('method'),
	        cache    : false,
	        url      : $('#translateForm').attr('action'),
	        data     : $('#translateForm').serialize(),
	        dataType : 'json',
	        success  : function(data) {
	        	if (data.requestPinyin && data.requestPinyin.length > 0) {
	        		$('#requestPinyinOutput').text(data.requestPinyin);
	        		$('#requestPinyinOutputDiv').show();
	        	} else {
	        		$('#requestPinyinOutputDiv').hide();
	        	}
	        	
	        	if (data.text && data.text.length > 0) {
	        		$('#resultTextOutput').text(data.text);
	        		$('#resultTextOutputDiv').show();
	        	} else {
	        		$('#resultTextOutput').text('No result found.');
	        	}
	        	
	        	if (data.resultPinyin && data.resultPinyin.length > 0) {
	        		$('#resultPinyinOutput').text(data.resultPinyin);
	        		$('#resultPinyinOutputDiv').show();
	        	} else {
	        		$('#resultPinyinOutputDiv').hide();
	        	}
	        }
		});
	};
	
	
 });
