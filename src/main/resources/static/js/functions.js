/* global $ */

$( document ).ready(function() {
   console.log("Document loaded!");
   
   // Set a repeating asynchronous call to update the chat
   setInterval(function() { updateChat(); }, 1000);
   
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
      submitCommandForm();
   });
   
   function submitCommandForm() {
      
      let isMultiplayer = $("#multiplayer").is(":checked");
      console.log(isMultiplayer);
      
      let commandString = $("#input-window").val();
      
      if (commandString == "") {
         return;
      }
      
      let username = $("#username").val();
      lastCommand = commandString;
      $("#console-screen-text").append("\n"+">"+commandString);
      $.ajax({
         type: "POST",
         url: "/console",
            data: {
                commandString: commandString,
                username: username,
                multiplayer: isMultiplayer
            },
         success: function(resultObject) {
            console.log(resultObject);
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
   }
   
   function updateChat() {
      let isMultiplayer = $("#multiplayer").is(":checked");
      if (!isMultiplayer) {
         return;
      }
      
      let username = $("#username").val();
      $.ajax({
         type: "POST",
         url: "/pullChats",
            data: {
                username: username
            },
         success: function(resultObject) {
            if (resultObject.commandOutput != null && resultObject.commandOutput != "") {
               console.log("New chats :)");
               console.log(resultObject.commandOutput);
               $("#console-screen-text").append("\n"+resultObject.commandOutput+"\n");
               scrollConsoleDown();
            }
         },
         error: function() {
            console.log("Failed to get recent chats...");
         }
      });
   }
   
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
      var size = 0;
      while (playerInventory[size]) {
          size++;
      }
      if (inventorySize <= 0) {
         $("#player-Inventory").html("Your inventory is currently empty.");
      }
      for (let i = 0; i < size; i++) {
         $("#player-Inventory").append(playerInventory[i]);
         if (i != size - 1) {
            $("#player-Inventory").append(", ");
         }
      }
   }
   */
});