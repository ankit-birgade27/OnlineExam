<head>
<style>
select{
	padding : 4px;
}
</style>
	<script>
		
		function display(x){
			var xmlHttp = new XMLHttpRequest();
			
			xmlHttp.open("get", "getQuestion?subject=" + x.value, true);
			
			xmlHttp.send();
			
		}
	</script>
</head>


<body>
<form>
 <select name="selectSubject" onchange="display(this)">
		<option value="GK">GK</option>
		<option value="Math">Math</option>
	</select>
	
	<input type="submit" value="startExam" formaction="startExam">
	</form>
</body>

