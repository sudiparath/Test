package com.pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


	

public class CountItemsList<E> extends ArrayList<E> { 

    // This is private. It is not visible from outside.
    private Map<E,Integer> count = new HashMap<E,Integer>();

    // There are several entry points to this class
    // this is just to show one of them.
    public boolean add( E element  ) { 
        if( !count.containsKey( element ) ){
            count.put( element, 1 );
        } else { 
            count.put( element, count.get( element ) + 1 );
        }
        return super.add( element );
    }

    public int getCount( E element ) { 
        if( ! count.containsKey( element ) ) {
            return 0;
        }
        return count.get( element );
    }

    public static void main( String [] args ) { 
        List<String> animals = new CountItemsList<String>();
        animals.add("bat");
        

        System.out.println( (( CountItemsList<String> )animals).getCount( "bat" ));
    }
}

	
