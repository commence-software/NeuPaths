/* Copyright (c) 2025 Commence Software LLC.  All rights reserved. */

import neupaths.api.*;
import neupaths.stim.*;

public class PropertyRequestActivator extends Activator
{
  public PropertyRequestActivator ()
  {
    super("PropertyRequestActivator",
          new ReceptorSpec[] {
              new ReceptorSpec("PropertyRequest",
                               ReceptorMode.BUFFERED,
                               PropertyRequest.TYPE_ID)
          },
          new TransmitterSpec[] {
              new TransmitterSpec("PropertyResponse",
                                  PropertyResponse.TYPE_ID,
                                  StimulusTrace.ENABLED)
          },
          new LogicSubscriptionSpec[] {
              new LogicSubscriptionSpec(".*",
                                        "PropertyRequest",
                                        "PropertyRequest",
                                        "@",
                                        TransactionFilter.DISABLED)
          });
  }

  @Override
  protected void evaluate ()
  {
    PropertyRequest propertyReq = getStimulus("PropertyRequest");

    // Copy request's transaction ID to maintain transaction chain
    setStimulus("PropertyResponse",
                new PropertyResponse(getProperty(propertyReq.propertyName)),
                propertyReq.getTransactionID());
  }
}
