<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 코어 테그나 el테그 3줄 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>


    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<table border="1px">
<colgroup>
<col width="50"><col width="100"><col width="300"><col width="50"> 
<col width="50"><col width="50"><col width="100"><col width="50">
</colgroup>

<thead>	<!-- 표의 머리부분 -->
<tr>
	<th>Number</th><th>writer</th><th>title</th><th>down</th>
	<th>Views Hit</th><th>Down hit</th><th>Written by</th><th>Del</th>
</tr>
</thead>

<tbody>

<!-- 
for (int i  = 0; i < 10; i++){
	i == varStatus OK?
}

 -->

<c:forEach var="pds" items="${pdslist }" varStatus="pdsS">	
<!-- var은 사용할 변수명, items는 Collection 객체(List, ArrayList), varStatus은 반복상태를 알수 있는 변수 --> 

<tr>		<!-- 반드시 위에서 써 놓은 거를 맞춰서 작상할것 -->
	<td>${pdsS.count }</td>		<!-- 카운트를 가져올거고 -->
	<td>${pds.id  }</td>		<!-- 아이디를 가져올거고 -->
	<td style="text-align: left;">		<!-- 왼쪽 정렬 -->
		<a href="pdsdetail.do?seq=${pds.seq }"> 		<!-- seq값을 가지고 디테일러 갈거임 -->
			${pds.title }		<!-- 화면에 타이틀을 보여줄거임 -->
		</a>
	<td>
		<input type="button" name="btnDown" value="다운로드"
			onclick="filedowns('${pds.filename}', '${pds.seq }')">	<!-- 다운하면 filename과 seq를 보냄 -->
	</td>
	<td>${pds.readcount }</td>
	<td>${pds.downcount }</td>
	<td>
		<font size="1">${pds.regdate }</font>		<!-- 작성일(Written by) -->
	</td>
	<td>
		<img alt="" src="image/del.png" data-seq="${pds.seq }"
			class="btn_fileDelete" id="zz">
			<!-- onclick="filedelete('${pds.seq}')" -->
	</td>

</tr>

</c:forEach>

</tbody>

</table>
</div>
<!-- 추가 버튼(데이터 추가) -->
<div id="buttons.wrap" align="center">
	<span class="button blue">
		<button type="button" id="_btnAdd">자료추가</button>
	</span>
</div>

<!-- 다운로드 버튼 클릭시에 동작이 되는 폼을 만들어줄수도 있음 (파일 다운은 포스트 밖에 안됨-->
<form name="file_Down" action="fileDownload.do" method="post">	<!-- 왜 히든으로 숨겼는 지는 알지? 값을 필요로 하는데 보여줄 필요는 없기 때문이야 -->
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">
</form>		

<script type="text/javascript">
$("#_btnAdd").click(function () {		/* 위에 자료 추가에 아이디랑 동일 */
	location.href = "pdswrite.do";	
});

$(".btn_fileDelete").click(function () {	/* 여기는 클래스를 줬기 때문에 .을 찍었음 */
	
	var seq = document.getElementById('zz');	/* del부분에 아이디 값이 똑같아야함 */
	
	location.href = "pdsdelete.do?seq" + seq.dataset.seq;	
	/* seq.dataset.seq이 부분 모를거야 아마도? 컨트롤러 부분에서 파라미터는 seq이고 그 seq는 seq.dataset.seq로 받아오는 거고
			델리트 하는 순간에 데이터를 없에고 말고는 pdsdelete.do 코드를 봐봐 
	그리고 sql문을 보고 delete로 할지 update로 지우는지를 결정하면 돼 아마도 보통은 update로 처리한다는 걸로 알고 있는데 ...확실하지는 않아 ㅋㅋ */		
	
});

function filedowns(filename, seq) {
	alert("filename");		/* 꼭 한번 찍어봐 seq로 찍어봐도 되고 */
	var doc = document.file_Down;		//이름으로 접근(폼으로 하기 때문에 네임으로 가능하다는 거)
	doc.filename.value = filename;	
	doc.seq.value = seq;
	doc.submit();
	
}

</script>




</body>
</html>