package com.proyecto.modelo;

public class EquipoFutbol {
    private int id;
    private String nombre;
    private String eslogan;
    private String tecnico;
    private String pais;
    private String ciudad;
    private String categoria;
    private int numGoles;
    private int numPartidosJugados;
    private int numPartidosGanados;
    private int numCampeonatos;
    private int numExpulsiones;
    private int numEmpates;

    public EquipoFutbol() {}

    public EquipoFutbol(int id, String nombre, String eslogan, String tecnico, String pais, String ciudad,
                        String categoria, int numGoles, int numPartidosJugados, int numPartidosGanados,
                        int numCampeonatos, int numExpulsiones, int numEmpates) {
        this.id = id;
        this.nombre = nombre;
        this.eslogan = eslogan;
        this.tecnico = tecnico;
        this.pais = pais;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.numGoles = numGoles;
        this.numPartidosJugados = numPartidosJugados;
        this.numPartidosGanados = numPartidosGanados;
        this.numCampeonatos = numCampeonatos;
        this.numExpulsiones = numExpulsiones;
        this.numEmpates = numEmpates;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEslogan() { return eslogan; }
    public void setEslogan(String eslogan) { this.eslogan = eslogan; }
    public String getTecnico() { return tecnico; }
    public void setTecnico(String tecnico) { this.tecnico = tecnico; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public int getNumGoles() { return numGoles; }
    public void setNumGoles(int numGoles) { this.numGoles = numGoles; }
    public int getNumPartidosJugados() { return numPartidosJugados; }
    public void setNumPartidosJugados(int numPartidosJugados) { this.numPartidosJugados = numPartidosJugados; }
    public int getNumPartidosGanados() { return numPartidosGanados; }
    public void setNumPartidosGanados(int numPartidosGanados) { this.numPartidosGanados = numPartidosGanados; }
    public int getNumCampeonatos() { return numCampeonatos; }
    public void setNumCampeonatos(int numCampeonatos) { this.numCampeonatos = numCampeonatos; }
    public int getNumExpulsiones() { return numExpulsiones; }
    public void setNumExpulsiones(int numExpulsiones) { this.numExpulsiones = numExpulsiones; }
    public int getNumEmpates() { return numEmpates; }
    public void setNumEmpates(int numEmpates) { this.numEmpates = numEmpates; }
}
