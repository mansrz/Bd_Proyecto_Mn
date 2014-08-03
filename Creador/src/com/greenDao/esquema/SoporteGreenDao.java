package com.greenDao.esquema;
 



import de.greenrobot.daogenerator.*;
public class SoporteGreenDao {
	public static void main(String[] arg){
		try{
		Schema esquema = new Schema(1, "com.greenDao.esquema");
		crearEntidad(esquema);
		new DaoGenerator().generateAll(esquema,"../AsistenteTecnico/src");
		
		}catch(Exception ex){
			System.out.print(ex);
		}
	}

	private static void crearEntidad(Schema schema)
    {
        try {
        //Añadimos una tabla al Esquema o BD
        Entity Jugador = schema.addEntity("Jugador");
        //Creamos un campo ID de tipo autonumérico
        Jugador.addIdProperty();
        //Se añaden los campos Usuario y Password, que no admitirán valores nulos
        Jugador.addStringProperty("Nombre").notNull();
        Jugador.addStringProperty("Apellido").notNull();
        Jugador.addStringProperty("Poscicion").notNull();
        
        
        Entity Equipo= schema.addEntity("Equipo");
        //Creamos un campo ID de tipo autonumérico
        Equipo.addIdProperty();
        //Se añaden los campos Usuario y Password, que no admitirán valores nulos
        Equipo.addStringProperty("Nombre").notNull();
        Equipo.addStringProperty("Categoria").notNull();
        
        
        
        Entity Partido = schema.addEntity("Partido");
        //Creamos un campo ID de tipo autonumérico
        Partido.addIdProperty();
        //Se añaden los campos Usuario y Password, que no admitirán valores nulos
        Partido.addIntProperty("Oponente").notNull();
        
        Partido.addDateProperty("Fecha").notNull();
        Partido.addStringProperty("Hora").notNull();
        Partido.addIntProperty("GolesOponente").notNull();
        Partido.addIntProperty("GolesLocal").notNull();
        Partido.addStringProperty("Notas").notNull();
        Partido.addStringProperty("Lugar").notNull();
        
        Property local = Partido.addLongProperty("Local").getProperty();
        // Definición de la relación 1 a N. Relación Tipo(1) ->>> (N)Receta
        ToMany equipo = Equipo.addToMany(Partido, local);
        equipo.setName("Partidos");
        // Relación Tipo(1) <<<- (N)Receta
        Partido.addToOne(Equipo, local);
        
        /*
        Property idTipo = receta.addLongProperty("idTipo").getProperty();
        // Definición de la relación 1 a N. Relación Tipo(1) ->>> (N)Receta
        ToMany tipoAReceta = tipo.addToMany(receta, idTipo);
        tipoAReceta.setName("recetas");
        // Relación Tipo(1) <<<- (N)Receta
        receta.addToOne(tipo, idTipo);*/
        
        
        
    }catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }
}
