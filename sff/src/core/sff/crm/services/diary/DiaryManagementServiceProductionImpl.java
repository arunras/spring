package core.sff.crm.services.diary;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import core.sff.crm.dataaccess.ActionDao;
import core.sff.crm.domain.Action;

@Transactional 
public class DiaryManagementServiceProductionImpl implements DiaryManagementService {
  private ActionDao dao;

  public DiaryManagementServiceProductionImpl(ActionDao dao) {
    this.dao = dao;
  }

  @Override
  public void recordAction(Action action) {
    dao.create(action);
  } 

  @Override
  public List<Action> getAllIncompleteActions(String requiredUser) {
    return dao.getIncompleteActions(requiredUser);
  }
}
