package LairOfTheForgottenBeast.factory;

public interface AbstractFactory<T>
{
   T create(String propType);
}