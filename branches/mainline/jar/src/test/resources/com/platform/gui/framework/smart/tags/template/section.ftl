<!--The layer which over iframe Begin -->
<fieldset id="st_section_${self.id}" name="${self.name}">
	<legend>${self.label}</legend>
	<#list self.elements as element>						
		${element.html}
	</#list>
	${self.button.html}
</fieldset>