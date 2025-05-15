package logica;

import java.util.List;
import persistencia.controladoraPersistencia;

public class controladora {
    controladoraPersistencia controladoraPersis = new controladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nombreDuenio, String celDuenio, String alergico, String atenEsp) {
        Duenio duenio = new Duenio();
        duenio.setNombreDuenio(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        masco.setUnDuenio(duenio);
        
        controladoraPersis.guardar(duenio,masco);
    }

    public List<Mascota> traerMascotas() {
        return controladoraPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
       controladoraPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascotas(int num_cliente) {
        return controladoraPersis.traerMascota (num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        
        controladoraPersis.modificarMascota(masco);
        
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombreDuenio(nombreDuenio);
        
        this.modificarDuenio(dueno);
    }
    
    

    private Duenio buscarDuenio(int id_duenio) {
        return controladoraPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controladoraPersis.modificarDuenio(dueno);
    }
}
