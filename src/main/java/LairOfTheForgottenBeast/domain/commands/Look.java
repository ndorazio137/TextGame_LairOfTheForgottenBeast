package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

public class Look implements Call<String> {

   @Override
   public <AnyType> String call(List<String> command) {
      System.out.println("In Look(): call");
      
      return "You looked!";
   }
}
