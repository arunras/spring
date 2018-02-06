package core.sff.crm.services.calls;

import java.util.Collection;

import core.sff.crm.domain.Action;
import core.sff.crm.domain.Call;
import core.sff.crm.services.customers.CustomerNotFoundException;

public interface CallHandlingService 
{
	// DO NOT IMPLEMENT THIS INTERFACE UNTIL A LATER CHAPTER!
	
	/**
	 * Records a call with the customer management service, and also records
	 * any actions in the diary service
	 */
	public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException;
}
