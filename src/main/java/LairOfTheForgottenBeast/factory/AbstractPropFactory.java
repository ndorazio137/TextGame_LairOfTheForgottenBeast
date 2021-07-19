package LairOfTheForgottenBeast.factory;

public interface AbstractPropFactory<T> {
  T create(String propType);

  T create(String propType, String name, String shortDesc, String longDesc);

}
