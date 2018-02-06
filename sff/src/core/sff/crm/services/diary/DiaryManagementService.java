 package core.sff.crm.services.diary;

import java.util.List;

import core.sff.crm.domain.Action;

public interface DiaryManagementService 
{
	public void recordAction(Action action);
	public List<Action> getAllIncompleteActions(String requiredUser);
}
