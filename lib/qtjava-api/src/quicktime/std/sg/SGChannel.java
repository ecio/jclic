/*
 * This is just an INCOMPLETE, EMPTY and NO-OPERATIONAL implementation of the 
 * QuickTime(TM) for Java library, based on the public API available at: 
 * http://developer.apple.com/documentation/Java/Reference/1.4.1/Java141API_QTJ
 *
 * The information contained in this file is used only at compile-time to make 
 * possible the complete build process of JClic without external non-free 
 * dependencies. 
 *
 * A full operational version of the library is available at:
 * http://developer.apple.com/quicktime/qtjava
 */

package quicktime.std.sg;

import quicktime.std.StdQTException;

public abstract class SGChannel
{
    SGChannel(SequenceGrabber sequencegrabber, int i) throws StdQTException {}
    public void setUsage(int i) throws StdQTException{}
}
