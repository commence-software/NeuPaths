/* Copyright (c) 2025 Commence Software LLC.  All rights reserved. */

import neupaths.api.*;
import neupaths.stim.*;

import java.util.UUID;

public class ClusterResponseActivator extends Activator
{
  public ClusterResponseActivator ()
  {
    super("ClusterResponseActivator",
          new ReceptorSpec[] {
              new ReceptorSpec("PropertyResponse",
                               ReceptorMode.BUFFERED,
                               PropertyResponse.TYPE_ID)
          },
          new TransmitterSpec[] {
              new TransmitterSpec("ClusterResponse",
                                  ClusterResponse.TYPE_ID,
                                  StimulusTrace.ENABLED)
          },
          new LogicSubscriptionSpec[] {
              new LogicSubscriptionSpec(".*",
                                        "PropertyResponse",
                                        "PropertyResponse",
                                        "@",
                                        TransactionFilter.DISABLED)
          });
  }

  @Override
  protected void evaluate ()
  {
    PropertyResponse propertyResp = getStimulus("PropertyResponse");

    if (isTransactionOriginator(propertyResp.getTransactionID()))
    {
      UUID respTransactionID =
          getResponseTransactionID(propertyResp.getTransactionID());

      setStimulus("ClusterResponse",
                  new ClusterResponse(propertyResp.propertyValue),
                  respTransactionID);

      terminateTransaction(propertyResp.getTransactionID());
    }
  }
}
