package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

public interface Call<Return> {
    public <AnyType> String call(Object gameState, List<String> command);
}
