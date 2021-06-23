package LairOfTheForgottenBeast;

import java.util.Scanner;

public class demo
{
   public static void main(String[] args)
   {
      // Model (simulated database info)
      String dungeonMap[][] =
      {
         {
            "You are in the Starting Room.", "You are in the blue room.",
            "You are in the red room."
         },
         {
            "You are in the green room", "You are in the yellow room.",
            "You are in a dining hall."
         },
         {
            "You are in a library.", "You are in a large living area.",
            "You are in an armory."
         }
      };
      int xLength = dungeonMap[0].length;
      int yLength = dungeonMap[0].length;
      // User command input method in development
      Scanner scanner = new Scanner(System.in);
      String command = "";
      System.out.println("Lair of the Forgotten Beast");
      System.out.println("2021 CSUMB Computer Science Capstone Project");
      System.out.println("by Nick D'Orazio, Kyle Oakes, and Brian James");
      System.out.println(" ");

      int x = 0;
      int y = 0;
      while (command != "exit")
      {
         System.out.println(dungeonMap[x][y]);
         System.out.println(" ");
         System.out.printf("command: ");
         command = scanner.nextLine();
         System.out.println(" ");
         if (command.equals("exit"))
         {
            System.out.println("Game Over");
            System.exit(0);
         } else
         {
            System.out.println("continuing");
         }

         // Directional Movement across dungeon
         // For right now, just use "n", "s", "e", "w" until it gets better.
         switch (command)
         {
            case "n":
               if ((y + 1) == yLength)
               {
                  System.out.println("You cannot go there.");
                  break;
               } 
               else
               {
                  y = y + 1;
               }
               break;
            case "s":
               if ((y - 1) < 0)
               {
                  System.out.println("You cannot go there.");
                  break;
               } 
               else
               {
                  y = y - 1;
               }
               break;
            case "e":
               if ((x + 1) == xLength)
               {
                  System.out.println("You cannot go there.");
                  break;
               } 
               else
               {
                  x = x + 1;
               }
               break;
            case "w":
               if ((x - 1) < 0)
               {
                  System.out.println("You cannot go there.");
                  break;
               } 
               else
               {              
                  x = x - 1;
               }
               break;
            default:
               x = x;
               y = y;
         }

      }
      scanner.close();
      System.exit(0);
   }
}