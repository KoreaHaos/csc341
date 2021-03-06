package assignment09;

abstract class ClientCreditState {
	protected CCState creditState;
	public CCState getStateConstant() { return creditState; }
	public void setStateConstant(CCState creditState) { this.creditState = creditState; }
	public abstract void transition(Client client);
	public String toString() { return creditState.toString(); }
}

class PendingCredit extends ClientCreditState {
	public void PendingState() { this.creditState = CCState.Pending; }
	
	@Override
	public void transition(Client client) {
		client.setState( new ApprovedCredit() );
		client.setStateConstant(CCState.Approved);
	}
}

class ApprovedCredit extends ClientCreditState {
	public void ApprovedCredt() { this.creditState = CCState.Approved; }
	
	public void resetCredit(Client client) {
		client.setState( new PendingCredit() );
		client.setStateConstant(CCState.Pending);
	}

	@Override
	public void transition(Client client) {
		 throw new UnsupportedOperationException();
	}
}
