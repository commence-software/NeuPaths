WorldHello_Example

Source code for the WorldHello example in the SDK User Guide.  The "cfg"
subdirectory contains the Cluster and Cell definition files.  After execution,
the worldhello_request_events.out and worldhello_reply_events.out files
contain the trace log for the Request and Reply domains respectively.

To compile:
  javac -cp neupaths.jar:. *.java

To execute:
  java -cp neupaths.jar:. Main

