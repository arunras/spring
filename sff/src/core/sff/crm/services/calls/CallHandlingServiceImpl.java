package core.sff.crm.services.calls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.sff.crm.domain.Action;
import core.sff.crm.domain.Call;

import core.sff.crm.services.customers.CustomerManagementService;
import core.sff.crm.services.customers.CustomerNotFoundException;
import core.sff.crm.services.diary.DiaryManagementService;

@Transactional
@Service
public class CallHandlingServiceImpl implements CallHandlingService {
  private CustomerManagementService customerService;
  private DiaryManagementService diaryService;

  @Autowired
  public CallHandlingServiceImpl
    (CustomerManagementService customerService, DiaryManagementService diaryService) {
    this.customerService = customerService;
    this.diaryService = diaryService;
  }

  @Override
  public void recordCall(String customerId, Call newCall, Collection<Action> actions) 
    throws CustomerNotFoundException {
    // TODO:1 call the customer service to record the call
    customerService.recordCall(customerId, newCall); 

    // TODO:2 call the diary service to record the actions
    for (Action nextAction: actions) {
      diaryService.recordAction(nextAction);
    } 
  }
}
