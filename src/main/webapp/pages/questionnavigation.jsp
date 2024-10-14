<body>
<form>
	<input type="text" name="qno" placeholder="question no." value="${questions.qno}">  <br><br>
	
	<input type="text" name="question" placeholder="question" value="${questions.question}"><br><br>
	
	<input type="radio" name="option1" placeholder="option 1"  ><span>${questions.option1} </span> <br><br>
	
	<input type="radio" name="option2" placeholder="qoption 2"  >  <span>${questions.option2} </span> <br><br>
	
	<input type="radio" name="option3" placeholder="option 3"  > <span>${questions.option3} </span> <br><br>
	
	<input type="radio" name="option4" placeholder="option 4"   ><span>${questions.option4} </span> <br><br>
	
	<input type="submit" value="next" formaction="next"><br><br>
	<input type="submit" value="previous" formaction="previous"><br><br>
	
</form>

</body>
