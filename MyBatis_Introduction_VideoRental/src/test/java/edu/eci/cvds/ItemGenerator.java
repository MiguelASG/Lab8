/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;
import static org.quicktheories.generators.StringsDSL.*;

/**
 *
 * @author 2128408
 */
public class ItemGenerator {
    
	public static Gen<Item> items(){
        return id().zip(nombre(), tarifaxDia(), (id, nombre, tarifaxDia) -> new Item(null, id, nombre, nombre, null, tarifaxDia, null, null));
    }
    
    private static Gen<String> nombre(){
        return strings().allPossible().ofLength(20);
    }
    
    private static Gen<Long> tarifaxDia(){
        return longs().from(1).upTo(1000000);
    } 
    
    private static Gen<Integer> id(){
        return integers().from(1).upTo(100000);
    }
    
    
}
