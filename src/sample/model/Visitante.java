package Final.model;

public class Visitante {

    //DATOS PERSONALES
    private String nombres;
    private String apellidos;
    private String id;
    private String tipoID;
    private String estadoCivil;
    private char genero;

    //DATOS LOCALIZACION
    private String ciudad;
    private String direccion;
    private String telefono;
    private String celular;

    //DATOS SINTOMAS
    private boolean gusto;
    private boolean garganta;
    private boolean malestar;
    private boolean diarrea;
    private boolean fiebre;
    private boolean tos;
    private boolean erupcion;
    private boolean conjuntivitis;
    private String tempMedida;

    public Visitante(String nombres, String apellidos, String id, String tipoID, String estadoCivil, char genero, String ciudad, String direccion, String telefono, String celular, boolean gusto, boolean garganta, boolean malestar, boolean diarrea, boolean fiebre, boolean tos, boolean erupcion, boolean conjuntivitis, String tempMedida) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.tipoID = tipoID;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.gusto = gusto;
        this.garganta = garganta;
        this.malestar = malestar;
        this.diarrea = diarrea;
        this.fiebre = fiebre;
        this.tos = tos;
        this.erupcion = erupcion;
        this.conjuntivitis = conjuntivitis;
        this.tempMedida = tempMedida;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isGusto() {
        return gusto;
    }

    public void setGusto(boolean gusto) {
        this.gusto = gusto;
    }

    public boolean isGarganta() {
        return garganta;
    }

    public void setGarganta(boolean garganta) {
        this.garganta = garganta;
    }

    public boolean isMalestar() {
        return malestar;
    }

    public void setMalestar(boolean malestar) {
        this.malestar = malestar;
    }

    public boolean isDiarrea() {
        return diarrea;
    }

    public void setDiarrea(boolean diarrea) {
        this.diarrea = diarrea;
    }

    public boolean isFiebre() {
        return fiebre;
    }

    public void setFiebre(boolean fiebre) {
        this.fiebre = fiebre;
    }

    public boolean isTos() {
        return tos;
    }

    public void setTos(boolean tos) {
        this.tos = tos;
    }

    public boolean isErupcion() {
        return erupcion;
    }

    public void setErupcion(boolean erupcion) {
        this.erupcion = erupcion;
    }

    public boolean isConjuntivitis() {
        return conjuntivitis;
    }

    public void setConjuntivitis(boolean conjuntivitis) {
        this.conjuntivitis = conjuntivitis;
    }

    public String getTempMedida() {
        return tempMedida;
    }

    public void setTempMedida(String tempMedida) {
        this.tempMedida = tempMedida;
    }
}
