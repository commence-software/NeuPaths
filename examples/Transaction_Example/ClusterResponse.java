/* Copyright (c) 2025 Commence Software LLC.  All rights reserved. */

import java.util.UUID;
import neupaths.api.Stimulus;

public final class ClusterResponse extends Stimulus
{
  // Constructor.  Add parameters as necessary to initialize members.
  public ClusterResponse (String propertyValue)
  {
    super(TYPE_NAME, TYPE_ID);
    this.propertyValue = propertyValue;
  }

  // Constructor to be used for creating aliases of this type.
  // Add parameers as necessary to initialize members.
    protected ClusterResponse (String typeName, String propertyValue)
  {
    super(typeName, TYPE_ID);
    this.propertyValue = propertyValue;
  }

  public String toString()
  {
    return TYPE_NAME;
  }

  String propertyValue;

  // Add stimulus members here
  public static final String TYPE_NAME = "ClusterResponseStimulus";
  public static final UUID TYPE_ID = UUID.fromString("29c6deae-a837-4fb5-bf8d-82e18fbf4d86");
}
