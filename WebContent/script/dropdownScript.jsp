<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

	<script>
        let click = document.querySelector('.click');
        let list = document.querySelector('.list');
        click.addEventListener("click", () => {
            list.classList.toggle('newlist');
        })
    </script>