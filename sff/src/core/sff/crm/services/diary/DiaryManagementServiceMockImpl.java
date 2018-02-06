package core.sff.crm.services.diary;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import core.sff.crm.domain.Action;

public class DiaryManagementServiceMockImpl implements DiaryManagementService {
  private Set<Action> allActions = new HashSet<>();

  @Override
  public void recordAction(Action action) {
    allActions.add(action);
  }

  @Override
  public List<Action> getAllIncompleteActions(String requiredUser) {
    List<Action> results = new ArrayList<>();

    for (Action next: allActions) {
      if (next.getOwningUser().equals(requiredUser) && !next.isComplete()) {
        results.add(next);
      }
    }

    return results;
  }
}
