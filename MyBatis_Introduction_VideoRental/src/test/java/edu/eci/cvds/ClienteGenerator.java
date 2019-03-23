/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds;


import edu.eci.cvds.samples.entities.Cliente;
import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import java.util.Random;
import static org.quicktheories.generators.SourceDSL.*;
import static org.quicktheories.generators.StringsDSL.*;

/**
 *
 * @author 2128408
 */
public class ClienteGenerator {
    
    public static Gen<Cliente> clients(){
        return nombre().zip(documento(), telefono(), vetado(), (nombre, documento, telefono, vetado) -> new Cliente(nombre, documento, telefono, telefono, nombre, vetado, null));
    }
    
    private static Gen<String> nombre(){
        return strings().allPossible().ofLength(20);
    }
    
    private static Gen<Long> documento(){
        return longs().from(1).upTo(1000000);
    } 
    
    private static Gen<String> telefono(){
        return strings().allPossible().ofLength(20);
    }
    
    private static Gen<Boolean> vetado(){
        return Generate.booleans();
    }
    
    
}
