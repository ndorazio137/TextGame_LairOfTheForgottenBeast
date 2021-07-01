/* global $ */

$( document ).ready(function() {
	console.log("Document loaded!");
	
	function scrollConsoleDown() {
		var textarea = document.getElementById('console-screen-text');
		textarea.scrollTop = textarea.scrollHeight;
	}
	
	function updateMinimap(mapDims, playerCoords) {
		$("#minimap").html("");
		for (let y = 0; y < mapDims[0]; y++) {
			/* add a row to the minimap */
			for (let x = 0; x < mapDims[1]; x++) {
				/* add a column to the minimap */
				if ((x == playerCoords[0]) && (y == playerCoords[1])) {
					$("#minimap").append(" O ");
				} else {
					$("#minimap").append(" # ");
				}
			}
			$("#minimap").append("<br />");
		}
		
	}
	
	$("#command-form").submit( function(e) { 
		e.preventDefault();
		
		let commandString = $("#input-window").val();
		$("#console-screen-text").append("\n"+">"+commandString);
		$.ajax({
		   type: "POST",
		   url: "/console",
		   	data: {
                commandString: commandString
            },
			success :function(resultObject) {
				$("#console-screen-text").append("\n"+resultObject.commandOutput+"\n");
				scrollConsoleDown();
				$("#location-text").html(resultObject.locationInfo);
				$("#input-window").val("");
				updateMinimap(resultObject.mapDims, resultObject.playerCoords) 
		   	},
			error: function() {
				$("#console-screen-text").append("\n"+"Something went wrong"+"\n");
				scrollConsoleDown();
				$("#location-text").html(resultObject.locationInfo);
				$("#input-window").val("");
			}
		});
	
	});
});