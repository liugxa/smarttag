<form action="${context.url}" method="post" class="tableGridForm" id="st_form_${self.name}" name="st_from_${self.name}">

<script>
	var form = document.getElementById("st_form_${self.name}");
	function st_form_submit(){
		if(form != null) form.submit();
	}
</script>