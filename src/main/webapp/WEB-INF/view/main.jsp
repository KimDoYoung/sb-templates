<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>TEST</h1>
<p>
<a href="https://jsonplaceholder.typicode.com/users">https://jsonplaceholder.typicode.com/users</a> 에서 데이터를 제공

<button id="ajax1">$.get</button>
<button id="ajax2">$.ajax</button><br>
<form>
	<p>id : <input type="text" id="userId" name="id" required="true" />
	<p>name : <input type="text" id="userNm" name="name" required="true"/>
	<p><button id="ajax3">submit</button>
</form>

<table id="table1">
</table>
<script id="hb-tr" type="text/x-handlebars-template">
{{#each list}}
	<tr><td>{{id}}</td><td>{{name}}</td></tr>
{{/each}}
</script>

<script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.8/handlebars.min.js" integrity="sha512-E1dSFxg+wsfJ4HKjutk/WaCzK7S2wv1POn1RRPGh8ZK+ag9l244Vqxji3r6wgz9YBf6+vhQEYJZpSjqWFPg9gg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
$(document).ready(function(){
	console.log('ready...');
	$('#ajax1').on('click', function(){
		var url='https://jsonplaceholder.typicode.com/users';
		var jqxhr = $.get(url)
			.done(function(response) {
			    console.log( "success:" + response );
			    //debugger;
			    var template = $('#hb-tr').html();
			    var compiledTemplate = Handlebars.compile(template);
			    var html = compiledTemplate({list:response});
			    $('#table1').html(html);
			})
			.fail(function() {
			   console.log( "error" );
			})
			.always(function() {
			    console.log( "finished" );
			});
	});
	$('#ajax2').on('click', function(){
		var url='/ajax2';
		$.ajax({
			type : 'get',
			url  : url,
			async : true, //default true임
			headers : { "Content-Type" : "application/json; charset=UTF-8"},    
 		    dataType : 'json', 
		    data : {}, 
		    success : function(response) { 
			    console.log( "success:" + response );
			   // debugger;
			    var template = $('#hb-tr').html();
			    var compiledTemplate = Handlebars.compile(template);
			    var html = compiledTemplate({list:response});
			    $('#table1').html(html);		    	
		    },
		    error : function(request, status, error) { 
		    	console.log(error); 
		    },
		    complete : function(){  
		    	console.log('done....');
		    } 
		})
	});
	$('#ajax3').on('click', function(e){
		e.stopPropagation();
		e.preventDefault();
		var url='/ajax3';
		var id=$('#userId').val();
		var nm=$('#userNm').val();
		var data = {id : id, name : nm};
		
		$.ajax({
			type : 'post',
			url  : url,
			async : true, //default true임
			headers : { "Content-Type" : "application/json; charset=UTF-8"},    
 		    dataType : 'json', 
		    data : JSON.stringify(data), 
		    success : function(response) { 
			    console.log( "success:" + response );
			    var list = response.list;
			   // debugger;
			    var template = $('#hb-tr').html();
			    var compiledTemplate = Handlebars.compile(template);
			    var html = compiledTemplate({list:list});
			    $('#table1').html(html);		    	
		    },
		    error : function(request, status, error) { 
		    	console.log(error); 
		    },
		    complete : function(){  
		    	console.log('done....');
		    } 
		})
	});	
});
</script>
</body>
</html>