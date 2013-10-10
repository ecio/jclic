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

package quicktime.std.qtcomponents;

import quicktime.QTException;
import quicktime.util.QTHandleRef;
import quicktime.std.movies.Movie;
import quicktime.std.movies.Track;

public final class MovieImporter
{
    public MovieImporter(int i) throws QTException {}
    public MovieImportInfo fromHandle(QTHandleRef qthandleref, Movie movie, Track track, int i, int j) throws QTException {return null;}
}
