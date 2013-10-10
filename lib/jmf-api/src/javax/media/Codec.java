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

package javax.media;

import javax.media.*;

public interface Codec extends javax.media.PlugIn  {

    public Format [] getSupportedInputFormats();
    public Format [] getSupportedOutputFormats(Format input);
    public Format setInputFormat(Format format);
    public Format setOutputFormat(Format format);
    public int process(Buffer input, Buffer output);

}

