package LairOfTheForgottenBeast.factory;

public interface AbstractCreatureFactory<T>
{   
   T create(String creatureType);
}
