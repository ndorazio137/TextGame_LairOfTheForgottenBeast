/* global $ */

$( document ).ready(function() {
   console.log("Document loaded!");
   
   var lastCommand = "help";
   
   document.addEventListener('keydown', keyDown);

   function keyDown(e) {
      if(`${e.code}` == "ArrowUp") {
         $("#input-window").val(lastCommand);
      }
   }
   
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
      lastCommand = commandString;
      $("#console-screen-text").append("\n"+">"+commandString);
      $.ajax({
         type: "POST",
         url: "/console",
            data: {
                commandString: commandString
            },
         success: function(resultObject) {
            $("#console-screen-text").append("\n"+resultObject.commandOutput+"\n");
            scrollConsoleDown();
            updateLocationInfo();
            clearInputField();
            updateMinimap(resultObject.mapDims, resultObject.playerCoords);
            updatePlayerHp();
            updatePlayerEquipment();
            updatePlayerInventory();
            },
         error: function() {
            appendError();
            scrollConsoleDown();
            updateLocationInfo();
            clearInputField();
         }
      });
   
   });
   
   function appendError() {
      $("#console-screen-text").append("\n"+"Something went wrong"+"\n");
   }
   
   function clearInputField() {
      $("#input-window").val("");
   }
   
   function updateLocationInfo() {
      $("#location-text").html(resultObject.locationInfo);
   }
   
   function updatePlayerHp() {
      $("#player-HP").html("HP: " + resultObject.playerCurrentHp + "/" + resultObject.playerMaxHp);
   }
   
   function updatePlayerEquipment() {
      $("#player-Weapon").html("Equipped Weapon: " + resultObject.playerWeapon);
   }
   
   function updatePlayerInventory() {
      $("#player-Inventory").html("Items: ");
      for (let i = 0; i < resultObject.playerInventory.keys(result).length; i++) {
         $("#player-Inventory").append(resultObject.playerInventory[i]);
         if (i != (resultObject.playerInventory.keys(result).length - 1)) {
            $("#player-Inventory").append(", ");
         }
      }
   }
});