(function() {
    
    $(document).on("pageinit", "#todoList", function(e) {
        e.preventDefault();

        $.ajax({
            url: "http://hs-todos.mybluemix.net/todo",
            jsonp: "callback",
            dataType: "jsonp", 
            success: function(todos) {
            	updateTodoList(todos);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("An error occurs");            	
            }
         });        
    });    
    
    function updateTodoList(todos) {
        $("#todoListView").empty();
                
        if (jQuery.isEmptyObject(todos)) {
            $("<li>No Todos are Available</li>").appendTo("#todoListView");
        } else {
            var i;
            
            for (i = 0; i < todos.length; ++i) {
                $("<li>" + todos[i].title + "</li>").appendTo("#todoListView");
            }
        }
        
        $("#todoListView").listview('refresh');        
    }    
})();