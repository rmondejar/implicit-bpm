var APP_TITLE = "Manager";

$('.sidebar-collapse').on('click', function () {
	var title = $('#app-title').html();
	if (title == APP_TITLE) {
		$('#app-title').html('&nbsp;');
	}
	else {
		$('#app-title').html(APP_TITLE);
	}
});