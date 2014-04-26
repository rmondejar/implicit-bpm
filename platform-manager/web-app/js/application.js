if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
	
	// Typeahead en casella de cerca de clients
	var autocomplete = $('#idClientSearch').typeahead().on('keyup', function(ev){

	    ev.stopPropagation();
	    ev.preventDefault();
	
	    if( $.inArray(ev.keyCode,[40,38,9,13,27]) === -1 ){
	
	        var self = $(this);
	        
	        self.data('typeahead').source = [];
	
	        if( !self.data('active') && self.val().length > 0){
	
	            self.data('active', true);
	
	            $.getJSON("/ma3/cerca/clients",{
	                q: $(this).val()
	            }, function(data) {
	                self.data('active',true);
	
	                var arr = [], i=data.length;
	                while(i--){	                	
	                    arr[i] = "[" + data[i].id + "] - " + data[i].descripcio 
	                }
	
	                self.data('typeahead').source = arr;
	
	                self.trigger('keyup');
	
	                self.data('active', false);
	
	            });
	
	        }
	    }
	});
}


function fillDades(data, textStatus) {
	$("#idAplicacio").val($(data).find("nom").text());
	$("#descripcio").val($(data).find("des").text());
}

