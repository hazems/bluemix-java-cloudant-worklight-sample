(function() {
    
    $(document).on("pageinit", "#todoList", function(e) {
        e.preventDefault();
        
        $("#reloadData").on("tap", function(e) {
            e.preventDefault();
            
            getRemoteData();
        });
        
        getRemoteData();
    });   
    
    function getRemoteData() {
        $.mobile.loading('show');
        
        $.ajax({
            url: "http://hs-todos.mybluemix.net/todo",
            jsonp: "callback",
            dataType: "jsonp", 
            success: function(todos) {
            	updateTodoList(todos);
                $.mobile.loading('hide');
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("An error occurs");   
                $.mobile.loading('hide');
            }
        });
    }
    
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