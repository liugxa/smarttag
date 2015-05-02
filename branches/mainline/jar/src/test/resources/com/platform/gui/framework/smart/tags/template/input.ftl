<label>${self.label}:</label>
<input type="hidden" id="st_filter_l_${self.id}" name="filterData.conditions[${self.id}].label" value="${self.label}"/>
<input type="hidden" id="st_filter_n_${self.id}" name="filterData.conditions[${self.id}].name" value="${self.name}"/>
<input type="text" id="st_filter_v_${self.id}" name="filterData.conditions[${self.id}].value" value="${self.value!''}" maxlength="120" size="15"/>
