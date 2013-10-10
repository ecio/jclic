/*
 * This is just an INCOMPLETE, EMPTY and NO-OPERATIONAL implementation of the 
 * Java Media Framework library, based on the public API available at: 
 * http://java.sun.com/products/java-media/jmf/2.1.1/apidocs
 *
 * The information contained in this file is used only at compile-time to make 
 * possible the complete build process of JClic without external non-free 
 * dependencies. 
 *
 * A full operational version of the library is available at:
 * http://java.sun.com/products/java-media/jmf
 */

package javax.media.datasink;

import javax.media.*;

public class DataSinkEvent extends javax.media.MediaEvent {
    public DataSinkEvent(DataSink from) {super(from);}
    //public DataSinkEvent(DataSink from, String reason) {}
    public DataSink getSourceDataSink() {return null;}
}

