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
            updateLocationInfo(resultObject.locationInfo);
            clearInputField();
            updateMinimap(resultObject.mapDims, resultObject.playerCoords);
            updatePlayerHp(resultObject.playerCurrentHp, resultObject.playerMaxHp);
            updatePlayerEquipment(resultObject.playerWeapon);
            // TODO: fix the following method so inventory can be displayed on UI
            //updatePlayerInventory(resultObject.playerInventory);
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
   
   function updateLocationInfo(locationInfo) {
      $("#location-text").html(locationInfo);
   }
   
   function updatePlayerHp(playerCurrentHp, playerMaxHp) {
      $("#player-HP").html("HP: " + playerCurrentHp + "/" + playerMaxHp);
   }
   
   function updatePlayerEquipment(playerWeapon) {
      $("#player-Weapon").html("Equipped Weapon: " + playerWeapon);
   }
   
   // TODO: fix this so inventory item names can be displayed on UI
   /*
   function updatePlayerInventory(playerInventory) {
      var inventorySize = 0;
      while (playerInventory[inventorySize]) {
          inventorySize++;
      }
      if (inventorySize <= 0) {
         $("#player-Inventory").html("Your inventory is currently empty.");
      }
      for (let i = 0; i < inventorySize; i++) {
         $("#player-Inventory").append(playerInventory[i]);
         if (i != inventorySize - 1) {
            $("#player-Inventory").append(", ");
         }
      }
   }
   */
});