<label>${self.label}:</label>
<input type="hidden" id="st_select_l_${self.id}" name="filterData.conditions[${self.id}].label" value="${self.label}"/>
<input type="hidden" id="st_select_n_${self.id}" name="filterData.conditions[${self.id}].name" value="${self.name}"/>
<select id="st_select_v_${self.id}" name="filterData.conditions[${self.id}].value">
    <#list self.options as option>
    	${option.html}
    </#list>
</select>
