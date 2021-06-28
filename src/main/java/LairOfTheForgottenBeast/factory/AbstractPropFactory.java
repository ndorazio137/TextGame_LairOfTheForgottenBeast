package LairOfTheForgottenBeast.factory;

public interface AbstractPropFactory<T>
{
   T create(String propType);
}