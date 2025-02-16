/* Copyright (c) 2025 Commence Software LLC.  All rights reserved. */

import neupaths.api.*;
import neupaths.stim.*;

import java.util.UUID;

public class ClusterRequestActivator extends Activator
{
  public ClusterRequestActivator ()
  {
    super("ClusterRequestActivator",
          new ReceptorSpec[] {
              new ReceptorSpec("ClusterRequest",
                               ReceptorMode.BUFFERED,
                               ClusterRequest.TYPE_ID)
          },
          new TransmitterSpec[] {
              new TransmitterSpec("PropertyRequest",
                                  PropertyRequest.TYPE_ID,
                                  StimulusTrace.ENABLED)
          },
          new LogicSubscriptionSpec[] {
              new LogicSubscriptionSpec(".*",
                                        "ClusterRequest",
                                        "ClusterRequest",
                                        "@",
                                        TransactionFilter.DISABLED)
          });
  }

  @Override
  protected void evaluate ()
  {
    ClusterRequest clusterReq = getStimulus("ClusterRequest");

    // Create transaction tied to original transaction
    UUID transactionID = createTransaction(clusterReq.getInstanceID(),
                                           clusterReq.getTransactionID());

    // Send PropertyRequest with new transaction
    setStimulus("PropertyRequest",
                new PropertyRequest(clusterReq.propertyName),
                transactionID);
  }
}
