/* global $ */

$( document ).ready(function() {
	console.log("Document loaded!");
	
	function sendCommand(commandString) {
        $.ajax({
            method: "POST",
            url: "/console",
            data: {
                "commandString": commandString
            },
            error: function(error) {
                // error... something went wrong...
				alert(error);
            },
            success: function(data, status) {
                // alert("Success");
                if (data) {
                    $("#console-output").val(data.commandString);
                }
            }
        });
    }

	$("#command-form").submit( function(e) { 
		e.preventDefault(); 
		let commandString = $("#commandString").val();
		sendCommand()
	});
});
