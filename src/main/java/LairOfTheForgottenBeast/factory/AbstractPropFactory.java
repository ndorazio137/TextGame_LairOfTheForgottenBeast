package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;

public interface AbstractPropFactory<T>
{
   T create(String propType);

   T create(String propType, String name, String shortDesc, String longDesc);

   T createWeapon(String name, int attackDamage, String shortDesc, String longDesc);

}
