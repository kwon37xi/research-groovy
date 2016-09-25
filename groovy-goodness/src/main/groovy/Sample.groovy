class Sample {
    // Groovy adds getDEFAULT(), but not setDEFAULT() - because of 'final'

    static final String DEFAULT = 'default'

    // Groovy adds getMessage()/setMessage()
    String message;

    // Groovy makes method public
    void message(final String newMessage) {
        this.message = message
    }
}

/*
$ javap -p -constants Sample

Compiled from "Sample.groovy"
public class Sample implements groovy.lang.GroovyObject {

  // private Java에서는 상수에 접근불가. 그러나 groovy에서는 Sample.DEFAULT 가능(자동으로 getDEFAULT()호출)
  // Java에서 호출하고 싶다면 public static final String DEFAULT...로 변경해야함.
  private static final java.lang.String DEFAULT = "default";

  private java.lang.String message;
  ...
  ---
  public void message(java.lang.String);
  public static final java.lang.String getDEFAULT();
  public java.lang.String getMessage();
  public void setMessage(java.lang.String);
  ---
  ...
}

 */