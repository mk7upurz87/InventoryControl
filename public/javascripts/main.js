$(function() {

	if($('.part-row').length === 0) {
		$table = $('.parts-list').find('thead').after(
			'<tr class="part-row">'+
			'<td></td>'+
			'<td></td>'+
			'<td><a class="btn left" type="" value=""></a></td>'+
			'<td></td>'+
			'<td><a class="btn right" type="" value=""></a></td>'+
			'<td></td>'+
			'</tr>');
	}
})