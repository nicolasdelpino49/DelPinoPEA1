
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class PracticaDelPino {

    public static void main(String[] args, String Nombre) {
        String practica = "no ok";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String _url = "jdbc:mysql: //localhost/dispositivos?user=root&password=delpino123";
            Connection connect = DriverManager.getConnection(_url);
            Statement statement = connect.createStatement();
            String _query = "Select * from dospositivo";
            ResultSet resultSet = statement.executeQuery(_query);
            
            while (resultSet.next()) {
                int idProducto = resultSet.getInt("nombre");
                String desProd = resultSet.getString("precio");
                int precio = resultSet.getInt("tipo");
                System.out.println("Nom: " + idProducto);
                System.out.println("precio " + desProd);
                System.out.println("tipo " + precio);
                System.out.println("------------------------\n");
            }

            Scanner scan = new Scanner(System.in);
            System.out.println("¿Qué deseas hacer: Insertar / Borrar/ Actualizar / Consultar");
            String accion = scan.nextLine();

            if (accion.equals("Registrar")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresar el Nombre");
                String idProd = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el Precio");
                String descProd = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el Tipo");
                String precio = scan.nextLine();
                _query = "Insert INTO dispositivos values(?,?,?)";
                PreparedStatement ps = connect.prepareStatement(_query);
                ps.setInt(1, Integer.parseInt(Nombre));
                ps.setString(2, descProd);
                ps.setInt(3, Integer.parseInt(precio));
                ps.executeUpdate();

            } else if (accion.equals("Borrar")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el Nombre");
                String idProd = scan.nextLine();
                _query = "Delete from dispositivos where nombre = ? ";
                PreparedStatement ps = connect.prepareCall(_query);
                ps.setInt(1, Integer.parseInt(idProd));
                ps.executeUpdate();
            } else if (accion.equals("Actualizar")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el Nombre");
                String idProd = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el Precio");
                String descProd = scan.nextLine();

                

                scan= new Scanner(System.in);
                System.err.println("1 Ingresa el precio");
                  int precio = scan.nextInt();
                _query= "{call Insert_producto(?, ?)}";
                CallableStatement stmt = connect.prepareCall(_query);
                stmt.setString(1, descProd);
                stmt.setInt(2, precio);
                stmt.execute();
                       
                resultSet.close();
                statement.close();
                connect.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
  }

   
    

