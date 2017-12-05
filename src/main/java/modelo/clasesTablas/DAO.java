package modelo.clasesTablas;

//import com.mysql.jdbc.Statement;
import jdk.nashorn.internal.runtime.ECMAException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.util.ArrayList;

public abstract class DAO {

    //Field[]
    Field[] atributos;
    String user="root",pass="dsa.upc",url="jdbc:mysql://localhost:3306/prueba";

    //INSERT INTO Track (id, name, desc) VALUES (?, ?, ?)
    public String getInsert() throws Exception{
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(this.getClass().getSimpleName().substring(0,1).toLowerCase()+this.getClass().getSimpleName().substring(1,this.getClass().getSimpleName().length())).append(" ("); //Track
        atributos = this.getClass().getDeclaredFields();
        for (Field f:atributos) {
            sb.append(f.getName()).append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(") VALUES (");
        for (Field f:atributos) {
            sb.append("?,");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(")");
        //sb.append(") VALUES (?,?,?)");
        System.out.println(sb);
        return sb.toString();
    }

    public void insert() throws InvocationTargetException, IllegalAccessException {
        try{
            String query = getInsert();
            Connection c = DriverManager.getConnection(url,user,pass);
            PreparedStatement statement=c.prepareStatement(query);

            Method[] metodos=this.getClass().getMethods();
            Object[] cosasBonitas = new Object[atributos.length];
            for (int i=0;i<atributos.length;i++)
            {
                int j;
                String ab="get"+atributos[i].getName().substring(0,1).toUpperCase()+atributos[i].getName().substring(1,atributos[i].getName().length());

                for (j=0;j<metodos.length;j++)
                {
                    //metodos.toString().con
                    String nombre=metodos[j].toString();
                    if (nombre.contains("get"+atributos[i].getName().substring(0,1).toUpperCase()+atributos[i].getName().substring(1,atributos[i].getName().length())))
                    {
                        break;
                    }
                }
                int abc=j;
                cosasBonitas[i]= metodos[j].invoke(this,null);//INVOKE ES LA CLAVE

                //System.out.println(cosasBonitas[i].toString()+" ");
                statement.setObject(i+1, cosasBonitas[i] );

            }
            statement.executeUpdate();
            int a=0;
            statement.close();
            c.close();
        }catch (Exception e){
            int a=0;
        }

    }



    // SELECT * FROM Track WHERE id=?
    public ArrayList<Object[]> select(/*String[] datos,String[] id,Object[] obj*/){
        ArrayList<Object[]> resultado=null;
        try {
            StringBuffer sb = new StringBuffer("SELECT * FROM ");
            sb.append(this.getClass().getSimpleName().substring(0, 1).toLowerCase() + this.getClass().getSimpleName().substring(1, this.getClass().getSimpleName().length())); //Track
            //sb.append(this.getClass().getSimpleName());
            //sb.append(bdname);
            sb.append(" WHERE ");
            atributos=getClass().getDeclaredFields();
            String metodo="";
            for(Field f:atributos){
                if(Modifier.isFinal(f.getModifiers())){
                    sb.append(f.getName()).append("=?");
                    metodo="get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1,f.getName().length());
                    break;
                }
            }

            String query = sb.toString();
            Connection c = DriverManager.getConnection(url,user,pass);
            PreparedStatement statement = c.prepareStatement(query);
            Method[] metodos=getClass().getMethods();
            for(Method m:metodos){
                if(m.toString().contains(metodo)){
                    statement.setObject(1,m.invoke(this,null));
                    break;
                }
            }

            ResultSet rs=statement.executeQuery();
            resultado=new ArrayList<Object[]>();
            //String frase="";
            while(rs.next()) {
                Object[] fila=new Object[atributos.length];
                for(int i=0;i<atributos.length;i++){
                    fila[i]=rs.getObject(atributos[i].getName());
                    //frase=frase+rs.getObject(datos[i]).toString()+" ";
                }
                //frase=frase+"\n";
                resultado.add(fila);
            }
            //System.out.println(frase);
            statement.close();
            c.close();

        }catch (Exception e){

        }
        return resultado;


    }

    // UPDATE Track SET name=?, desc=? WHERE id=?

    public void update(){
        StringBuffer sb=new StringBuffer("UPDATE ");
        sb.append(this.getClass().getSimpleName().substring(0, 1).toLowerCase() + this.getClass().getSimpleName().substring(1, this.getClass().getSimpleName().length()));
        sb.append(" SET ");
        atributos=this.getClass().getDeclaredFields();
        Field ident=atributos[0];//Se queja por no estar inicializado
        for (Field f:atributos) {
            if(!Modifier.isFinal(f.getModifiers())) {
                sb.append(f.getName()).append("=?, ");
            }else{ident=f;}
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(" WHERE ");
        sb.append(ident.getName()).append("=?");
        try{
            String query=sb.toString();
            Connection c=DriverManager.getConnection(url,user,pass);
            PreparedStatement statement=c.prepareStatement(query);
            int i=1;
            Method[] metodos=getClass().getMethods();
            for(Field f:atributos){

                int j;
                String metodo="get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1,f.getName().length());
                for(j=0;j<metodos.length;j++){
                    if(metodos[j].toString().contains(metodo))
                    {
                        break;
                    }

                }


                if(!Modifier.isFinal(f.getModifiers())) {
                    statement.setObject(i,metodos[j].invoke(this,null));
                    i++;
                }else{
                    statement.setObject(atributos.length,metodos[j].invoke(this,null));
                }
            }
            statement.executeUpdate();
            statement.close();
            c.close();

        }catch (Exception e){}

    }



    // DELETE FROM Track WHERE id=?
    public void delete(){
        StringBuffer sb = new StringBuffer("DELETE FROM ");
        sb.append(this.getClass().getSimpleName().substring(0, 1).toLowerCase() + this.getClass().getSimpleName().substring(1, this.getClass().getSimpleName().length()));
        //sb.append(this.getClass().getSimpleName());
        sb.append(" WHERE ");
        atributos=getClass().getDeclaredFields();
        String metodo="";
        for(Field f:atributos){
            if(Modifier.isFinal(f.getModifiers())){
                sb.append(f.getName()).append("=?");
                metodo="get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1,f.getName().length());
                break;
            }
        }
        //sb.append(cond1+"=?");
        String query=sb.toString();
        try{
            Connection c=DriverManager.getConnection(url, user,pass);
            PreparedStatement statement=c.prepareStatement(query);
            Method[] metodos=getClass().getMethods();
            for(Method m:metodos){
                if(m.toString().contains(metodo))
                {
                    statement.setObject(1,m.invoke(this,null));
                    break;
                }
            }
            //statement.setObject(1,cond2);
            statement.executeUpdate();
            statement.close();
            c.close();

        }catch(Exception e){

        }

    }

}
