/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import java.sql.SQLException;
/**
 *
 * @author 2128408
 */
public class MyBATISClienteDAO implements ClienteDAO{
    
    @Inject
    private ClienteMapper ClienteMapper;
    
    @Override
    public void save(Cliente cl) throws PersistenceException{
    try{
        ClienteMapper.insertarCliente(cl);
    }
    catch(org.apache.ibatis.exceptions.PersistenceException e){
        throw new PersistenceException("Error al registrar el cliente "+cl.toString(),e);
        }
    }
    
    @Override
    public Cliente load(int id) throws PersistenceException {
    try{
        return ClienteMapper.consultarCliente(id);
    }
    catch(org.apache.ibatis.exceptions.PersistenceException e){
        throw new PersistenceException("Error al consultar el cliente "+id,e);
    }


    }
    
    
}
