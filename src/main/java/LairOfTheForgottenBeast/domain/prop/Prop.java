package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.OnExamined;
import LairOfTheForgottenBeast.domain.OnTalk;

public interface Prop {
  Long getId();

  String getName();

  String getShortDescription(); // This is read as the default description

  String getLongDescription(); // This is read someone "examines" a prop object

  String getProperties(); // Stone, Wood, leather, metal, etc.

  String toString();

  String burn(); // executed when a prop is ignited with fire

  String freeze(); // executed when a prop is exposed to freezing cold

  String shock();

  String wet();

  String onAttacked();

  String onExamined();

  String onTalk();

  String getSpeechText();

  void setSpeechText(String text);

  boolean setName(String string);

}
