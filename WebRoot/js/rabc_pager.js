function toPage(type){
	var page_now=$("#pageNow").val();
	var total_pages=$("#totalPages").val();
	switch(type){
		case "1":
			$("#pageNow").val("1");
			break;
		case "2":
			if(parseInt(page_now)==1){
				alert("没有上一页");
				return false;
			}
			$("#pageNow").val(parseInt(page_now)-1);
			break;
		case "3":
			if(parseInt(page_now)==parseInt(total_pages)){
				alert("没有下一页");
				return false;
			}
			$("#pageNow").val(parseInt(page_now)+1);
			break;
		case "4":
			$("#pageNow").val(total_pages);
			break;
		case "5":
			$("#pageNow").val("1");
			break;
	}
	$("#searchForm").submit();
}