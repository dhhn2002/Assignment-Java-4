<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	function chooseFile(fileInput)
	{
		if(fileInput.files && fileInput.files[0])
		{
			var reader = new FileReader();
			
			reader.onload = function(e)
			{
				$('#posterImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(fileInput.files[0]);
		}
	}
</script>