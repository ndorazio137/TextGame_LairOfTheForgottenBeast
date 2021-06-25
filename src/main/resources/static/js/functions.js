/* global $ */

$( document ).ready(function() {
	console.log("Document loaded!");
	
	function scrollConsoleDown() {
		var textarea = document.getElementById('console-screen-text');
		textarea.scrollTop = textarea.scrollHeight;
	}
	
	$("#command-form").submit( function(e) { 
		e.preventDefault();
		
		let commandString = $("#input-window").val();
		$("#console-screen-text").append("\n"+">"+commandString);
		$.ajax({
		   type: "POST",
		   url: "/console", //assuming your controller is configured to accept requests on this URL
		   	data: {
                commandString: commandString
            },
			success :function(result) {
				$("#console-screen-text").append("\n"+result+"\n");
				scrollConsoleDown();
				$("#input-window").val("");
		   	},
			error: function() {
				$("#console-screen-text").append("\n"+"Something went wrong"+"\n");
				scrollConsoleDown();
				$("#input-window").val("");
			}
		});
	
	});
});