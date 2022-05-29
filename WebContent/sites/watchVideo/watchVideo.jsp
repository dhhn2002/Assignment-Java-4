<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${video.title}</title>
<style type="text/css">
	.video-content
	{
		margin:auto;
		text-align: center;
	}
</style>
</head>
<body>
	<div class="video-content">
		<iframe width="900" height="600"
			src="https://www.youtube.com/embed/${video.videoURL}"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; 
		gyroscope; picture-in-picture"
			allowfullscreen> </iframe>
	</div>
</body>
</html>