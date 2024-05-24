package com.helloWorld.helloWorld.common.utils;

import java.util.Collection;
import java.util.Map;

public class StringUtils extends org.apache.commons.lang3.StringUtils{

    private static final String NULLSTR = "";
    private static final String EMPTY_JSON = "{}";

    private static final char SEPARATOR = '_';

    public static boolean isNull( Object object ) {
        return object == null;
    }

    public static boolean isEmpty( Collection<?> coll ) {
        return isNull( coll ) || coll.isEmpty();
    }
    public static boolean isNotEmpty( String str ) {
        return !isEmpty( str );
    }

    public static boolean isNotNull( Object object ) {
        return !isNull( object );
    }

    public static String trim( String str ) {
        return ( str == null ? "" : str.trim() );
    }

    public static String toUnderScoreCase( String str ) {
        if ( str == null ) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // Whether the leading character is capitalized
        boolean preCharIsUpperCase = true;
        // Whether the current character is uppercase or not
        boolean curreCharIsUpperCase = true;
        // Whether the next character is capitalized
        boolean nexteCharIsUpperCase = true;
        for ( int i = 0; i < str.length(); i++ ) {
            char c = str.charAt( i );
            if ( i > 0 ) {
                preCharIsUpperCase = Character.isUpperCase( str.charAt( i - 1 ) );
            } else {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase( c );

            if ( i < ( str.length() - 1 ) ) {
                nexteCharIsUpperCase = Character.isUpperCase( str.charAt( i + 1 ) );
            }

            if ( preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase ) {
                sb.append( SEPARATOR );
            } else if ( ( i != 0 && !preCharIsUpperCase ) && curreCharIsUpperCase ) {
                sb.append( SEPARATOR );
            }
            sb.append( Character.toLowerCase( c ) );
        }

        return sb.toString();
    }

}
