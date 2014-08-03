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
        //A�adimos una tabla al Esquema o BD
        Entity Jugador = schema.addEntity("Jugador");
        //Creamos un campo ID de tipo autonum�rico
        Jugador.addIdProperty();
        //Se a�aden los campos Usuario y Password, que no admitir�n valores nulos
        Jugador.addStringProperty("Nombre").notNull();
        Jugador.addStringProperty("Apellido").notNull();
        Jugador.addStringProperty("Poscicion").notNull();
        
        
        Entity Equipo= schema.addEntity("Equipo");
        //Creamos un campo ID de tipo autonum�rico
        Equipo.addIdProperty();
        //Se a�aden los campos Usuario y Password, que no admitir�n valores nulos
        Equipo.addStringProperty("Nombre").notNull();
        Equipo.addStringProperty("Categoria").notNull();
        
        
        
        Entity Partido = schema.addEntity("Partido");
        //Creamos un campo ID de tipo autonum�rico
        Partido.addIdProperty();
        //Se a�aden los campos Usuario y Password, que no admitir�n valores nulos
        Partido.addIntProperty("Oponente").notNull();
        
        Partido.addDateProperty("Fecha").notNull();
        Partido.addStringProperty("Hora").notNull();
        Partido.addIntProperty("GolesOponente").notNull();
        Partido.addIntProperty("GolesLocal").notNull();
        Partido.addStringProperty("Notas").notNull();
        Partido.addStringProperty("Lugar").notNull();
        
        Property local = Partido.addLongProperty("Local").getProperty();
        // Definici�n de la relaci�n 1 a N. Relaci�n Tipo(1) ->>> (N)Receta
        ToMany equipo = Equipo.addToMany(Partido, local);
        equipo.setName("Partidos");
        // Relaci�n Tipo(1) <<<- (N)Receta
        Partido.addToOne(Equipo, local);
        
        /*
        Property idTipo = receta.addLongProperty("idTipo").getProperty();
        // Definici�n de la relaci�n 1 a N. Relaci�n Tipo(1) ->>> (N)Receta
        ToMany tipoAReceta = tipo.addToMany(receta, idTipo);
        tipoAReceta.setName("recetas");
        // Relaci�n Tipo(1) <<<- (N)Receta
        receta.addToOne(tipo, idTipo);*/
        
        
        
    }catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }
}
