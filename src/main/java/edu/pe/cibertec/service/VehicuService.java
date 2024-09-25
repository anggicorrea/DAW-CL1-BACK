package edu.pe.cibertec.service;

import edu.pe.cibertec.dto.VehiculoRequest;

import java.io.IOException;

public interface VehicuService {
    String[] buscarVehiculo(VehiculoRequest vehiculoRequest) throws IOException;
}
