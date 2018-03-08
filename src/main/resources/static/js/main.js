$(document).ready(function () {
	load_categories();
	load_items();	
});

function add_form_item(form) {
	var item = $(form).serializeArray();
	var payload = new Object();
    payload.	name = item[0].value;
	payload.category = new Object();
	payload.category.name = item[1].value;        	
	payload.minimal = item[2].value;
	payload.count = item[3].value;  
	add_item(payload);
	return false;
}

function add_form_category(form) {
	var category = $(form).serializeArray();
	var payload = new Object();
	payload.name = category[0].value;
	add_category(payload);
	return false;
}

function add_category(payload) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/categories",        
        dataType: 'json',
        data: JSON.stringify(payload),
        cache: false,
        timeout: 10000,
        success: function (data) {
        		location.reload();
        },
        error: function (e) {        	
        		printError(e);
	        	location.reload();	        		        		
        }        
    });
}

function add_item(payload) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/items",        
        dataType: 'json',
        data: JSON.stringify(payload),
        cache: false,
        timeout: 10000,
        success: function (data) {
        		location.reload();
        },
        error: function (e) {        	
        		printError(e);
        		location.reload();
        }        
    });
}
var categories = [];
function load_categories() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/categories",        
        dataType: 'json',
        cache: false,
        timeout: 10000,
        success: function (data) {        		
        		$.each(data, function(key, value) {
        			categories.push(value.name);
        			$("#catSelector").append("<option value=\""+value.name+"\">"+value.name+"</option>");
        		});          		
        },
        error: function (e) {
        		printError(e);
        }
    });
}

function plus(itemId) {
	changeItemCount(itemId, +1);
}

function min(itemId) {
	changeItemCount(itemId, -1);
}

function changeItemCount(itemId, delta) {
	$.each(items, function(key, value) {
		if (value.id == itemId) {
			value.count = Math.max(0, value.count + delta);
			updateItem(value);
		}
	});
}

function updateItem(payload) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/items",        
        dataType: 'json',
        data: JSON.stringify(payload),
        cache: false,
        timeout: 10000,
        success: function (data) {
        		location.reload();
        },
        error: function (e) {        	
        		printError(e);
        		location.reload();
        }        
    });	
}

var items = [];
function load_items() {	
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/items",        
        dataType: 'json',
        cache: false,
        timeout: 10000,
        success: function (data) {
        	
        		$.each(data, function(key, value) {
        			items.push(value);
        			var overflow = value.overflow > 0 ? "abundant" : value.overflow < 0 ? "short" : "normal";
        			$("#inventory > tbody").append("<tr><td>"+value.id+"</td><td>"+value.name+"</td>"+
        					"<td>"+value.category.name+"</td><td>"+value.minimal+"</td>"+
        					"<td>"+value.count+"</td><td class=\""+overflow+"\">"+value.overflow+"</td>"+
        					"<td><button type=\"button\" onclick=\"javascript:plus("+value.id+")\">+</button>"+
        					"</td><td><button type=\"button\" onclick=\"javascript:min("+value.id+")\">-</button></td></tr>");	
        		});
        		
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
        		printError(e);
        }
    });

}

function printError(e) {
    var json = "<h4>Ajax Response</h4><pre>"
        + e.responseText + "</pre>";
    $('#feedback').html(json);
    console.log("ERROR : ", e);
}