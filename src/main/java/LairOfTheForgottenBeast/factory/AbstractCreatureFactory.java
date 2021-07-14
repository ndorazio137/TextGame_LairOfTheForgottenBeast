package LairOfTheForgottenBeast.factory;

public interface AbstractCreatureFactory<T>
{   
   T create(String creatureType);
   
   T create(String creatureType, String name, String shortDesc, String longDesc);
}
